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
                                                .ignoringRequestMatchers(new AntPathRequestMatcher("/api/v1/auth/**"))
                                                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))

                                // CORS Configuration
                                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                                // Authorization Configuration
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                                                .requestMatchers(new AntPathRequestMatcher("/api/v1/auth/**"))
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

                CorsConfiguration defaultConfig = new CorsConfiguration();
                defaultConfig.applyPermitDefaultValues(); // Apply default values which is usually "*"

                // You can customize the defaultConfig as needed
                // defaultConfig.setAllowedOrigins(Arrays.asList("https://example.com"));
                // defaultConfig.setAllowedMethods(Arrays.asList("GET", "POST"));

                // Specific CORS configuration for /api/v1/auth/signin/employee
                CorsConfiguration authConfig = new CorsConfiguration();
                authConfig.setAllowedOrigins(Arrays.asList("*")); // Allow all origins
                authConfig.setAllowedMethods(Arrays.asList("GET", "POST")); // Allow only GET and POST
                authConfig.setAllowedHeaders(Arrays.asList("*")); // Allow all headers
                authConfig.setExposedHeaders(Arrays.asList("Authorization"));
                authConfig.setAllowCredentials(true);
                authConfig.setMaxAge(3600L);

                // Specific CORS configuration for another route
                CorsConfiguration anotherRouteConfig = new CorsConfiguration();
                anotherRouteConfig.setAllowedOrigins(Arrays.asList("**", "http://172.20.0.2", "http://192.168.0.5"));
                anotherRouteConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT"));
                // ...other configurations for this route

                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/api/v1/auth/signin/employee", authConfig); // Apply authConfig to
                                                                                              // this path
                source.registerCorsConfiguration("/api/**", anotherRouteConfig); // Apply anotherRouteConfig to another
                                                                                 // path
                source.registerCorsConfiguration("/**", defaultConfig); // Apply defaultConfig to all other routes

                return source;

                // CorsConfiguration configuration = new CorsConfiguration();

                // configuration.setAllowedOrigins(Arrays.asList("*")); // Allow all origins
                // configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH",
                // "DELETE", "OPTIONS"));

                // // If you want to allow any headers, you can use "*"
                // configuration.setAllowedHeaders(Arrays.asList("*"));

                // configuration.setExposedHeaders(Arrays.asList("Authorization"));
                // configuration.setAllowCredentials(true);
                // configuration.setMaxAge(3600L); // Set max age to 1 hour

                // // Apply this configuration only to the specific path
                // UrlBasedCorsConfigurationSource source = new
                // UrlBasedCorsConfigurationSource();
                // source.registerCorsConfiguration("/auth/**", configuration);

                // configuration = new CorsConfiguration();
                // configuration.setAllowedOrigins(Arrays.asList("**", "http://172.20.0.2",
                // "http://192.168.0.5:8082/*"));
                // configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH",
                // "DELETE", "OPTIONS"));
                // configuration.setAllowedHeaders(Arrays.asList("Authorization",
                // "Content-Type", "X-Requested-With",
                // "accept",
                // "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers",
                // "X-XSRF-TOKEN"));
                // configuration.setExposedHeaders(Arrays.asList("Authorization"));
                // configuration.setAllowCredentials(true);
                // configuration.setMaxAge(3600L); // Set max age to 1 hour

                // source.registerCorsConfiguration("/api/**", configuration); // Apply this
                // configuration to all routes

                // return source;
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
