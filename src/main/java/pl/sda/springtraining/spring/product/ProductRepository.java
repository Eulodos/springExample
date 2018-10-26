package pl.sda.springtraining.spring.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE UPPER(p.productName) " +
            "LIKE concat('%',UPPER(?1),'%') ")
    List<Product> findProductsByProductNameLike(String query);

    @Query("SELECT p FROM Product p WHERE UPPER(p.productName) " +
            "LIKE concat('%',UPPER(?1),'%') AND p.productType=?2")
    List<Product> findProductsByProductNameLikeAndProductType(String query, ProductType pt);

    List<Product> findProductsByProductType(ProductType pt);
}
