package com.chillsrestaurant.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chillsrestaurant.app.services.AuthenticationService;
import com.chillsrestaurant.app.security.dao.request.CustomerSignUpRequest;
import com.chillsrestaurant.app.security.dao.request.CustomerSigninRequest;
import com.chillsrestaurant.app.security.dao.request.EmployeeSignUpRequest;
import com.chillsrestaurant.app.security.dao.request.EmployeeSigninRequest;
import com.chillsrestaurant.app.security.dao.response.JwtAuthenticationResponse;
import com.chillsrestaurant.app.security.dao.response.RegisteredResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup/employee")
    @Operation(summary = "Provides Registration services to Employees")
    public ResponseEntity<RegisteredResponse> signup(
            @Parameter(description = "Expects a EmployeeSignUpRequest Object") @RequestBody EmployeeSignUpRequest request) {
        return ResponseEntity
                .ok(RegisteredResponse.builder().username(authenticationService.signup(request).getToken()).build());
    }

    @PostMapping("/signin/employee")
    @Operation(summary = "Provides Sign In services to Employees")
    public ResponseEntity<JwtAuthenticationResponse> signin(
            @Parameter(description = "Expects a EmployeeSignInRequest Object") @RequestBody EmployeeSigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }

    @PostMapping("/signup/customer")
    @Operation(summary = "Provides Registration services to Customers")
    public ResponseEntity<RegisteredResponse> signup(
            @Parameter(description = "Expects a CustomerSignUpRequest Object") @RequestBody CustomerSignUpRequest request) {
        new RegisteredResponse();
        return ResponseEntity
                .ok(RegisteredResponse.builder().username(authenticationService.signup(request).getToken()).build());
    }

    @PostMapping("/signin/customer")
    @Operation(summary = "Provides Sign In services to Employees")
    public ResponseEntity<JwtAuthenticationResponse> signin(
            @Parameter(description = "Expects a CustomerSignInRequest Object") @RequestBody CustomerSigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}