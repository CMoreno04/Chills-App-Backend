package com.chillsrestaurant.app.entities.response;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.entities.OrderStatus;
import com.chillsrestaurant.app.entities.dto.OrderDTO.OrderMenuItemDto;
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
    private List<OrderMenuItemDto> items;
    private String notes;

    public OrderResponse(Order order) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.orderMenuItemMapper = new OrderMenuItemMapperImpl();
        this.number = order.getId();
        this.submitTime = dateFormat.format(order.getSubmitTime());
        this.owner = order.getCustomer().getUsername();
        this.status = mapStatusToString(order.getStatus());
        this.items = order.getOrderMenuItems().stream()
                .map(item -> this.orderMenuItemMapper.orderMenuItemToOrderMenuItemDto(item))
                .collect(Collectors.toList());
        this.notes = order.getDetails();
    }

    private String mapStatusToString(OrderStatus status) {
        switch (status) {
            case IN_PROGRESS:
                return "In Progress";
            case PENDING:
                return "Pending";
            case COMPLETED:
                return "Completed";
            case CANCELLED:
                return "Cancelled";
            case PENDING_PAYMENT:
                return "Pending Payment";
            default:
                throw new IllegalArgumentException("Invalid status string: " + status);
        }
    }
}
