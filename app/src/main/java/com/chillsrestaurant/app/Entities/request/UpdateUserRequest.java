package com.chillsrestaurant.app.entities.request;

import com.chillsrestaurant.app.entities.User;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private Integer id;
    private User updatedUser;
}
