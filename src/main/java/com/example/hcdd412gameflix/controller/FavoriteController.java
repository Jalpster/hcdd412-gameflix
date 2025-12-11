package com.example.hcdd412gameflix.controller;

import com.example.hcdd412gameflix.model.Favorite;
import com.example.hcdd412gameflix.service.FavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favService;

    public FavoriteController(FavoriteService favService) {
        this.favService = favService;
    }

    @PostMapping("/add")
    public Map<String, String> addFavorite(@RequestBody Map<String, Long> body) {
        Long userId = body.get("userId");
        Long gameId = body.get("gameId");

        favService.addFavorite(userId, gameId);

        return Map.of("message", "Added to favorites");
    }

    @GetMapping("/{userId}")
    public List<Favorite> getFavorites(@PathVariable Long userId) {
        return favService.getFavorites(userId);
    }
}