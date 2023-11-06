package com.chillsrestaurant.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chillsrestaurant.app.entities.dto.MenuItemResponse;
import com.chillsrestaurant.app.repositories.MenuItemRepository;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository MenuItemRepository;

    public List<MenuItemResponse> getAllProducts() {
        List<MenuItemResponse> productsDtos = new ArrayList<>();

        this.MenuItemRepository.findAll().stream().forEach(product -> productsDtos.add(null));
        
        return productsDtos ;
    }
}