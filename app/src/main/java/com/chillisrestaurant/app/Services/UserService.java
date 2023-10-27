package com.chillisrestaurant.app.Services;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    public UserDetailsService userDetailsService();
}