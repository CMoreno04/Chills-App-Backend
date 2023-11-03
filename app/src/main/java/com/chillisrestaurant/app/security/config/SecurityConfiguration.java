package com.chillisrestaurant.app.security.config;

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
                                // CSRF Configuration
                                .csrf(csrf -> csrf
                                                .ignoringRequestMatchers(
                                                                new AntPathRequestMatcher("/login"))
                                                .ignoringRequestMatchers(new AntPathRequestMatcher("/auth/**"))
                                                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))

                                // CORS Configuration
                                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                                // Authorization Configuration
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                                                .requestMatchers(new AntPathRequestMatcher("/auth/**"))
                                                .permitAll()
                                                .requestMatchers(new AntPathRequestMatcher("/home")).permitAll()
                                                .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
                                                .requestMatchers(new AntPathRequestMatcher("/static/**")).permitAll()
                                                .requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
                                                .requestMatchers(new AntPathRequestMatcher("/js/**")).permitAll()
                                                .requestMatchers(new AntPathRequestMatcher("/images/**")).permitAll()
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
                configuration.setAllowedOrigins(Arrays.asList("http://192.168.0.5:8082/**")); // Your specific origin
                configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
                configuration.setAllowedHeaders(Arrays.asList("*")); // Or specify headers if you need to
                configuration.setAllowCredentials(true);
                configuration.setMaxAge(3600L); // Set max age to 1 hour

                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/auth/signin/employee", configuration); // Apply this configuration to
                                                                                          // your endpoint
                source.registerCorsConfiguration("/**", configuration); // Apply this configuration to all routes if
                                                                        // that's your requirement

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
