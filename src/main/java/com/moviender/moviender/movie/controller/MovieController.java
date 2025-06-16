package com.moviender.moviender.movie.controller;

import com.moviender.moviender.movie.service.MovieServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/movie")
public class MovieController {

    private final MovieServiceImpl movieService;

    MovieController(MovieServiceImpl movieService){
        this.movieService = movieService;
    }

    @PostMapping("/import")
    ResponseEntity<String> importMovies(){
        try{
            movieService.importMovies();
            return ResponseEntity.ok("Movies added successfully!");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Movies cannot be added:"+e.getMessage());
        }
    }
}
