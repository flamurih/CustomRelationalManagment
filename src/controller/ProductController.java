package controller;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import java.util.List;

public class ProductController {
    private ProductService productService;

    public ProductController(){
        this.productService = new ProductServiceImpl();
    }

    public void add(Product product){
        productService.create(product);
        System.out.printf("%s added. %n",product);
    }

    public void delete(Product product){
        boolean deleted = productService.delete(product);
        System.out.printf("Consumer deleted. %b%n",deleted);
    }

    public void list(){
        List<Product> productList = productService.findAll();
        productList.stream().forEach(System.out::println);
    }
}
