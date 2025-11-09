package com.example.hcdd412gameflix.controller;

import com.example.hcdd412gameflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> user) {
        String username = user.get("username");
        String password = user.get("password");
        String message = userService.registerUser(username, password);
        return Map.of("message", message);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {
        String username = user.get("username");
        String password = user.get("password");
        String message = userService.loginUser(username, password);
        return Map.of("message", message);
    }
}