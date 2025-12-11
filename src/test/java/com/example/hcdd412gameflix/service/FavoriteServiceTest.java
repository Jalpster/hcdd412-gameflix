package com.example.hcdd412gameflix.service;

import com.example.hcdd412gameflix.model.Favorite;
import com.example.hcdd412gameflix.model.Game;
import com.example.hcdd412gameflix.repository.FavoriteRepository;
import com.example.hcdd412gameflix.repository.GameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class FavoriteServiceTest {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Test
    @Transactional
    public void testAddFavorite() {
        Game game = gameRepository.save(new Game("Elden Ring"));

        favoriteService.addFavorite(1L, game.getId());

        List<Favorite> favorites = favoriteRepository.findByUserId(1L);
        Assertions.assertEquals(1, favorites.size());
    }

    @Test
    @Transactional
    public void testGetFavorites() {
        Game game1 = gameRepository.save(new Game("Pokemon"));
        Game game2 = gameRepository.save(new Game("Zelda"));

        favoriteService.addFavorite(2L, game1.getId());
        favoriteService.addFavorite(2L, game2.getId());

        List<Favorite> favorites = favoriteService.getFavorites(2L);

        Assertions.assertEquals(2, favorites.size());
    }
}