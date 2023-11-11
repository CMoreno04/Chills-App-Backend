package com.chillsrestaurant.app.services;

import com.chillsrestaurant.app.entities.request.SignUpRequest;
import com.chillsrestaurant.app.entities.request.SigninRequest;
import com.chillsrestaurant.app.entities.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}