package com.chillsrestaurant.app.security.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.chillsrestaurant.app.Services.UserService;
import com.chillsrestaurant.app.security.filter.JwtAuthenticationFilter;

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
                                // CSRF Configuration
                                .csrf(csrf -> csrf
                                                .ignoringRequestMatchers(new AntPathRequestMatcher("/auth/**"))
                                                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))

                                // CORS Configuration
                                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                                // Authorization Configuration
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers(new AntPathRequestMatcher("/auth/**"))
                                                .permitAll().anyRequest().authenticated())

                                // Session Management
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                                // Authentication Provider
                                .authenticationProvider(authenticationProvider())

                                // JWT Filter
                                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

                return http.build();
        }

        @Bean
        CorsConfigurationSource corsConfigurationSource() {
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

                CorsConfiguration authConfiguration = new CorsConfiguration();
                authConfiguration.setAllowedOrigins(Arrays.asList("http://192.168.0.5:8082", "http://localhost:3000",
                                "https://192.168.0.5:8443",
                                "https://localhost:8443", "chills.restaurant")); // Specify exact origins
                authConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
                authConfiguration.setAllowedHeaders(Arrays.asList("*")); // Or specify exact headers you need
                authConfiguration.setAllowCredentials(true);
                authConfiguration.setMaxAge(3600L); // Set max age to 1 hour

                source.registerCorsConfiguration("/auth/signin/employee/**", authConfiguration); // Apply this
                                                                                                 // configuration to
                                                                                                 // your specific
                                                                                                 // endpoint

                CorsConfiguration defaultConfiguration = new CorsConfiguration();
                defaultConfiguration.setAllowedOrigins(Arrays.asList("http://192.168.0.5:8082", "http://localhost:3000",
                                "https://192.168.0.5:8443",
                                "https://localhost:8443", "chills.restaurant"));
                defaultConfiguration
                                .setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
                defaultConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type",
                                "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                                "Access-Control-Request-Headers", "X-XSRF-TOKEN"));
                defaultConfiguration.setExposedHeaders(Arrays.asList("Authorization"));
                defaultConfiguration.setAllowCredentials(true);
                defaultConfiguration.setMaxAge(3600L); // Set max age to 1 hour

                source.registerCorsConfiguration("/**", defaultConfiguration); // Apply this configuration to all other
                                                                               // routes

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
