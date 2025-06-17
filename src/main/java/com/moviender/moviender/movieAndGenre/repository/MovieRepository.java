package com.moviender.moviender.movieAndGenre.repository;

import com.moviender.moviender.movieAndGenre.dto.MovieResponseDto;
import com.moviender.moviender.movieAndGenre.model.Genre;
import com.moviender.moviender.movieAndGenre.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByGenresIn(List<Genre> genre);
}
