package com.example.hcdd412gameflix.repository;

import com.example.hcdd412gameflix.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {}