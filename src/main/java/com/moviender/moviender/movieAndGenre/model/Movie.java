package com.moviender.moviender.movieAndGenre.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Movies")
public class Movie {

    @Id
    Integer id;

    @Column(length = 550)
    String title;

    @Column(length = 550)
    String original_title;

    @Column(columnDefinition = "TEXT") // uzunluk sınırını kaldırmak icin
    String overview;

    @Column(columnDefinition = "TEXT")
    String poster_path;

    @Column(columnDefinition = "TEXT")
    String backdrop_path;
    LocalDate release_date;
    Float vote_average;
    Integer vote_count;
    Float popularity;
    String original_language;

    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;
    Boolean adult;
    Boolean video;
}