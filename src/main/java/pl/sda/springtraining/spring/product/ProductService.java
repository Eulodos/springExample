package pl.sda.springtraining.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void createNewProduct(String productName, Integer stockAmount, BigDecimal price) {
        Product product = new Product();
        product.setProductName(productName);
        product.setStockAmount(stockAmount);
        product.setPrice(price);

        productDAO.saveProduct(product);
    }

    public List<Product> findProducts() {
        return productDAO.findProducts();
    }

    public Optional<Product> findProductById(Long id) {
        return productDAO.findProductById(id);
    }

    //todo: zmienic product na productDTO
    public void updateProduct(Product product) {
        Product productById = productDAO.findProductById(product.getId()).get();
        productById.setProductName(product.getProductName());
        productById.setStockAmount(product.getStockAmount());
        productById.setPrice(product.getPrice());

        productDAO.saveProduct(productById);
    }
}
