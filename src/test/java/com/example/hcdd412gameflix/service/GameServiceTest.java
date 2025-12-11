package com.example.hcdd412gameflix.service;

import com.example.hcdd412gameflix.model.Game;
import com.example.hcdd412gameflix.repository.GameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

    @Test
    @Transactional
    public void testGetAllGames() {
        gameRepository.save(new Game("Halo"));
        gameRepository.save(new Game("Minecraft"));

        List<Game> games = gameService.getAllGames();

        Assertions.assertTrue(games.size() >= 2);
    }
}