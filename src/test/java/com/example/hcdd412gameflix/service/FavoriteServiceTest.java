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
        // FIXED: Updated constructor
        Game game = gameRepository.save(new Game("Elden Ring", "Action RPG", "http://img.url"));

        favoriteService.addFavorite(1L, game.getId());

        // We still check the repository directly to ensure the data was saved
        List<Favorite> favorites = favoriteRepository.findByUserId(1L);
        Assertions.assertEquals(1, favorites.size());
    }

    @Test
    @Transactional
    public void testGetFavorites() {
        // FIXED: Updated constructors
        Game game1 = gameRepository.save(new Game("Pokemon", "Catch em all", "http://poke.img"));
        Game game2 = gameRepository.save(new Game("Zelda", "Save Hyrule", "http://zelda.img"));

        favoriteService.addFavorite(2L, game1.getId());
        favoriteService.addFavorite(2L, game2.getId());

        // FIXED: Method renamed to getUserFavorites and returns List<Game>
        List<Game> favorites = favoriteService.getUserFavorites(2L);

        Assertions.assertEquals(2, favorites.size());
        // Optional: Verify we got the correct types back
        Assertions.assertTrue(favorites.stream().anyMatch(g -> g.getTitle().equals("Pokemon")));
    }
}