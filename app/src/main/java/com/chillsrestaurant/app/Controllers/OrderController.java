package com.chillsrestaurant.app.controllers;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.entities.dto.OrderDTO;
import com.chillsrestaurant.app.entities.response.OrderResponse;
import com.chillsrestaurant.app.services.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    @Operation(summary = "Provides All Orders in Database")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return ResponseEntity.ok(this.orderService.findAllOrders());
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletes an order from the Database")
    public ResponseEntity<Void> deleteOrder(@RequestBody Order order) {
        return this.orderService.deleteOrder(order) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    @Operation(summary = "Creates Order and returns updated list of all orders")
    public ResponseEntity<List<Order>> createOrder(
            @Parameter(description = "Expects a Order Object") @RequestBody OrderDTO newOrder) {
        return ResponseEntity.ok(this.orderService.addAnOrder(newOrder));
    }

    @PutMapping("/update")
    @Operation(summary = "Updates and Order.")
    public ResponseEntity<Void> updateOrder(@RequestBody OrderDTO updateOrder) {
        return this.orderService.updateOrder(updateOrder) ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().build();
    }
}
