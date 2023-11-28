package com.chillsrestaurant.app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chillsrestaurant.app.entities.User;
import com.chillsrestaurant.app.entities.request.UpdateUserRequest;
import com.chillsrestaurant.app.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @Operation(summary = "Provides All Users in Database")
    public ResponseEntity<List<User>> getAllOrders() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @PutMapping
    @Operation(summary = "Provides All Orders in Database")
    public ResponseEntity<List<User>> updateUser(@RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(this.userService.updateUser(request.getId(), request.getUpdatedUser()));
    }
}
