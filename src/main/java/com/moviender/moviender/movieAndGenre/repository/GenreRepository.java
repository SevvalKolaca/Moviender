package com.moviender.moviender.movieAndGenre.repository;

import com.moviender.moviender.movieAndGenre.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findByIdIn(List<Integer> genreId);
}
