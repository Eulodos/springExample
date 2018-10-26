package pl.sda.springtraining.spring.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
public class ProductDTO implements ProductInfoHolder {

    private Integer id;
    private String productName;
    private Integer stockAmount;
    private BigDecimal price;
    private ProductType productType;

    private String productTypeValue; //trick

    public void setProductType(ProductType productType) {
        this.productType = productType;
        this.productTypeValue = Optional.ofNullable(productType)
                .map(p -> p.name()).orElse("");
    }

    public ProductType getProductType() {
        return productType == null ?
                ProductType.findProductTypeByName(productTypeValue)
                : productType;
    }

    public String getSomething() {
        return "STH";
    }


}
