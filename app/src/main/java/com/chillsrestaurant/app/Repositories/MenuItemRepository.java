package com.chillsrestaurant.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chillsrestaurant.app.entities.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
