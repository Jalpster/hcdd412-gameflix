package com.example.hcdd412gameflix.controller;

import com.example.hcdd412gameflix.model.Game;
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
        favService.addFavorite(body.get("userId"), body.get("gameId"));
        return Map.of("message", "Added to favorites");
    }

    @PostMapping("/remove")
    public Map<String, String> removeFavorite(@RequestBody Map<String, Long> body) {
        favService.removeFavorite(body.get("userId"), body.get("gameId"));
        return Map.of("message", "Removed from favorites");
    }

    @GetMapping("/{userId}")
    public List<Game> getFavorites(@PathVariable Long userId) {
        return favService.getUserFavorites(userId);
    }
}