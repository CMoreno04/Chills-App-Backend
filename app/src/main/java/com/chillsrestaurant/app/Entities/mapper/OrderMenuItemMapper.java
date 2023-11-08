package com.chillsrestaurant.app.entities.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chillsrestaurant.app.entities.OrderMenuItem;
import com.chillsrestaurant.app.entities.dto.OrderDTO.OrderMenuItemDto;

@Mapper(componentModel = "spring")
public interface OrderMenuItemMapper {
    
    @Mapping(target = "menuItem.id", source = "id")
    OrderMenuItem orderMenuItemDtoToOrderMenuItem (OrderMenuItemDto orderMenuItemDto);

    @Mapping(target = "id", source = "menuItem.id")
    OrderMenuItemDto orderMenuItemToOrderMenuItemDto (OrderMenuItem orderMenuItemDto);
}
