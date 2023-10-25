package com.chillisrestaurant.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chillisrestaurant.app.Entities.FoodProduct;
import com.chillisrestaurant.app.Repositories.FoodProductRepository;

@Service
public class FoodProductService {

    @Autowired
    private FoodProductRepository foodProductRepository;

    public List<FoodProduct> getAllProducts() {
        return foodProductRepository.findAll();
    }
}
