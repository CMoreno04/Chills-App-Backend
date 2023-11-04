package com.chillisrestaurant.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chillisrestaurant.app.entities.FoodProductDTO;
import com.chillisrestaurant.app.services.FoodProductService;

@RestController
@RequestMapping("/food")
public class FoodProductController {

    @Autowired
    private FoodProductService foodProductService;

    @GetMapping("/all")
    public ResponseEntity<List<FoodProductDTO>> getAllFoodProducts() {
        return  ResponseEntity.ok(this.foodProductService.getAllProducts());
    }
}
