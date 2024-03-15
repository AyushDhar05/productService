package me.ayushdhar.productservice.services;

import me.ayushdhar.productservice.exceptions.ProductNotFoundException;
import me.ayushdhar.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    @Override
    public  Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(String title, double price, String category, String description, String image) {

        return null;
    }

    @Override
    public Product updateProduct(Long productId, String title, double price, String category, String description, String image) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {
        return;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return null;
    }

}
