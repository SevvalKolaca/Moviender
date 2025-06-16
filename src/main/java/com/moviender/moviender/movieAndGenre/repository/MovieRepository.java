package com.moviender.moviender.movieAndGenre.repository;

import com.moviender.moviender.movieAndGenre.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
