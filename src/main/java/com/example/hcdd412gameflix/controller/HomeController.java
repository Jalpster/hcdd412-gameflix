package com.example.hcdd412gameflix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/games")
    public String gamesPage() {
        return "games";
    }

    @GetMapping("/favorites")
    public String favoritesPage() {
        return "favorites";
    }
}