package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.JwtService;
import com.example.demo.Service.AuthenService;

import lombok.AllArgsConstructor;

import com.example.demo.Dto.RegisterUserDto;
import com.example.demo.Model.Customer;
import com.example.demo.Responses.LoginResponse;


// @Controller // handle incoming request from users
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenController {
    
    @Autowired
    private AuthenService authenService;

    private final JwtService jwtService;

    @GetMapping("/get")
    public ResponseEntity<LoginResponse> getUser(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        Customer authenticatedUser = authenService.authenticate(email, password);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> registerNewUser(@RequestBody RegisterUserDto registerUser) {
        Customer registeredCust = authenService.signUp(registerUser);
        return ResponseEntity.ok(registeredCust);

    }

    // @DeleteMapping("/delete")
    // public void deleteUserByEmail(@RequestParam(name = "email") String email) {
    //     authenService.deleteUserByEmail(email);
    // }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    
    
}
