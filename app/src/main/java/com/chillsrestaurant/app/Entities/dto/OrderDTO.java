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
    private UserDto customer;
    private String status;
    private List<OrderMenuItemDto> menuItems;
    private String details;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserDto {
        private Integer id;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderMenuItemDto {
        private Long id;
        private String name;
        private Integer quantity;
        private String notes;
    }
}
