package me.ayushdhar.productservice.services;
import me.ayushdhar.productservice.DTOs.FakeStoreProductDTO;
import me.ayushdhar.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class fakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public fakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreProductDTO fakeStoreProduct = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+productId,
                FakeStoreProductDTO.class);
        return fakeStoreProduct.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(String title,
                                 double price,
                                 String category,
                                 String description,
                                 String image) {

        FakeStoreProductDTO fSDTO = new FakeStoreProductDTO();
        fSDTO.setTitle(title);
        fSDTO.setPrice(price);
        fSDTO.setCategory(category);
        fSDTO.setDescription(description);
        fSDTO.setImage(image);

        FakeStoreProductDTO response = restTemplate.patchForObject(
                "https://fakestoreapi.com/products",
                fSDTO,
                FakeStoreProductDTO.class
        );
        return response.toProduct();
    }

}
