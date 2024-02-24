package repository.impl;

import entity.ContractData;
import exception.ContractException;
import jakarta.persistence.NoResultException;
import mapper.ContractMapper;
import model.Contract;
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

public class ContractFileRepository implements TelecomRepository<Contract> {
    private ContractMapper mapper;
    private SessionFactory sessionFactory;

    public ContractFileRepository() throws ContractException {
        try{
            Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(ContractData.class)
                    .buildSessionFactory();
        }
        catch(HibernateException e){
            throw new ContractException(e);
        }
    }
    @Override
    public void create(Contract contract) {
        try(Session session = sessionFactory.openSession()){
            ContractData contractData = mapper.toContractData(contract);
            Transaction trx = session.beginTransaction();
            session.persist(contractData);
            trx.commit();
        }catch (HibernateException e){
            throw new ContractException(e);
        }
    }

    @Override
    public Contract findById(int id) {
        Contract contract;
        try (Session session = sessionFactory.openSession())
        {
            ContractData contractData = session.createNamedQuery("ContractData.findById", ContractData.class)
                    .setParameter("id", id)
                    .getSingleResult();
            contract = mapper.fromContractData(contractData);
        }
        return contract;
    }

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList;
        try (Session session = sessionFactory.openSession())
        {
            List<ContractData> resultList = session.createNamedQuery("ContractData.findAll", ContractData.class)
                    .getResultList();
            contractList = mapper.fromContractData(resultList);
        }
        return contractList;
    }

    @Override
    public boolean deleteById(int id) {
        try (Session session = sessionFactory.openSession())
        {
            ContractData contractData = session.createNamedQuery("ContractData.findById", ContractData.class)
                    .setParameter("id", id)
                    .getSingleResult();
            if (Objects.nonNull(contractData))
            {
                Transaction trx = session.beginTransaction();
                session.remove(contractData);
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
            throw new ContractException(e);
        }
    }

    @Override
    public void update(Contract contract) {
        try (Session session = sessionFactory.openSession())
        {
            ContractData contractData = mapper.toContractData(contract);
            Transaction trx = session.beginTransaction();
            session.merge(contractData);
            trx.commit();
        }
        catch (HibernateException e)
        {
            throw new ContractException(e);
        }
    }

}
