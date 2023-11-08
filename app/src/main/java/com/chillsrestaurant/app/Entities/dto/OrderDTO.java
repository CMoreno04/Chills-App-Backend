package com.chillsrestaurant.app.entities.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Date submitTime;
    private CustomerDto customer;
    private String status;
    private List<OrderMenuItemDto> menuItems;
    private String details;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CustomerDto {
        private Integer id;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderMenuItemDto {
        private Long id;
        private Integer quantity;
        private String notes;
    }
}
