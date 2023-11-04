package com.chillsrestaurant.app.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chillsrestaurant.app.Services.AuthenticationService;
import com.chillsrestaurant.app.security.dao.request.CustomerSignUpRequest;
import com.chillsrestaurant.app.security.dao.request.CustomerSigninRequest;
import com.chillsrestaurant.app.security.dao.request.EmployeeSignUpRequest;
import com.chillsrestaurant.app.security.dao.request.EmployeeSigninRequest;
import com.chillsrestaurant.app.security.dao.response.JwtAuthenticationResponse;
import com.chillsrestaurant.app.security.dao.response.RegisteredResponse;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup/employee")
    public ResponseEntity<RegisteredResponse> signup(@RequestBody EmployeeSignUpRequest request) {
        return ResponseEntity
                .ok(RegisteredResponse.builder().username(authenticationService.signup(request).getToken()).build());
    }

    @PostMapping("/signin/employee")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody EmployeeSigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }

    @PostMapping("/signup/customer")
    public ResponseEntity<RegisteredResponse> signup(@RequestBody CustomerSignUpRequest request) {
        new RegisteredResponse();
        return ResponseEntity
                .ok(RegisteredResponse.builder().username(authenticationService.signup(request).getToken()).build());
    }

    @PostMapping("/signin/customer")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody CustomerSigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}