package service;

import model.Product;

import java.util.List;

public interface ProductService {
    void create(Product product);

    void findById(int id);

    List<Product> findAll();

    boolean delete(int id);

    void update(Product product);

}
