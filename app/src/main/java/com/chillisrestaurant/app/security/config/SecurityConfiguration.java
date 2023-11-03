package com.chillisrestaurant.app.security.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.chillisrestaurant.app.security.filter.JwtAuthenticationFilter;
import com.chillisrestaurant.app.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CSRF Configuration - Only disable CSRF for specific endpoints if absolutely
                // necessary
                .csrf(csrf -> csrf.ignoringRequestMatchers(
                        "/login", // typically, you'd only disable CSRF for endpoints that are used by external
                                  // clients that can't handle CSRF
                        "/some/external/api"
                // add other paths that are used for server-to-server communication or that
                // require stateless operation
                )
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))

                // Content Security and XSS Protection
                .headers(headers -> headers
                        .contentSecurityPolicy("form-action 'self';").and()
                        .xssProtection()
                        .and()
                        .frameOptions().deny() // if you need to embed your app elsewhere, change 'deny' to 'sameOrigin'
                )

                // CORS Configuration
                .cors(cors -> cors
                        .configurationSource(corsConfigurationSource()))

                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/api/**").authenticated() // Assuming '/api/**' is for REST endpoints
                        .requestMatchers("/", "/home", "/login", "/static/**", "/css/**", "/js/**", "/images/**")
                        .permitAll()
                        .anyRequest().authenticated())

                // Session Management
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Authentication Provider
                .authenticationProvider(authenticationProvider())

                // JWT Filter
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Bean for CORS configuration
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*")); // Permit access from localhost:3000
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")); // Include
                                                                                                            // PATCH if
                                                                                                            // needed
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Requested-With", "accept",
                "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L); // Set max age to 1 hour

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Apply this configuration to all routes
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
