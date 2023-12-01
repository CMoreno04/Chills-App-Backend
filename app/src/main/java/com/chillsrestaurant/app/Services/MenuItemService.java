package com.chillsrestaurant.app.services;

import java.util.List;

import com.chillsrestaurant.app.entities.dto.MenuItemDTO;
import com.chillsrestaurant.app.entities.dto.NewMenuItemDTO;

public interface MenuItemService {
     public List<MenuItemDTO> getAllProducts();
     public List<MenuItemDTO> deleteMenuItem(Long id);
     public List<MenuItemDTO> createMenuItem(NewMenuItemDTO menuItem);
}
