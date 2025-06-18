package com.moviender.moviender.match.service;

import com.moviender.moviender.match.controller.MatchController;
import com.moviender.moviender.movieAndGenre.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImp implements MatchService {
    private final MovieService movieService;

    MatchServiceImp(MovieService movieService){
        this.movieService = movieService;
    }

    public List<String> getGenreNamesByMovieService(List<Integer> genreIds){
        return movieService.getGenreNamesByIds(genreIds);
    }
}
