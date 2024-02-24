package repository.impl;

import entity.ContactData;
import exception.ContactException;
import jakarta.persistence.NoResultException;
import mapper.ContactMapper;
import model.Contact;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repository.ContactRepository;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactFileRepository implements ContactRepository {
    private ContactMapper mapper;
    private SessionFactory sessionFactory;
    public ContactFileRepository() {
        try{
            Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(ContactData.class)
                    .buildSessionFactory();

        }
        catch(HibernateException e){
            throw new ContactException(e);
        }
    }
    @Override
    public void create(Contact contact) {
        try (Session session = sessionFactory.openSession()) {
            ContactData contactData = mapper.toContactData(contact);
            Transaction trx = session.beginTransaction();
            session.persist(contactData);
            trx.commit();
        } catch (HibernateException e) {
            throw new ContactException(e);
        }
    }

    @Override
    public Contact findById(int id) {
        Contact contact;
        try (Session session = sessionFactory.openSession())
        {
            ContactData contactData = session.createNamedQuery("ContactData.findById", ContactData.class)
                    .setParameter("id", id)
                    .getSingleResult();
            contact = mapper.fromContactData(contactData);
        }
        return contact;
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> contactList;
        try (Session session = sessionFactory.openSession())
        {
            List<ContactData> resultList = session.createNamedQuery("ContactData.findAll", ContactData.class)
                    .getResultList();
            contactList = mapper.fromContactData(resultList);
        }
        return contactList;
    }

    @Override
    public boolean deleteById(int id) {
        try (Session session = sessionFactory.openSession())
        {
            ContactData contactData = session.createNamedQuery("ContactData.findById", ContactData.class)
                    .setParameter("id", id)
                    .getSingleResult();
            if (Objects.nonNull(contactData))
            {
                Transaction trx = session.beginTransaction();
                session.remove(contactData);
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
            throw new ContactException(e);
        }
    }

    @Override
    public void update(Contact contact) {
        try (Session session = sessionFactory.openSession())
        {
            ContactData contactData = mapper.toContactData(contact);
            Transaction trx = session.beginTransaction();
            session.merge(contactData);
            trx.commit();
        }
        catch (HibernateException e)
        {
            throw new ContactException(e);
        }
    }

}
