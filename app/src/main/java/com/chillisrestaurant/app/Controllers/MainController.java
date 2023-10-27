package com.chillisrestaurant.app.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main/")
@CrossOrigin(origins = "http://localhost:3000/**")
public class MainController {
    
    @GetMapping("hello")
    public String hello(){
        return "Hello World!";
    }
}
