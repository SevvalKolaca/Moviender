package com.moviender.moviender.movie.model;

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

    @ElementCollection
    @CollectionTable(name = "movie_genre_ids", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name="genre_id")
    List<Integer> genre_ids;
    Boolean adult;
    Boolean video;
}