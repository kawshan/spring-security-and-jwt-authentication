package com.aukdevelopment.ytjwttutorial.controller;

import com.aukdevelopment.ytjwttutorial.service.JWTservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

    private final JWTservice jwTservice;

    public HomeController(JWTservice jwTservice) {
        this.jwTservice = jwTservice;
    }

    @GetMapping
    public String getHello(){
        return "hi";
    }

    @PostMapping("/login")
    public String login(){
        return jwTservice.getJWTToken();
    }


    @GetMapping("/username")
    public String getUsername(@RequestParam String token){
        return jwTservice.getUsername(token);
    }





}
