package pl.sda.springtraining.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public String showProducts(@RequestParam(required = false) String query, @RequestParam(required = false) String productType, Model model) {
        model.addAttribute("productsList", productService.findProducts(query,productType));
        model.addAttribute("queryValue",query);
        model.addAttribute("selectedProductType", productType);
        model.addAttribute("productTypes",ProductType.values());
        return "products";
    }
}
