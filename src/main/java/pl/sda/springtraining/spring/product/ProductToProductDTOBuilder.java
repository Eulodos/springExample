package pl.sda.springtraining.spring.product;

import org.springframework.stereotype.Component;

@Component
public class ProductToProductDTOBuilder {

    public ProductDTO rewriteProductToProductDTO(Product product) {
        return (ProductDTO) rewriteFields(product, new ProductDTO());
    }

    public Product rewriteProductDTOToProduct(ProductDTO productDTO) {
        return (Product) rewriteFields(productDTO, new Product());
    }

    private ProductInfoHolder rewriteFields(ProductInfoHolder source, ProductInfoHolder target) {
        target.setId(source.getId());
        target.setProductName(source.getProductName());
        target.setStockAmount(source.getStockAmount());
        target.setPrice(source.getPrice());
        return target;
    }
}
