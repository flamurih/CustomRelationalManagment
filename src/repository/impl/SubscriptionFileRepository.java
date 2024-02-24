package repository.impl;

import entity.ContactData;
import entity.ProductData;
import entity.SubscriptionData;
import exception.CustomerException;
import exception.SubscriptionException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import mapper.ProductMapper;
import mapper.SubscriptionMapper;
import model.Contract;
import model.Product;
import model.Subscription;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.TelecomRepository;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubscriptionFileRepository implements TelecomRepository<Subscription> {
    private SessionFactory sessionFactory;
    private SubscriptionMapper mapper;
    private EntityManager entityManager;

    public SubscriptionFileRepository() throws SubscriptionException{
        try{
            Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(SubscriptionData.class)
                    .buildSessionFactory();
        }
        catch(HibernateException e){
            throw new CustomerException(e);
        }
    }
    @Override
    public void create(Subscription subscription) {
        try(Session session = sessionFactory.openSession()){
            SubscriptionData subscriptionData = mapper.toSubscriptionData(subscription);
            Transaction trx = session.beginTransaction();
            session.persist(subscriptionData);
            trx.commit();
        }catch (HibernateException e){
            throw new SubscriptionException(e);
        }
    }

    @Override
    public Subscription findById(int id) {
        Subscription subscription;
        try (Session session = sessionFactory.openSession())
        {
            SubscriptionData subscriptionData = session.createNamedQuery("SubscriptionData.findById", SubscriptionData.class)
                    .setParameter("id", id)
                    .getSingleResult();
            subscription = mapper.fromSubscriptionData(subscriptionData);
        }
        return subscription;
    }

    @Override
    public List<Subscription> findAll() {
        List<Subscription> subscriptionList;
        try (Session session = sessionFactory.openSession())
        {
            List<SubscriptionData> resultList = session.createNamedQuery("SubscriptionData.findAll", SubscriptionData.class)
                    .getResultList();
            subscriptionList = mapper.fromSubscriptionData(resultList);
        }
        return subscriptionList;
    }

    @Override
    public boolean deleteById(int id) {
        try (Session session = sessionFactory.openSession())
        {
            SubscriptionData subscriptionData = session.createNamedQuery("SubscriptionData.findById", SubscriptionData.class)
                    .setParameter("id", id)
                    .getSingleResult();
            if (Objects.nonNull(subscriptionData))
            {
                Transaction trx = session.beginTransaction();
                session.remove(subscriptionData);
                trx.commit();
                return true;
            }
            return false;
        }
        catch(NoResultException nre){
            return false;
        }
        catch (HibernateException e)
        {
            throw new SubscriptionException(e);
        }
    }

    @Override
    public void update(Subscription subscription) {
        try (Session session = sessionFactory.openSession())
        {
            SubscriptionData subscriptionData = mapper.toSubscriptionData(subscription);
            Transaction trx = session.beginTransaction();
            session.merge(subscriptionData);
            trx.commit();
        }
        catch (HibernateException e)
        {
            throw new SubscriptionException(e);
        }
    }


}
