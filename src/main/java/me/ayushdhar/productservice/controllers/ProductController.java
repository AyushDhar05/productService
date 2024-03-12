package me.ayushdhar.productservice.controllers;
import me.ayushdhar.productservice.DTOs.CreateProductRequestDTO;
import me.ayushdhar.productservice.models.Product;
import me.ayushdhar.productservice.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO newProductDTO) {
        return productService.createProduct(
                newProductDTO.getTitle(),
                newProductDTO.getPrice(),
                newProductDTO.getCategory(),
                newProductDTO.getDescription(),
                newProductDTO.getImage()
        );
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId) {
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/products")
    public void getAllProducts() {

    }
    public void updateProduct() {

    }
}
