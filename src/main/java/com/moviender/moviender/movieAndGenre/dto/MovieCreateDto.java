package com.moviender.moviender.movieAndGenre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieCreateDto{

    Integer id;
    String title;
    String original_title;
    String overview;
    String poster_path;
    String backdrop_path;
    LocalDate release_date;
    Float vote_average;
    Integer vote_count;
    Float popularity;
    String original_language;
    List<Integer> genre_ids;
    Boolean adult;
    Boolean video;
}
