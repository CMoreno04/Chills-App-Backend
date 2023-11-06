package com.chillsrestaurant.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.entities.dto.OrderDTO;
import com.chillsrestaurant.app.repositories.OrderRepository;
import com.chillsrestaurant.app.services.OrderService;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(OrderDTO newOrder) {
        return orderRepository.save(null);
    }
    

}
