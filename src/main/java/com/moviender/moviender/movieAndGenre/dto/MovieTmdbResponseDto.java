package com.moviender.moviender.movieAndGenre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieTmdbResponseDto {
    private List<MovieCreateDto> results;
}
