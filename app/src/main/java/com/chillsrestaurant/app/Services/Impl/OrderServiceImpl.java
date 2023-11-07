package com.chillsrestaurant.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.repositories.OrderRepository;
import com.chillsrestaurant.app.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public List<Order> addAnOrder(Order newOrder) {
        this.orderRepository.saveAndFlush(newOrder);
        return this.orderRepository.findAll();
    }

    @Override
    public boolean deleteOrder(Order order) {
        try {
            this.orderRepository.delete(order);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
