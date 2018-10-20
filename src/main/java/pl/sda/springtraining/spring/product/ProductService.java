package pl.sda.springtraining.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

        productDAO.saveNewProduct(product);
    }
}
