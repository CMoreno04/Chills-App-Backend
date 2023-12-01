package com.chillsrestaurant.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chillsrestaurant.app.entities.MenuItem;
import com.chillsrestaurant.app.entities.dto.MenuItemDTO;
import com.chillsrestaurant.app.entities.dto.NewMenuItemDTO;
import com.chillsrestaurant.app.entities.mapper.MenuItemMapper;
import com.chillsrestaurant.app.repositories.MenuItemRepository;
import com.chillsrestaurant.app.services.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final MenuItemMapper menuItemMapper;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository, MenuItemMapper menuItemMapper) {
        this.menuItemRepository = menuItemRepository;
        this.menuItemMapper = menuItemMapper;
    }

    public List<MenuItemDTO> getAllProducts() {
        List<MenuItemDTO> menuItemsDtos = new ArrayList<>();
        this.menuItemRepository.findAll().stream().forEach(product -> menuItemsDtos.add(new MenuItemDTO(product)));
        return menuItemsDtos;
    }

    public List<MenuItemDTO> deleteMenuItem(Long id) {

        try {
            this.menuItemRepository.deleteById(id);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            System.err.println(e.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return this.getAllProducts();
    }

    @Override
    @Transactional
    public List<MenuItemDTO> createMenuItem(NewMenuItemDTO newMenuItem) {

        try {
            MenuItem menuItem = this.menuItemMapper.newMenuItemDtoToMenuItem(newMenuItem);
            System.err.println(menuItem.toString());
            this.menuItemRepository.save(menuItem);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            System.err.println(e.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return this.getAllProducts();
    }
}