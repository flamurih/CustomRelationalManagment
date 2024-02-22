package repository.impl;

import model.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductFileRepository implements ProductRepository {
    @Override
    public void create(Product product) {

    }

    @Override
    public void findById(int id) {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public void update(Product entity) {

    }
}
