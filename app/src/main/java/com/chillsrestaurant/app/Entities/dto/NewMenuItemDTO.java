package com.chillsrestaurant.app.entities.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewMenuItemDTO {
    private String name;
    private String price;
    private String description;
    private String category;
    private String availability;
    private MultipartFile image;
}
