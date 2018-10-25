package pl.sda.springtraining.spring.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO implements ProductInfoHolder {

    private Integer id;
    private String productName;
    private Integer stockAmount;
    private BigDecimal price;
}
