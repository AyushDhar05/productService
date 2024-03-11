package me.ayushdhar.productservice.services;
import me.ayushdhar.productservice.models.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class fakeStoreProductService implements ProductService{

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
