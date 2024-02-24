package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    public void create(Product product);
    public Product findById(int id);

    public List<Product> findAll();

    public boolean deleteById(int id);

    public void update(Product entity);

}
