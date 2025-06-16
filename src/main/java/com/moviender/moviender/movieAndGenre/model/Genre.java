package com.moviender.moviender.movieAndGenre.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Genres")
public class Genre {

    @Id
    private Integer id;

    private String genreName;

    @ManyToMany(mappedBy = "genres")
    @JsonIgnore
    private List<Movie> movies;
}
