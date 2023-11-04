package com.chillsrestaurant.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chillsrestaurant.app.Entities.MenuItemDTO;
import com.chillsrestaurant.app.Services.MenuItemService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/food")
public class MenuItemController {

    @Autowired
    private MenuItemService MenuItemService;

    @GetMapping("/all")
     @Operation(summary = "Provides All Menu Items in Database")
    public ResponseEntity<List<MenuItemDTO>> getAllMenuItems() {
        return  ResponseEntity.ok(this.MenuItemService.getAllProducts());
    }
}
