package me.ayushdhar.productservice.DTOs;

import lombok.Getter;
import lombok.Setter;
import me.ayushdhar.productservice.models.Category;

@Getter
@Setter
public class fakeStoreCategoryDTO {
    String title;
    public Category toCategory() {
        Category category = new Category();
        category.setTitle(this.title);
        return category;
    }
}
