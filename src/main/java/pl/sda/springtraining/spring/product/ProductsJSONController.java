package pl.sda.springtraining.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsJSONController {

    private ProductService productService;

    @Autowired
    public ProductsJSONController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "productsjson")
    @ResponseBody
    public ResponseEntity<List<Product>> showProducts() {
        return ResponseEntity.ok().body(productService.findProducts());
    }

    @GetMapping(value = "productsjson/{id}")
    @ResponseBody
    public ResponseEntity<Product> showProducts(@PathVariable Long id ) {
        return ResponseEntity.ok().body(productService.findProductById(id).orElse(null));
    }


}
