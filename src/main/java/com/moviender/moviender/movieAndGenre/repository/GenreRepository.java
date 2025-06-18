package com.moviender.moviender.movieAndGenre.repository;

import com.moviender.moviender.movieAndGenre.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findByIdIn(List<Integer> genreId);

    @Query("SELECT g.genreName FROM Genre g WHERE g.id IN :ids")
    List<String> findGenreNamesByIds(@Param("ids") List<Integer> ids);
}
