package com.chillsrestaurant.app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chillsrestaurant.app.entities.dto.MenuItemDTO;
import com.chillsrestaurant.app.services.MenuItemService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/food")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(com.chillsrestaurant.app.services.MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping("/all")
    @Operation(summary = "Provides All Menu Items in Database")
    public ResponseEntity<List<MenuItemDTO>> getAllMenuItems() {
        return ResponseEntity.ok(this.menuItemService.getAllProducts());
    }

    @PostMapping("/add")
    @Operation(summary = "Adds Menu Items in Database")
    public ResponseEntity<List<MenuItemDTO>> addMenuItems(@RequestBody MenuItemDTO menuItemDTO) {
        return ResponseEntity.ok(this.menuItemService.createMenuItem(menuItemDTO));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Removes MenuItem from Database")
    public ResponseEntity<List<MenuItemDTO>> removeMenuItem(@RequestBody Long id) {
        return ResponseEntity.ok(this.menuItemService.deleteMenuItem(id));
    }

    
}
