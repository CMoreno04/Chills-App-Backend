package com.chillsrestaurant.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chillsrestaurant.app.Entities.MenuItem;


public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
