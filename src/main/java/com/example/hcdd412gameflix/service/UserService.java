package com.example.hcdd412gameflix.service;

import com.example.hcdd412gameflix.model.User;
import com.example.hcdd412gameflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String registerUser(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            return "Username already exists";
        }
        String hashedPassword = passwordEncoder.encode(password);
        userRepository.save(new User(username, hashedPassword));
        return "User registered successfully";
    }

    // FIXED: Returns User object so the controller can access the ID
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return null;
        }
        boolean matches = passwordEncoder.matches(password, user.getPassword());
        return matches ? user : null;
    }
}