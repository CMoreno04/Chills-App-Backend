package com.chillsrestaurant.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chillsrestaurant.app.entities.OrderMenuItem;

@Repository
public interface OrderMenuItemRepository extends JpaRepository<OrderMenuItem, Long> {

}
