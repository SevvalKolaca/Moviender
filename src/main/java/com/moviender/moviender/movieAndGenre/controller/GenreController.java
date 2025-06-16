package com.moviender.moviender.movieAndGenre.controller;

import com.moviender.moviender.movieAndGenre.service.MovieServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/genre")
public class GenreController {

    private final MovieServiceImpl movieService;

    GenreController(MovieServiceImpl movieService){
        this.movieService = movieService;
    }

    @GetMapping("/genres/import")
    ResponseEntity<String> importGenres(){
        try{
            movieService.importGenres();
            return ResponseEntity.ok("Genres added successfully!");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Movies cannot be added:"+e.getMessage());
        }
    }
}
