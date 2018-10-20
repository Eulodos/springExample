package pl.sda.springtraining.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product")
    public String addProduct(@RequestParam String productName, @RequestParam Integer stockAmount, @RequestParam BigDecimal price) {
        productService.createNewProduct(productName,stockAmount,price);

        return "addProduct";
    }
}
