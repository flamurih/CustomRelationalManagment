package repository.impl;

import entity.CustomerData;
import exception.CustomerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import mapper.CustomerMapper;
import model.Customer;
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

public class CustomerFileRepository implements TelecomRepository<Customer> {
    EntityManager entityManager;
    private SessionFactory sessionFactory;
    private CustomerMapper mapper;


    public CustomerFileRepository() throws CustomerException{
        try{
            Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(CustomerData.class)
                    .buildSessionFactory();
        }
        catch(HibernateException e){
            throw new CustomerException(e);
        }
    }
    @Override
    public void create(Customer customer) {
        try(Session session = sessionFactory.openSession()){
            CustomerData customerData = mapper.toCustomerData(customer);
            Transaction trx = session.beginTransaction();
            session.persist(customerData);
            trx.commit();
        }catch (HibernateException e){
            throw new CustomerException(e);
        }
    }

    @Override
    public Customer findById(int id) {
        Customer customer;
        try (Session session = sessionFactory.openSession())
        {
            CustomerData customerData = session.createNamedQuery("CustomerData.findById", CustomerData.class)
                    .setParameter("id", id)
                    .getSingleResult();
            customer = mapper.fromCustomerData(customerData);
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList;
        try (Session session = sessionFactory.openSession())
        {
            List<CustomerData> resultList = session.createNamedQuery("CustomerData.findAll", CustomerData.class)
                    .getResultList();
            customerList = mapper.fromCustomerData(resultList);
        }
        return customerList;
    }

    @Override
    public boolean deleteById(int id) {
        try (Session session = sessionFactory.openSession())
        {
            CustomerData customerData = session.createNamedQuery("CustomerData.findById", CustomerData.class)
                    .setParameter("id", id)
                    .getSingleResult();
            if (Objects.nonNull(customerData))
            {
                Transaction trx = session.beginTransaction();
                session.remove(customerData);
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
            throw new CustomerException(e);
        }
    }

    @Override
    public void update(Customer customer) {
        try (Session session = sessionFactory.openSession())
        {
            CustomerData customerData = mapper.toCustomerData(customer);
            Transaction trx = session.beginTransaction();
            session.merge(customerData);
            trx.commit();
        }
        catch (HibernateException e)
        {
            throw new CustomerException(e);
        }
    }

    public List<CustomerData> findSubscribersByProduct(String productName) {
        TypedQuery<CustomerData> query = entityManager.createQuery(
                "SELECT DISTINCT c FROM Customers c " +
                        "JOIN s.subscriptions sub " +
                        "JOIN sub.services se " +
                        "JOIN se.product p " +
                        "WHERE p.name = :productName", CustomerData.class);
        query.setParameter("productName", productName);
        return query.getResultList();
    }
}
