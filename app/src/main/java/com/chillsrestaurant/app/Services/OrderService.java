package com.chillsrestaurant.app.services;

import java.util.List;

import com.chillsrestaurant.app.entities.Order;

public interface OrderService {
    public List<Order> findAllOrders();

    public List<Order> addAnOrder(Order order);

    public boolean deleteOrder(Order order);
}
