package com.example.hcdd412gameflix.service;

import com.example.hcdd412gameflix.model.User; // Added import
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void testRegisterUser() {
        String response = userService.registerUser("testUser", "password123");
        Assertions.assertEquals("User registered successfully", response);
    }

    @Test
    @Transactional
    public void testDuplicateUsername() {
        userService.registerUser("duplicateUser", "pass1");
        String response = userService.registerUser("duplicateUser", "pass2");
        Assertions.assertEquals("Username already exists", response);
    }

    @Test
    @Transactional
    public void testLoginUser() {
        userService.registerUser("loginUser", "mypassword");

        // FIXED: Expect User object instead of String
        User user = userService.loginUser("loginUser", "mypassword");

        Assertions.assertNotNull(user, "User should not be null after successful login");
        Assertions.assertEquals("loginUser", user.getUsername());
    }

    @Test
    @Transactional
    public void testIncorrectLoginUser() {
        userService.registerUser("loginUser", "mypassword");

        // FIXED: Expect null instead of error string
        User user = userService.loginUser("loginUser", "myWRONGpassword");

        Assertions.assertNull(user, "User should be null for invalid password");
    }
}