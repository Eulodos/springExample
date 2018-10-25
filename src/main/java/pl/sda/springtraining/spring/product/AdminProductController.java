package pl.sda.springtraining.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product/add")
    public String addProduct(@RequestParam String productName,
                             @RequestParam Integer stockAmount,
                             @RequestParam BigDecimal price) {
        productService.createNewProduct(productName, stockAmount, price);
        return "redirect:/products"; // tworzy nowy request na url /products
    }

    @GetMapping(value = "/product")
    public String addProduct() {
        return "addProduct";
    }

    @GetMapping(value = "/product/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        Optional<Product> optionalProduct = productService.findProductById(id);
        if (optionalProduct.isPresent()) {
            model.addAttribute("productToEdit", optionalProduct.get());
            return "editProduct";
        }
        return "redirect:/product";
    }

    @PostMapping(value = "/product/{id}")
    public String editProduct(@PathVariable Integer id, @ModelAttribute Product product) { // id nie jest niezbedne
        productService.updateProduct(product);
        return "redirect:/products";
    }
}
