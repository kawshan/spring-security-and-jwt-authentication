package com.aukdevelopment.ytjwttutorial.controller;

import com.aukdevelopment.ytjwttutorial.entity.UserEntity;
import com.aukdevelopment.ytjwttutorial.repository.UserRepository;
import com.aukdevelopment.ytjwttutorial.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;


    public AuthController(AuthService authService, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.authService = authService;
    }

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return authService.getAllUsers();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user){
        return authService.createUser(user);
    }







}
