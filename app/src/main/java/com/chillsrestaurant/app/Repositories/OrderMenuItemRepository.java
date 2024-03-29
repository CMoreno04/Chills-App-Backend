package com.chillsrestaurant.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.entities.OrderMenuItem;

@Repository
public interface OrderMenuItemRepository extends JpaRepository<OrderMenuItem, Long> {

    public List<OrderMenuItem> deleteByOrder(Order updatedOrder);

    public void deleteAllByOrderIdAndMenuItemIdIn(Order updatedOrder, List<Long> itemIdsToDelete);

    public List<OrderMenuItem> findAllByOrderIdAndMenuItemIdIn(Long id, List<Long> itemIdsToDelete);

    public void deleteAllByOrderIdAndMenuItemIdIn(Long id, List<Long> itemIdsToDelete);

}
