package com.chillsrestaurant.app.entities.mapper;

import org.mapstruct.Mapper;

import com.chillsrestaurant.app.entities.Customer;
import com.chillsrestaurant.app.entities.dto.OrderDTO.CustomerDto;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto customerDto);
}
