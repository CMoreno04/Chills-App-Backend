package com.chillsrestaurant.app.mappers;

import org.mapstruct.Mapper;

import com.chillsrestaurant.app.entities.MenuItem;
import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.entities.dto.MenuItemResponse;
import com.chillsrestaurant.app.entities.dto.OrderDTO;

@Mapper
public interface MapperInterface {
    Order orderDtoToOrder(OrderDTO orderDTO);

    OrderDTO orderToOrderDTO(Order order);

    MenuItem menuItemResponseToMenuItem(MenuItemResponse menuItem);

    MenuItemResponse menuItemResponseToMenuItem(MenuItem menuItem);

}
