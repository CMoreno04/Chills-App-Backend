package com.chillsrestaurant.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chillsrestaurant.app.entities.request.SignUpRequest;
import com.chillsrestaurant.app.entities.request.SigninRequest;
import com.chillsrestaurant.app.entities.response.JwtAuthenticationResponse;
import com.chillsrestaurant.app.entities.response.RegisteredResponse;
import com.chillsrestaurant.app.services.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    @Operation(summary = "Provides Registration services")
    public ResponseEntity<RegisteredResponse> signup(
            @Parameter(description = "Expects a SignUpRequest Object") @RequestBody SignUpRequest request) {
        return ResponseEntity
                .ok(RegisteredResponse.builder().username(authenticationService.signup(request).getToken()).build());
    }

    @PostMapping("/signin")
    @Operation(summary = "Provides Sign In services")
    public ResponseEntity<JwtAuthenticationResponse> signin(
            @Parameter(description = "Expects a SignInRequest Object") @RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }

}