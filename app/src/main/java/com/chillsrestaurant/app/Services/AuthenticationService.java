package com.chillsrestaurant.app.services;

import com.chillsrestaurant.app.security.dao.request.SignUpRequest;
import com.chillsrestaurant.app.security.dao.request.SigninRequest;
import com.chillsrestaurant.app.security.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}