package com.moviender.moviender.movieAndGenre.controller;

import com.moviender.moviender.movieAndGenre.dto.MovieResponseDto;
import com.moviender.moviender.movieAndGenre.service.MovieServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getMovies") // GET /getMovies?genreIds=28&genreIds=35&genreIds=18
    List<MovieResponseDto> getMoviesFromGenres(@RequestParam  List<Integer> genreIds){
        return movieService.getMoviesFromGenres(genreIds);
    }
}
