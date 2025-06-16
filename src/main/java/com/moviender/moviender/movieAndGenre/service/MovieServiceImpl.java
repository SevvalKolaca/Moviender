package com.moviender.moviender.movieAndGenre.service;

import com.moviender.moviender.movieAndGenre.dto.MovieCreateDto;
import com.moviender.moviender.movieAndGenre.dto.MovieTmdbResponseDto;
import com.moviender.moviender.movieAndGenre.model.Movie;
import com.moviender.moviender.movieAndGenre.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Value("${tmdb.api-key}")
    private String apiKey;
    private Integer pageNumber = 50;

    // @PostConstruct --> metot çalışıyor mu diye kullandık, uygulama ayağa kalkarken direkt çalışsın diye.
    public void testKey(){
        System.out.println(apiKey);
    }

    //@PostConstruct --> For testing ;)
    public List<MovieTmdbResponseDto> getMovies(){
        List<MovieTmdbResponseDto> movies = new ArrayList<>();
        System.out.println(apiKey);
        for(int page = 1; page <= pageNumber; page++){
            String apiUrl = "https://api.themoviedb.org/3/movie/popular?api_key="+apiKey+"&language=en-US&page="+page;
            RestTemplate restTemplate = new RestTemplate();
            MovieTmdbResponseDto result = restTemplate.getForObject(apiUrl, MovieTmdbResponseDto.class);
            System.out.println("Page " + page + ": " + result.getResults().size() + " movies fetched.");
            movies.add(result);
            try {
                Thread.sleep(1000); // API rate limit'e takılmamak için
            }catch (InterruptedException e){
                System.err.println("Sleep interrupted: " + e.getMessage());
            }
        }
        return movies;
    }



    public Movie convertToEntity(MovieCreateDto createDto) {
        Movie movie = new Movie();
        movie.setId(createDto.getId());
        movie.setTitle(createDto.getTitle());
        movie.setOriginal_title(createDto.getOriginal_title());
        movie.setOverview(createDto.getOverview());
        movie.setPoster_path(createDto.getPoster_path());
        movie.setBackdrop_path(createDto.getBackdrop_path());
        movie.setRelease_date(createDto.getRelease_date());
        movie.setVote_average(createDto.getVote_average());
        movie.setVote_count(createDto.getVote_count());
        movie.setPopularity(createDto.getPopularity());
        movie.setOriginal_language(createDto.getOriginal_language());
        movie.setGenre_ids(createDto.getGenre_ids());
        movie.setAdult(createDto.getAdult());
        movie.setVideo(createDto.getVideo());
        return movie;
    }

    public void importMovies(){
        log.info("Import process started!");

        List<MovieTmdbResponseDto> TmdbMovies = getMovies();
        List<MovieCreateDto> moviesDtos = new ArrayList<>();

        for(MovieTmdbResponseDto TmdbMovie : TmdbMovies){

            if(TmdbMovie.getResults() == null)
                throw new RuntimeException("Movie not found!");
            else{
                moviesDtos.addAll(TmdbMovie.getResults());
            }
        }

        if(moviesDtos == null || moviesDtos.isEmpty())
        {
            log.warn("------- veri yok --------");
            throw new RuntimeException("No movies to import!!");
        }
        else{
            List<Movie> movieEntities = moviesDtos
                .stream().map(this::convertToEntity)
                .collect(Collectors.toList());

            movieRepository.saveAll(movieEntities);
            log.info("Saved movie count: {}", movieEntities.size());
        }
    }



}
