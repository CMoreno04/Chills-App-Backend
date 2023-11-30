package com.chillsrestaurant.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.chillsrestaurant.app.entities.MenuItem;
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

        try {
            this.menuItemRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        return this.getAllProducts();
    }

    @Override
    public List<MenuItemDTO> createMenuItem(MenuItemDTO newMenuItem) {

        try {
            MenuItem menuItem = MenuItem.builder().name(newMenuItem.getName()).price(newMenuItem.getPrice())
                    .imageBlob(newMenuItem.getImage().getBytes()).category(newMenuItem.getCategory())
                    .build();
            this.menuItemRepository.save(menuItem);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            System.err.println(e.getMessage());
        }

        return this.getAllProducts();
    }
}