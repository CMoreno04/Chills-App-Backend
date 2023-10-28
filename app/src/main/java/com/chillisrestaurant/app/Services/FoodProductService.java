package com.chillisrestaurant.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chillisrestaurant.app.entities.FoodProductDTO;
import com.chillisrestaurant.app.repositories.FoodProductRepository;

@Service
public class FoodProductService {

    @Autowired
    private FoodProductRepository foodProductRepository;

    public List<FoodProductDTO> getAllProducts() {
        List<FoodProductDTO> productsDtos = new ArrayList<>();

        this.foodProductRepository.findAll().stream().forEach(product -> productsDtos.add(new FoodProductDTO(product)));
        
        return productsDtos ;
    }
}
