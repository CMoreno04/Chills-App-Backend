package com.chillisrestaurant.app.entities;

import java.util.Base64;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class FoodProductDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String description;
    private String name;
    private String category;
    private String image;

    public FoodProductDTO(FoodProduct foodProduct) {
        this.id = foodProduct.getId();
        this.price = foodProduct.getPrice();
        this.description = foodProduct.getDescription();
        this.name = foodProduct.getName();
        this.category = foodProduct.getCategory();
        this.image = Base64.getEncoder().encodeToString(foodProduct.getImageBlob());
    }
      
}
