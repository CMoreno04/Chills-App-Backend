package com.chillsrestaurant.app.entities.dto;

import java.util.List;
import com.chillsrestaurant.app.entities.OrderMenuItem;

import lombok.Data;

@Data
public class EditOrderDTO {

    private Long number;
    private String owner;
    private String status;
    private List<OrderMenuItem> items;
}
