package com.example.demo.Service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootTest
class JwtServiceTest {

    @Autowired
    private JwtService jwtService;

    @Test
    void tokenShouldExpire() throws InterruptedException {
        UserDetails userDetails = new UserDetails() {

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
            }

            @Override
            public String getPassword() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
            }

            @Override
            public String getUsername() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
            }
            
        };

        // Generate token
        String token = jwtService.generateToken(userDetails);

        // Immediately verify it's valid
        assertTrue(jwtService.isTokenValid(token, userDetails));

        // Wait past expiration
        Thread.sleep(6000);  // Wait 6 seconds

        // Now the token should be invalid
        assertFalse(jwtService.isTokenValid(token, userDetails));
    }
}

