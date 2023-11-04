package com.chillsrestaurant.app.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chillsrestaurant.app.Entities.MenuItemDTO;
import com.chillsrestaurant.app.Repositories.MenuItemRepository;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository MenuItemRepository;

    public List<MenuItemDTO> getAllProducts() {
        List<MenuItemDTO> productsDtos = new ArrayList<>();

        this.MenuItemRepository.findAll().stream().forEach(product -> productsDtos.add(new MenuItemDTO(product)));
        
        return productsDtos ;
    }
}