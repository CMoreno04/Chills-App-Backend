package com.chillisrestaurant.app.services;

import com.chillisrestaurant.app.security.dao.request.SignUpRequest;
import com.chillisrestaurant.app.security.dao.request.SigninRequest;
import com.chillisrestaurant.app.security.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}