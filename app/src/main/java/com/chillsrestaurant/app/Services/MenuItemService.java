package com.chillsrestaurant.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chillsrestaurant.app.entities.dto.MenuItemDTO;
import com.chillsrestaurant.app.repositories.MenuItemRepository;

@Service
public class MenuItemService {

    private final MenuItemRepository MenuItemRepository;

    public MenuItemService(com.chillsrestaurant.app.repositories.MenuItemRepository menuItemRepository) {
        MenuItemRepository = menuItemRepository;
    }

    public List<MenuItemDTO> getAllProducts() {
        List<MenuItemDTO> productsDtos = new ArrayList<>();

        this.MenuItemRepository.findAll().stream().forEach(product -> productsDtos.add(new MenuItemDTO(product)));

        return productsDtos;
    }
}