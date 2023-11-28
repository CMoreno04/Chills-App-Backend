package com.chillsrestaurant.app.entities.mapper;

import org.mapstruct.Mapper;

import com.chillsrestaurant.app.entities.User;
import com.chillsrestaurant.app.entities.dto.OrderDTO.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User customerDtoToCustomer(UserDto customerDto);
}
