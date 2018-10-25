package pl.sda.springtraining.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductDAO productDAO;
    private final ProductToProductDTOBuilder productToProductDTOBuilder;

    @Autowired
    public ProductService(ProductDAO productDAO, ProductToProductDTOBuilder productToProductDTOBuilder) {
        this.productDAO = productDAO;
        this.productToProductDTOBuilder = productToProductDTOBuilder;
    }

    public ProductDTO createNewProduct(String productName, Integer stockAmount, BigDecimal price) {
        Product product = new Product();
        product.setProductName(productName);
        product.setStockAmount(stockAmount);
        product.setPrice(price);
        return productToProductDTOBuilder.rewriteProductToProductDTO(productDAO.saveProduct(product));
    }

    public List<ProductDTO> findProducts(String query) {
        return productDAO.findProducts(query).stream()
                .map(p -> productToProductDTOBuilder.rewriteProductToProductDTO(p))
                .collect(Collectors.toList());
    }

    public Optional<Product> findProductById(Integer id) {
       return productDAO.findProductById(id);
    }

    public void updateProduct(Product product) { // todo zmienic product na DTO
        Product productById = productDAO.findProductById(product.getId()).get();
        productById.setProductName(product.getProductName());
        productById.setStockAmount(product.getStockAmount());
        productById.setPrice(product.getPrice());
        productDAO.saveProduct(productById);
    }
}
