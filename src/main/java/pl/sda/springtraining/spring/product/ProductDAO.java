package pl.sda.springtraining.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDAO {

    private ProductRepository productRepository;

    @Autowired
    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveNewProduct(Product product) {
        productRepository.save(product);
    }

    //todo: DTO
    public List<Product> findProducts() {
        return productRepository.findAll();
    }
}
