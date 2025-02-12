package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class FirstProg 
{
    public static void main(String[] args)
    {
        SpringApplication.run(FirstProg.class, args);
    }

    @GetMapping("/message")
    public String home() {
        return "Hello, Yogesh Jamnor";
    }
}
