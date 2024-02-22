package service;

import model.Product;

import java.util.List;

public interface ProductService {
    void create(Product product);

    void findById(int id);

    List<Product> findAll();

    boolean delete(Product product);

    void update(Product product);

}
