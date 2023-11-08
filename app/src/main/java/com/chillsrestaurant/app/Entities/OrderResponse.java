package com.chillsrestaurant.app.entities;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import com.chillsrestaurant.app.entities.mapper.OrderMenuItemMapper;
import com.chillsrestaurant.app.entities.mapper.OrderMenuItemMapperImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class OrderResponse {

    @JsonIgnore
    private OrderMenuItemMapper orderMenuItemMapper;

    private Long number;
    private String submitTime;
    private String owner;
    private String status;
    private List<Object> items; // You should create a proper DTO for the items as well
    private String notes;

    public OrderResponse(Order order) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.orderMenuItemMapper = new OrderMenuItemMapperImpl();
        this.number = order.getId();
        this.submitTime = dateFormat.format(order.getSubmitTime());
        this.owner = order.getCustomer().getUsername(); // Assuming Customer has a getName() method
        this.status = order.getStatus().name();
        this.items = order.getOrderMenuItems().stream()
                .map(item -> this.orderMenuItemMapper.orderMenuItemToOrderMenuItemDto(item)) // Convert each OrderMenuItem to DTO                                                               
                .collect(Collectors.toList());
        this.notes = order.getDetails();
    }
}
