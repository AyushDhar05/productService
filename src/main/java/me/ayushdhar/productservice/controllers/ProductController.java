package me.ayushdhar.productservice.controllers;
import me.ayushdhar.productservice.DTOs.CreateProductRequestDTO;
import me.ayushdhar.productservice.exceptions.ProductNotFoundException;
import me.ayushdhar.productservice.models.Product;
import me.ayushdhar.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO newProductDTO) throws ProductNotFoundException {
        return productService.createProduct(
                newProductDTO.getTitle(),
                newProductDTO.getPrice(),
                newProductDTO.getCategory(),
                newProductDTO.getDescription(),
                newProductDTO.getImage()
        );
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId) throws ProductNotFoundException {
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long productId,
                                 @RequestBody CreateProductRequestDTO updateProductDTO) {
        return productService.updateProduct(productId,
                updateProductDTO.getTitle(),
                updateProductDTO.getPrice(),
                updateProductDTO.getCategory(),
                updateProductDTO.getDescription(),
                updateProductDTO.getImage()
        );
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
    }

    @GetMapping("/products/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category) {
        return productService.getProductsByCategory(category);
    }
}
