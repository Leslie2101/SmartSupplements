package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor

public class UserService {

    @Autowired
    private final UserRepository userRepository;


    public List<Customer> getUsers() {
        return userRepository.findAll();

    }

    public Customer getUser(String email, String password) {
        Optional<Customer> userOptional = userRepository.findUserByEmail(email);
        if (userOptional.isPresent()) {
            if (!userOptional.get().getPassword().equals(password)){
                throw new IllegalStateException("incorrect password");
            }
        } else {
            throw new IllegalStateException("account not exists");
        }

        return userOptional.get();
    }

    public void addNewUser(Customer customer) {
        Optional<Customer> userOptional = userRepository.findUserByEmail(customer.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        } 

        userRepository.save(customer);
    }

    public void deleteUserByEmail(String email) {
        Optional<Customer> userOptional = userRepository.findUserByEmail(email);
        if (userOptional.isEmpty()) {
            throw new IllegalStateException("Email not exists");
        } 

        userRepository.deleteById(userOptional.get().getId());
    }
    
}
