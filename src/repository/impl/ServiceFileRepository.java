package repository.impl;

import entity.ContactData;
import entity.ServiceData;
import exception.CustomerException;
import exception.ServiceException;
import jakarta.persistence.NoResultException;
import mapper.ServiceMapper;
import model.Service;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.ServiceRepository;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceFileRepository implements ServiceRepository {

    private SessionFactory sessionFactory;
    private ServiceMapper mapper;
    public ServiceFileRepository() throws ServiceException{
        try{
            Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(ServiceData.class)
                    .buildSessionFactory();
        }
        catch(HibernateException e){
            throw new CustomerException(e);
        }
    }
    @Override
    public void create(Service service) {
        try(Session session = sessionFactory.openSession()){
            ServiceData serviceData = mapper.toServiceData(service);
            Transaction trx = session.beginTransaction();
            session.persist(serviceData);
            trx.commit();
        }catch (HibernateException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public Service findById(int id) {
        Service service;
        try (Session session = sessionFactory.openSession())
        {
            ServiceData serviceData = session.createNamedQuery("ServiceData.findById", ServiceData.class)
                    .setParameter("id", id)
                    .getSingleResult();
            service = mapper.fromServiceData(serviceData);
        }
        return service;
    }

    @Override
    public List<Service> findAll() {
        List<Service> serviceList;
        try (Session session = sessionFactory.openSession())
        {
            List<ServiceData> resultList = session.createNamedQuery("ServiceData.findAll", ServiceData.class)
                    .getResultList();
            serviceList = mapper.fromServiceData(resultList);
        }
        return serviceList;
    }

    @Override
    public boolean deleteById(int id) {
        try (Session session = sessionFactory.openSession())
        {
            ServiceData serviceData = session.createNamedQuery("ServiceData.findById", ServiceData.class)
                    .setParameter("id", id)
                    .getSingleResult();
            if (Objects.nonNull(serviceData))
            {
                Transaction trx = session.beginTransaction();
                session.remove(serviceData);
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
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Service service) {
        try (Session session = sessionFactory.openSession())
        {
            ServiceData serviceData = mapper.toServiceData(service);
            Transaction trx = session.beginTransaction();
            session.merge(serviceData);
            trx.commit();
        }
        catch (HibernateException e)
        {
            throw new ServiceException(e);
        }
    }


}
