package me.ayushdhar.productservice.services;

import me.ayushdhar.productservice.models.Product;

import java.util.List;

public class OwnDatabaseProductService implements ProductService {
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

}
