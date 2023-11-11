package com.chillsrestaurant.app.services.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chillsrestaurant.app.entities.Customer;
import com.chillsrestaurant.app.entities.Employee;
import com.chillsrestaurant.app.entities.Role;
import com.chillsrestaurant.app.entities.request.CustomerSignUpRequest;
import com.chillsrestaurant.app.entities.request.CustomerSigninRequest;
import com.chillsrestaurant.app.entities.request.EmployeeSignUpRequest;
import com.chillsrestaurant.app.entities.request.EmployeeSigninRequest;
import com.chillsrestaurant.app.entities.request.SignUpRequest;
import com.chillsrestaurant.app.entities.request.SigninRequest;
import com.chillsrestaurant.app.entities.response.JwtAuthenticationResponse;
import com.chillsrestaurant.app.repositories.CustomerRepository;
import com.chillsrestaurant.app.repositories.EmployeeRepository;
import com.chillsrestaurant.app.repositories.UserRepository;
import com.chillsrestaurant.app.services.AuthenticationService;
import com.chillsrestaurant.app.services.JwtService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

        private final UserRepository userRepository;
        private final EmployeeRepository employeeRepository;
        private final CustomerRepository customerRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationServiceImpl(EmployeeRepository employeeRepository,
                        CustomerRepository customerRepository,
                        UserRepository userRepository,
                        PasswordEncoder passwordEncoder,
                        JwtService jwtService,
                        AuthenticationManager authenticationManager) {
                this.userRepository = userRepository;
                this.employeeRepository = employeeRepository;
                this.customerRepository = customerRepository;
                this.passwordEncoder = passwordEncoder;
                this.jwtService = jwtService;
                this.authenticationManager = authenticationManager;
        }

        @Override
        public JwtAuthenticationResponse signup(SignUpRequest request) {

                if (request instanceof EmployeeSignUpRequest) {

                        EmployeeSignUpRequest employeeRequest = (EmployeeSignUpRequest) request;

                        Employee user = Employee.builder().firstName(employeeRequest.getFirstName())
                                        .lastName(employeeRequest.getLastName())
                                        .email(employeeRequest.getEmail())
                                        .password(passwordEncoder.encode(request.getPassword()))
                                        .role(employeeRequest.getRole().equalsIgnoreCase("ADMIN") ? Role.ADMIN
                                                        : Role.EMPLOYEE)
                                        .build();

                        employeeRepository.save(user);

                        Employee updateEmployee = employeeRepository.findByEmail(employeeRequest.getEmail()).get();

                        updateEmployee.setEmployeeId(employeeRequest.getFirstName().substring(0, 1).toUpperCase()
                                        + employeeRequest.getLastName().substring(0, 1).toUpperCase()
                                        + String.format("%06d", updateEmployee.getId()));

                        employeeRepository.saveAndFlush(updateEmployee);

                        return JwtAuthenticationResponse.builder().token(user.getEmployeeId()).build();
                } else {

                        CustomerSignUpRequest customerRequest = (CustomerSignUpRequest) request;

                        Customer user = Customer.builder().firstName(customerRequest.getFirstName())
                                        .lastName(customerRequest.getLastName())
                                        .email(customerRequest.getEmail())
                                        .password(passwordEncoder.encode(customerRequest.getPassword()))
                                        .role(Role.CUSTOMER).build();

                        user.setUsername(customerRequest.getUsername());

                        customerRepository.save(user);

                        return JwtAuthenticationResponse.builder().token(user.getUsername()).build();
                }
        }

        @Override
        public JwtAuthenticationResponse signin(SigninRequest request) {
                String email = request instanceof EmployeeSigninRequest
                                ? employeeRepository.findEmailByEmployeeId(
                                                ((EmployeeSigninRequest) request).getEmployeeId()).get()
                                : customerRepository
                                                .findEmailByUsername(((CustomerSigninRequest) request).getUsername())
                                                .get();
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(email, request.getPassword()));
                var user = userRepository.findByEmail(email)
                                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
                var jwt = jwtService.generateToken(user);
                return JwtAuthenticationResponse.builder().role(user.getAuthorities().toArray()[0].toString())
                                .token(jwt).build();
        }
}
