package pl.sda.springtraining.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping(value = "/product/add")
    public String addProduct(@RequestParam String productName, @RequestParam Integer stockAmount, @RequestParam BigDecimal price, Model model) {
        productService.createNewProduct(productName, stockAmount, price);
        return "redirect:/products"; // Tworzy nowy request na URL /products
    }

    @GetMapping(value = "/product")
    public String addProduct() {
        return "addProduct";
    }

    @GetMapping
    public String showProducts(Model model) {
        model.addAttribute("productsList", productService.findProducts());
        return "products";
    }
}
