package pl.sda.springtraining.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO newProduct = productService.createNewProduct(productDTO.getProductName(), productDTO.getStockAmount(), productDTO.getPrice());
        return ResponseEntity.status(201).body(newProduct);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductDTO>> showProducts(@RequestParam(required = false) String query) {
        return ResponseEntity.ok(productService.findProducts(query));
    }
}
