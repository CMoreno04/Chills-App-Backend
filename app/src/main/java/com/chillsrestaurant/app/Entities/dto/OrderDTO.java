package com.chillsrestaurant.app.entities.dto;


import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private Date orderTime;
    private String status; // Assuming you want to send the status as a String
    private String notes;
    private CustomerDTO customer; // Custom DTO for customer details
    private EmployeeDTO employee; // Custom DTO for employee details
    private List<OrderItemDTO> orderItems; // Custom DTO for order items

    // Inner DTO classes can be static if they don't need access to the outer class's members
    @Getter
    @Setter
    @NoArgsConstructor
    public static class CustomerDTO {
        private Long id;
        private String name; // Add other customer details you want to expose via the DTO
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class EmployeeDTO {
        private Long id;
        private String name; // Add other employee details you want to expose via the DTO
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class OrderItemDTO {
        private Long id;
        private MenuItemDTO menuItem;
        private int quantity;
        private String specialInstructions;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class MenuItemDTO {
        private Long id;
        private String name; // Add other menu item details you want to expose via the DTO
        // ... potentially more fields like price, description, etc.
    }
    
    // No-args constructor, getters and setters are handled by Lombok annotations
}