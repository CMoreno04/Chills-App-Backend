package com.chillsrestaurant.app.entities.dto;

import java.util.Date;
import java.util.List;

import com.chillsrestaurant.app.entities.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long number;
    private Date submitTime;
    private OrderStatus status;
    private String notes;
    private CustomerDTO customer;
    private List<OrderItemDTO> items;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CustomerDTO {
        private Long id;
        private String name;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EmployeeDTO {
        private Long id;
        private String name;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderItemDTO {
        private Long id;
        private MenuItemDTO menuItem;
        private int quantity;
        private String specialInstructions;
    }

    @Data
    public class MenuItemDTO {

        private Long id;
        private double price;
        private String description;
        private String name;
        private String category;
        private String image;
    }
}