package com.example.demo.Controller;

import java.util.List;

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

import com.example.demo.Service.UserService;
import com.example.demo.Model.Customer;


// @Controller // handle incoming request from users
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth/")
public class ContentController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<Customer> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/get")
    public Customer getUser(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password) {
        return userService.getUser(email,password);
    }

    @PostMapping("/add")
    public void registerNewUser(@RequestBody Customer customer) {
        userService.addNewUser(customer);
        System.out.println("Received user: " + customer.getEmail());

    }

    @DeleteMapping("/delete")
    public void deleteUserByEmail(@RequestParam(name = "email") String email) {
        userService.deleteUserByEmail(email);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    
    
}
