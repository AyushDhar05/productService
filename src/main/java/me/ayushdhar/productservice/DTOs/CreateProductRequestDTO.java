package me.ayushdhar.productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
//    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
