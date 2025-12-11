package com.example.hcdd412gameflix.controller;

import com.example.hcdd412gameflix.model.Game;
import com.example.hcdd412gameflix.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getGames() {
        return gameService.getAllGames();
    }
}