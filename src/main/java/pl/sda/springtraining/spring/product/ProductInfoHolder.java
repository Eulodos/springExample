package pl.sda.springtraining.spring.product;

public interface ProductInfoHolder {
    Integer getId();

    String getProductName();

    Integer getStockAmount();

    java.math.BigDecimal getPrice();

    ProductType getProductType();

    void setId(Integer id);

    void setProductName(String productName);

    void setStockAmount(Integer stockAmount);

    void setPrice(java.math.BigDecimal price);

    void setProductType(ProductType productType);
}
