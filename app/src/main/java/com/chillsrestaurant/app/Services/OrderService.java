package com.chillsrestaurant.app.services;

import java.util.List;

import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.entities.dto.EditOrderDTO;
import com.chillsrestaurant.app.entities.dto.OrderDTO;
import com.chillsrestaurant.app.entities.response.OrderResponse;

public interface OrderService {
    public List<OrderResponse> findAllOrders();

    public List<Order> addAnOrder(OrderDTO order);

    public boolean deleteOrder(Order order);

    public boolean updateOrder(EditOrderDTO updateOrder);
}
