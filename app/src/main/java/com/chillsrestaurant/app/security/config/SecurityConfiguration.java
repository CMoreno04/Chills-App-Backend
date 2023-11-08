package com.chillsrestaurant.app.security.config;

import java.util.Arrays;

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

import com.chillsrestaurant.app.security.filter.JwtAuthenticationFilter;
import com.chillsrestaurant.app.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

        private final JwtAuthenticationFilter jwtAuthenticationFilter;

        private final UserService userService;

        public SecurityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter, UserService userService) {
                this.jwtAuthenticationFilter = jwtAuthenticationFilter;
                this.userService = userService;
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                // CSRF Configuration
                                .csrf(csrf -> csrf
                                                .ignoringRequestMatchers(new AntPathRequestMatcher("/api/**"))
                                                .ignoringRequestMatchers(new AntPathRequestMatcher("/v3/api-docs/**"))
                                                .ignoringRequestMatchers(new AntPathRequestMatcher("/swagger-ui/**"))
                                                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))

                                // CORS Configuration
                                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                                // Authorization Configuration
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers(new AntPathRequestMatcher("/api/auth/**")).permitAll()
                                                .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/**"))
                                                .permitAll()
                                                .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**"))
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

                CorsConfiguration openApiConfig = new CorsConfiguration();
                source.registerCorsConfiguration("/v3/api-docs", openApiConfig.applyPermitDefaultValues());

                CorsConfiguration defaultConfiguration = new CorsConfiguration();
                defaultConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000","https://chills.restaurant"));
                defaultConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                defaultConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-XSRF-TOKEN"));
                defaultConfiguration.setExposedHeaders(Arrays.asList("X-XSRF-TOKEN"));
                defaultConfiguration.setAllowCredentials(true);
                defaultConfiguration.setMaxAge(3600L);

                source.registerCorsConfiguration("/**", defaultConfiguration); // Apply this configuration to all routes

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
