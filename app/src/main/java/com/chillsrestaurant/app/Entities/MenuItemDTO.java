package com.chillsrestaurant.app.Entities;

import java.util.Base64;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class MenuItemDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String description;
    private String name;
    private String category;
    private String image;

    public MenuItemDTO(MenuItem MenuItem) {
        this.id = MenuItem.getId();
        this.price = MenuItem.getPrice();
        this.description = MenuItem.getDescription();
        this.name = MenuItem.getName();
        this.category = MenuItem.getCategory();
        this.image = Base64.getEncoder().encodeToString(MenuItem.getImageBlob());
    }
      
}
