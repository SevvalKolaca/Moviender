package com.moviender.moviender.movieAndGenre.repository;

import com.moviender.moviender.movieAndGenre.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
