package com.chillsrestaurant.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chillsrestaurant.app.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
