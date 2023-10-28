package com.chillisrestaurant.app.services;

import com.chillisrestaurant.app.dao.request.SignUpRequest;
import com.chillisrestaurant.app.dao.request.SigninRequest;
import com.chillisrestaurant.app.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}