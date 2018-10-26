package pl.sda.springtraining.spring.product;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDAO {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findProducts(String query, String productType) {
        if (StringUtils.isBlank(query) && StringUtils.isBlank(productType)) {
            return productRepository.findAll();
        }
        if (StringUtils.isBlank(query)) {
            return productRepository.findProductsByProductType(ProductType.findProductTypeByName(productType));
        }
        if (StringUtils.isBlank(productType)) {
            return productRepository.findProductsByProductNameLike(query);
        }

        return productRepository.findProductsByProductNameLikeAndProductType(query,ProductType.findProductTypeByName(productType));
    }

    public Optional<Product> findProductById(Integer id) {
        return productRepository.findById(id);
    }

}
