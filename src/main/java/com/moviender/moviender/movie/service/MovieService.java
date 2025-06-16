package com.moviender.moviender.movie.service;

import com.moviender.moviender.movie.dto.MovieTmdbResponseDto;

import java.util.List;

public interface MovieService {
    List<MovieTmdbResponseDto> getMovies();
}
