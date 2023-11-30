package com.chillsrestaurant.app.services;

import java.util.List;

import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.entities.dto.EditOrderDTO;
import com.chillsrestaurant.app.entities.dto.OrderDTO;
import com.chillsrestaurant.app.entities.response.OrderResponse;

public interface OrderService {
    public List<OrderResponse> findAllOrders();

    public List<OrderResponse> addAnOrder(OrderDTO order);

    public List<OrderResponse> deleteOrder(Order order);

    public List<OrderResponse> updateOrder(EditOrderDTO updateOrder);
}
