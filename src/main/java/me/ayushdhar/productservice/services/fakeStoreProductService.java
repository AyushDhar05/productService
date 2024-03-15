package me.ayushdhar.productservice.services;
import me.ayushdhar.productservice.DTOs.FakeStoreProductDTO;
import me.ayushdhar.productservice.exceptions.ProductNotFoundException;
import me.ayushdhar.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class fakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public fakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        FakeStoreProductDTO fakeStoreProduct = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+productId,
                FakeStoreProductDTO.class);
        if(fakeStoreProduct == null) {
            throw new ProductNotFoundException("Product with id "+productId+" not found. Please try again.");
        }
        return fakeStoreProduct.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProducts = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);
        List<Product> productList = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProduct : fakeStoreProducts) {
            productList.add(fakeStoreProduct.toProduct());
        }
        return productList;
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

        FakeStoreProductDTO response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fSDTO,
                FakeStoreProductDTO.class
        );
        return response.toProduct();
    }

    @Override
    public Product updateProduct(Long productId, String title, double price, String category, String description, String image) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.patchForObject(
                "https://fakestoreapi.com/products/"+productId,
                new FakeStoreProductDTO(productId, title, price, category, description, image),
                FakeStoreProductDTO.class);
        return fakeStoreProductDTO.toProduct();
    }

    @Override
    public void deleteProduct(Long productId) {
        restTemplate.delete("https://fakestoreapi.com/products/"+productId);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        FakeStoreProductDTO[] fakeStoreProductDTOs = restTemplate.getForObject(
                "https://fakestoreapi.com/products/category/"+category,
                FakeStoreProductDTO[].class);
        ArrayList<Product> al = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOs) {
            al.add(fakeStoreProductDTO.toProduct());
        }
        return al;
    }

}
