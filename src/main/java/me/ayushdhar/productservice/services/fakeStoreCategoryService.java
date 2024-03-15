package me.ayushdhar.productservice.services;

import me.ayushdhar.productservice.DTOs.fakeStoreCategoryDTO;
import me.ayushdhar.productservice.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreCategoryService")
public class fakeStoreCategoryService implements CategoryService{

    private RestTemplate restTemplate;
    public fakeStoreCategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Category> getAllCategories() {
        String[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",
                String[].class);
        ArrayList<Category> al = new ArrayList<>();
        for(String str : response) {
            Category category = new Category();
            category.setTitle(str);
            al.add(category);
        }
        return al;
    }
}
