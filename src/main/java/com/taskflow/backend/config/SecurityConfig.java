package com.taskflow.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.security.authorization.SingleResultAuthorizationManager.permitAll;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        // Configure HTTP authorization rules
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/ping").permitAll()
                        .requestMatchers("/api/users/{id}").authenticated()
                        .anyRequest().authenticated()
        );
        return http.build();
    }
}
