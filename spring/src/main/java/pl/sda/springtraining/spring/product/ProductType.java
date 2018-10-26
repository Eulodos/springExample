package pl.sda.springtraining.spring.product;


import lombok.Getter;

import java.util.Arrays;

public enum ProductType {

    BOOK("Książka"), FISH("Ryby"),FOOD("Jedzenie");

    @Getter
    private String polishName;

    ProductType(String polishName) {
        this.polishName = polishName;
    }

    public static ProductType findProductTypeByName(String name) {
        return Arrays.stream(ProductType.values())
                .filter(p -> p.name().equals(name))
                .findFirst()
                .orElse(null);
    }
}
