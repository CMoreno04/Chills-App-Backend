package com.chillsrestaurant.app.entities.dto;

import java.util.Base64;

import com.chillsrestaurant.app.entities.MenuItem;

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

    public MenuItemDTO(MenuItem menuItem) {
        this.id = menuItem.getId();
        this.price = menuItem.getPrice();
        this.description = menuItem.getDescription();
        this.name = menuItem.getName();
        this.category = menuItem.getCategory();
        this.image = Base64.getEncoder().encodeToString(menuItem.getImageBlob());
    }

}
