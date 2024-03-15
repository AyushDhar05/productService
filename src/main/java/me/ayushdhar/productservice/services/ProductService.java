package me.ayushdhar.productservice.services;
import me.ayushdhar.productservice.exceptions.ProductNotFoundException;
import me.ayushdhar.productservice.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();

    Product createProduct(String title,
                          double price,
                          String category,
                          String description,
                          String image) throws ProductNotFoundException;

    Product updateProduct(Long productId,
                          String title,
                          double price,
                          String category,
                          String description,
                          String image);

    void deleteProduct(Long productId);

    List<Product> getProductsByCategory(String category);
}
