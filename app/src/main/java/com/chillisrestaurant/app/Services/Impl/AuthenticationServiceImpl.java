package com.chillisrestaurant.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chillisrestaurant.app.entities.Role;
import com.chillisrestaurant.app.entities.User;
import com.chillisrestaurant.app.repositories.UserRepository;
import com.chillisrestaurant.app.security.dao.request.SignUpRequest;
import com.chillisrestaurant.app.security.dao.request.SigninRequest;
import com.chillisrestaurant.app.security.dao.response.JwtAuthenticationResponse;
import com.chillisrestaurant.app.services.AuthenticationService;
import com.chillisrestaurant.app.services.JwtService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder().username(request.getUsername())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole().equalsIgnoreCase("ADMIN") ? Role.ADMIN : Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
