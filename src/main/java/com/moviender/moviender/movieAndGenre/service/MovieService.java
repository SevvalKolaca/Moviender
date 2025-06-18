package com.moviender.moviender.movieAndGenre.service;

import com.moviender.moviender.movieAndGenre.dto.GenreDto;
import com.moviender.moviender.movieAndGenre.dto.GenreTmdbResponseDto;
import com.moviender.moviender.movieAndGenre.dto.MovieResponseDto;
import com.moviender.moviender.movieAndGenre.dto.MovieTmdbResponseDto;
import com.moviender.moviender.movieAndGenre.model.Movie;

import java.util.List;

public interface MovieService {
    List<MovieTmdbResponseDto> getMovies();
    void importMovies();

    GenreTmdbResponseDto getGenres();
    void importGenres();

    List<MovieResponseDto> getMoviesFromGenres(List<Integer> genreIds);

    List<String> getGenreNamesByIds(List<Integer> genreIds);
}
