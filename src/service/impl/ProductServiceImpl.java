package service.impl;

import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    List<Product> productList = new ArrayList<>();
    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void findById(int id) {

    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean delete(Product product) {
        productList.remove(product);
        return true;
    }

    @Override
    public void update(Product product) {

    }


}
