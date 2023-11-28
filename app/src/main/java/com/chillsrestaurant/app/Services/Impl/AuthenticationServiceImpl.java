package com.chillsrestaurant.app.services.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chillsrestaurant.app.entities.Role;
import com.chillsrestaurant.app.entities.User;
import com.chillsrestaurant.app.entities.request.SignUpRequest;
import com.chillsrestaurant.app.entities.request.SigninRequest;
import com.chillsrestaurant.app.entities.response.JwtAuthenticationResponse;
import com.chillsrestaurant.app.repositories.UserRepository;
import com.chillsrestaurant.app.services.AuthenticationService;
import com.chillsrestaurant.app.services.JwtService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationServiceImpl(
                        UserRepository userRepository,
                        PasswordEncoder passwordEncoder,
                        JwtService jwtService,
                        AuthenticationManager authenticationManager) {
                this.userRepository = userRepository;
                this.passwordEncoder = passwordEncoder;
                this.jwtService = jwtService;
                this.authenticationManager = authenticationManager;
        }

        @Override
        public JwtAuthenticationResponse signup(SignUpRequest request) {

                User user = User.builder().firstName(request.getFirstName())
                                .lastName(request.getLastName())
                                .email(request.getEmail())
                                .phone(request.getPhone())
                                .address(request.getAddress())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(Role.CUSTOMER).build();

                user.setEmail(request.getEmail());

                userRepository.save(user);

                return JwtAuthenticationResponse.builder().token(user.getUsername()).build();
        }

        @Override
        public JwtAuthenticationResponse signin(SigninRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
                var user = userRepository.findByEmail(request.getEmail())
                                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
                var jwt = jwtService.generateToken(user);
                return JwtAuthenticationResponse.builder().user(user)
                                .token(jwt).build();
        }
}
