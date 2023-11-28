package com.chillsrestaurant.app.entities.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.entities.dto.OrderDTO;

@Mapper(componentModel = "spring", uses = {UserMapper.class, OrderMenuItemMapper.class})
public interface OrderMapper {
    @Mapping(target = "orderMenuItems", source = "menuItems") // Adjusted to the correct source field name
    @Mapping(target = "customer", source = "customer")
    Order orderDtoToOrder(OrderDTO orderDTO);

    @InheritInverseConfiguration
    OrderDTO orderToOrderDto(Order order);
}
