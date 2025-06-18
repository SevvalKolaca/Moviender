package com.moviender.moviender.match.service;

import java.util.List;

public interface MatchService {
    List<String> getGenreNamesByMovieService(List<Integer> genreIds);
}
