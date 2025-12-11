package com.example.hcdd412gameflix.controller;

import com.example.hcdd412gameflix.model.User;
import com.example.hcdd412gameflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    // FIXED: Returns Map<String, Object> to include both message (String) and userId (Long)
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> user) {
        String username = user.get("username");
        String password = user.get("password");

        User authenticatedUser = userService.loginUser(username, password);

        Map<String, Object> response = new HashMap<>();
        if (authenticatedUser != null) {
            response.put("message", "Login successful");
            response.put("userId", authenticatedUser.getId());
        } else {
            response.put("message", "Invalid username or password");
        }

        return response;
    }
}