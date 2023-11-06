package com.chillsrestaurant.app.services;

import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.entities.dto.OrderDTO;

public interface OrderService {
    public Order createOrder(OrderDTO newOrder);
}
