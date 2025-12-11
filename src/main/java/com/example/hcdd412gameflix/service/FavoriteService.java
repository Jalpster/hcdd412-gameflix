package com.example.hcdd412gameflix.service;

import com.example.hcdd412gameflix.model.Favorite;
import com.example.hcdd412gameflix.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository repo;

    public FavoriteService(FavoriteRepository repo) {
        this.repo = repo;
    }

    public void addFavorite(Long userId, Long gameId) {
        repo.save(new Favorite(userId, gameId));
    }

    public List<Favorite> getFavorites(Long userId) {
        return repo.findByUserId(userId);
    }
}