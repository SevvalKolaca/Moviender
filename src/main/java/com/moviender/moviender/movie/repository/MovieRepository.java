package com.moviender.moviender.movie.repository;

import com.moviender.moviender.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
