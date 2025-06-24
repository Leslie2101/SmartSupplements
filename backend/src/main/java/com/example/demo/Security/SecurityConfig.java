package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // return httpSecurity
        //         .formLogin(httpForm -> {
        //             httpForm
        //                 .loginPage("/api/auth/login").permitAll();
        //         })
        //         // .csrf(csrf -> csrf.disable())
        //         .authorizeHttpRequests(registry -> {  // authorisation rule 
        //             registry.requestMatchers("/api/auth/register").permitAll();
        //             registry.anyRequest().authenticated(); // grant access to anyone for registration page 
        //         })
        //         .build();

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .anyRequest().permitAll());  // Allow all requests without auth
        return httpSecurity.build();
    }
}
