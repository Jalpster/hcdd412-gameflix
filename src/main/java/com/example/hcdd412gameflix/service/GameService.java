package com.example.hcdd412gameflix.service;

import com.example.hcdd412gameflix.model.Game;
import com.example.hcdd412gameflix.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository repo;

    public GameService(GameRepository repo) {
        this.repo = repo;
    }

    public List<Game> getAllGames() {
        return repo.findAll();
    }
}