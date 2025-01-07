package com.aukdevelopment.ytjwttutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

    @GetMapping
    public String getHello(){
        return "hi";
    }

    @PostMapping("/login")
    public String login(){
        return "user login";
    }




}
