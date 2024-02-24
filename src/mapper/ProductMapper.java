package mapper;

import entity.ProductData;
import exception.ContractException;
import model.Product;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public Product fromProductData(ProductData productData){
        return new Product(productData.getId(),productData.getName(), productData.getPrice(),productData.getFromDateTime(),productData.getToDateTime(),productData.getServices());
    }

    public ProductData toProductData(Product product){
        return new ProductData(product.getId(),product.getName(), product.getPrice(),product.getFromDateTime(),product.getToDateTime(),product.getServices());
    }

    public List<Product> fromProductData(List<ProductData> products) throws ContractException {
        return products.stream().map(this::fromProductData).collect(Collectors.toList());
    }
}
