package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(AuthenticationProvider authenticationProvider, JwtAuthenticationFilter jwtAuthenticationFilter){
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    
    
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
                    .authorizeHttpRequests((authorizeHttpRequests) ->
                                            authorizeHttpRequests
                                            .requestMatchers("/**").permitAll().anyRequest().authenticated()
                                            )
                                            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                            .authenticationProvider(authenticationProvider)
                                            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
                                    
                        
        return httpSecurity.build();
    }


    // CorsConfigurationSource corsConfigurationSource(){
    //     CorsConfiguration configuration = new CorsConfiguration();
    //     configuration.setAllowedOrigins(null);
    // }
}
