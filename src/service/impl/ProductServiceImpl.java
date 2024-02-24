package service.impl;

import model.Product;
import repository.ProductRepository;
import repository.impl.ProductFileRepository;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    public ProductServiceImpl(){
        this.productRepository = new ProductFileRepository();
    }
    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void findById(int id) {
        productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }


}
