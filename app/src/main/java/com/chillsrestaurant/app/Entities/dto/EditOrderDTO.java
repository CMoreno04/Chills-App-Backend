package com.chillsrestaurant.app.entities.dto;

import java.util.List;

import com.chillsrestaurant.app.entities.dto.OrderDTO.OrderMenuItemDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditOrderDTO {

    private Long number;
    private String owner;
    private String status;
    private List<OrderMenuItemDto> items;
    private List<ItemsToDeleteDTO> itemsToDelete;
}
