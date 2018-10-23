package pl.sda.springtraining.spring.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public String showProducts(Model model) {
        model.addAttribute("productsList", productService.findProducts());
        return "products";
    }

}
