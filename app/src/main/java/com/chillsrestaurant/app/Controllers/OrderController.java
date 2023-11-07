package com.chillsrestaurant.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.services.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    @Operation(summary = "Provides All Orders in Database")
    public List<Order> getAllOrders() {
        return this.orderService.findAllOrders();
    }

    @GetMapping("/delete")
    @Operation(summary = "Provides All Orders in Database")
    public List<Order> deleteOrder(@RequestBody Order order) {

        return   this.orderService.deleteOrder(order) ? this.orderService.findAllOrders() : null;
    }

    @PostMapping("/create")
    @Operation(summary = "Creates Order and returns updated list of all orders")
    public List<Order> createOrder(@Parameter(description = "Expects a Order Object") Order newOrder) {
        return this.createOrder(newOrder);
    }
}
