package com.example.hcdd412gameflix.service;

import com.example.hcdd412gameflix.model.Favorite;
import com.example.hcdd412gameflix.model.Game;
import com.example.hcdd412gameflix.repository.FavoriteRepository;
import com.example.hcdd412gameflix.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favRepo;

    @Autowired
    private GameRepository gameRepo;

    public void addFavorite(Long userId, Long gameId) {
        if (favRepo.findByUserIdAndGameId(userId, gameId).isEmpty()) {
            favRepo.save(new Favorite(userId, gameId));
        }
    }

    public void removeFavorite(Long userId, Long gameId) {
        favRepo.findByUserIdAndGameId(userId, gameId)
                .ifPresent(fav -> favRepo.delete(fav));
    }

    public List<Game> getUserFavorites(Long userId) {
        List<Favorite> favorites = favRepo.findByUserId(userId);

        List<Long> gameIds = favorites.stream()
                .map(Favorite::getGameId)
                .collect(Collectors.toList());

        return gameRepo.findAllById(gameIds);
    }
}