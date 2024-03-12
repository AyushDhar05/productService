package me.ayushdhar.productservice.services;
import me.ayushdhar.productservice.models.Product;
import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getAllProducts();

    Product createProduct(String title,
                          double price,
                          String category,
                          String description,
                          String image);
}
