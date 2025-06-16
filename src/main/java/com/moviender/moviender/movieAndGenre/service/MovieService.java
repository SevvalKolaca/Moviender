package com.moviender.moviender.movieAndGenre.service;

import com.moviender.moviender.movieAndGenre.dto.GenreTmdbResponseDto;
import com.moviender.moviender.movieAndGenre.dto.MovieTmdbResponseDto;

import java.util.List;

public interface MovieService {
    List<MovieTmdbResponseDto> getMovies();
    void importMovies();

    GenreTmdbResponseDto getGenres();
}
