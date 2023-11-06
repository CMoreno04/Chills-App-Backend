package com.chillsrestaurant.app.entities.dto;

import lombok.Data;

@Data
public class MenuItemResponse {

    private Long id;
    private double price;
    private String description;
    private String name;
    private String category;
    private String image;

    

}
