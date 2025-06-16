package com.moviender.moviender.movieAndGenre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GenreTmdbResponseDto {
    List<GenreDto> genres = getGenres();
}
