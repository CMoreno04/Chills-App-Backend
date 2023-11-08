package com.chillsrestaurant.app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chillsrestaurant.app.entities.dto.MenuItemDTO;
import com.chillsrestaurant.app.services.MenuItemService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/food")
public class MenuItemController {

    private final MenuItemService MenuItemService;

    public MenuItemController(com.chillsrestaurant.app.services.MenuItemService menuItemService) {
        MenuItemService = menuItemService;
    }

    @GetMapping("/all")
    @Operation(summary = "Provides All Menu Items in Database")
    public ResponseEntity<List<MenuItemDTO>> getAllMenuItems() {
        return ResponseEntity.ok(this.MenuItemService.getAllProducts());
    }
}
