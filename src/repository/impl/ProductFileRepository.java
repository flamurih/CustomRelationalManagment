package repository.impl;

import entity.ProductData;
import exception.CustomerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import mapper.ProductMapper;
import model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductFileRepository implements ProductRepository {
    private SessionFactory sessionFactory;
    private ProductMapper mapper;

    private EntityManager entityManager;

    public ProductFileRepository() throws CustomerException{
        try{
            Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(ProductData.class)
                    .buildSessionFactory();
        }
        catch(HibernateException e){
            throw new CustomerException(e);
        }
    }
    @Override
    public void create(Product product) {
        try(Session session = sessionFactory.openSession()){
            ProductData productData = mapper.toProductData(product);
            Transaction trx = session.beginTransaction();
            session.persist(productData);
            trx.commit();
        }catch (HibernateException e){
            throw new CustomerException(e);
        }
    }

    @Override
    public Product findById(int id) {
        Product product;
        try (Session session = sessionFactory.openSession())
        {
            ProductData productData = session.createNamedQuery("ProductData.findById", ProductData.class)
                    .setParameter("id", id)
                    .getSingleResult();
            product = mapper.fromProductData(productData);
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList;
        try (Session session = sessionFactory.openSession())
        {
            List<ProductData> resultList = session.createNamedQuery("ProductData.findAll", ProductData.class)
                    .getResultList();
            productList = mapper.fromProductData(resultList);
        }
        return productList;
    }

    @Override
    public boolean deleteById(int id) {
        try (Session session = sessionFactory.openSession())
        {
            ProductData productData = session.createNamedQuery("ProductData.findById", ProductData.class)
                    .setParameter("id", id)
                    .getSingleResult();
            if (Objects.nonNull(productData))
            {
                Transaction trx = session.beginTransaction();
                session.remove(productData);
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
    public void update(Product product) {
        try (Session session = sessionFactory.openSession())
        {
            ProductData productData = mapper.toProductData(product);
            Transaction trx = session.beginTransaction();
            session.merge(productData);
            trx.commit();
        }
        catch (HibernateException e)
        {
            throw new CustomerException(e);
        }
    }

    public List<Product> findProductsCheaperThan5Euros() {
        TypedQuery<Product> query = entityManager.createQuery(
                "SELECT p FROM Product p WHERE p.price < 5.0", Product.class);
        return query.getResultList();
    }

    public List<ProductData> findExpiringProducts(int days) {
        LocalDateTime expiryDate = LocalDateTime.now().plusDays(days);
        TypedQuery<ProductData> query = entityManager.createQuery(
                "SELECT p FROM Product p WHERE p.todatetime <= :expiryDate", ProductData.class);
        query.setParameter("expiryDate", expiryDate);
        return query.getResultList();
    }
}
