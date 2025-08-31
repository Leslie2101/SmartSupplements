package com.example.demo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MetaContentController {
    @GetMapping("/")
    public String generateToken() {
        return "Hello world backend";
    }
}
