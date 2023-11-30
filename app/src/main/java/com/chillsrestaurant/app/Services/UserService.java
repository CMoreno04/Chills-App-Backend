package com.chillsrestaurant.app.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.chillsrestaurant.app.entities.User;

public interface UserService {
    public UserDetailsService userDetailsService();
    public List<User> getAllUsers();
    public List<User> updateUser(Integer id, User updatedUser);
    public List<User> deleteUser(Integer id);
}