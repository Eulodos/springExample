package pl.sda.springtraining.spring.product;

import lombok.Getter;
import lombok.Setter;
import pl.sda.springtraining.spring.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product extends BaseEntity implements ProductInfoHolder {

    private String productName;
    private Integer stockAmount;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
}
