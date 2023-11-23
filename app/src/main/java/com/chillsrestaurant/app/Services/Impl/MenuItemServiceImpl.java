package com.chillsrestaurant.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chillsrestaurant.app.entities.dto.MenuItemDTO;
import com.chillsrestaurant.app.repositories.MenuItemRepository;
import com.chillsrestaurant.app.services.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItemDTO> getAllProducts() {
        List<MenuItemDTO> menuItemsDtos = new ArrayList<>();
        this.menuItemRepository.findAll().stream().forEach(product -> menuItemsDtos.add(new MenuItemDTO(product)));
        return menuItemsDtos;
    }

    public List<MenuItemDTO> deleteMenuItem(Long id) {
         List<MenuItemDTO> menuItemsDtos = new ArrayList<>();
         
        try {
            this.menuItemRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        this.menuItemRepository.findAll().stream()
        .forEach(product -> menuItemsDtos.add(new MenuItemDTO(product)));
        
        return menuItemsDtos;
    }
}