package com.chillsrestaurant.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chillsrestaurant.app.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    
}
