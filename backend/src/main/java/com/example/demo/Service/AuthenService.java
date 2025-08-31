package com.example.demo.Service;

// import java.util.List;

import com.example.demo.Dto.RegisterUserDto;
import com.example.demo.Model.Customer;
import com.example.demo.Repository.UserRepository;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class AuthenService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    // public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager){
    //     this.userRepository = null;
    //     this.passwordEncoder = passwordEncoder;
    //     this.authenticationManager = authenticationManager;
    // }

    // public List<Customer> getUsers() {
    //     return userRepository.findAll();

    // }

    public Customer authenticate(String email, String password) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password)
        );
       
        Customer user = userRepository.findUserByEmail(email).orElseThrow();
        return user;
    }

    // public void addNewUser(Customer customer) {
    //     Optional<Customer> userOptional = userRepository.findUserByEmail(customer.getEmail());
    //     if (userOptional.isPresent()) {
    //         throw new IllegalStateException("Email already taken");
    //     } 

    //     userRepository.save(customer);
    // }

    public Customer signUp(RegisterUserDto input){
        // Optional<Customer> userOptional = userRepository.findUserByEmail(input.getEmail());
        // if (userOptional.isPresent()) {
        //     throw new IllegalStateException("Email already taken");
        // } 
        Customer cust = new Customer();
        cust.setName(input.getName());
        cust.setEmail(input.getEmail());
        cust.setPassword(passwordEncoder.encode(input.getPassword()));
        
        userRepository.save(cust);
        return cust;
    }

    // public void deleteUserByEmail(String email) {
    //     Optional<Customer> userOptional = userRepository.findUserByEmail(email);
    //     if (userOptional.isEmpty()) {
    //         throw new IllegalStateException("Email not exists");
    //     } 

    //     userRepository.deleteById(userOptional.get().getId());
    // }
    
}
