package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.UserRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<Customer> allUsers(){
        List<Customer> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    
}
