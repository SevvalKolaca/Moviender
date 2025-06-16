package com.moviender.moviender.movie.service;

import com.moviender.moviender.movie.dto.MovieCreateDto;
import com.moviender.moviender.movie.dto.MovieTmdbResponseDto;
import com.moviender.moviender.movie.model.Movie;
import com.moviender.moviender.movie.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    // @PostConstruct --> metot çalışıyor mu diye kullandık, uygulama ayağa kalkarken direkt çalışsın diye.
    public void testKey(){
        System.out.println(apiKey);
    }

    //@PostConstruct
    public MovieTmdbResponseDto getMovies(){
        String apiUrl = "https://api.themoviedb.org/3/movie/popular?api_key="+apiKey+"&language=en-US&page=1\n";
        RestTemplate restTemplate = new RestTemplate();
        MovieTmdbResponseDto result = restTemplate.getForObject(apiUrl, MovieTmdbResponseDto.class);
        System.out.println(result);
        return result;
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
        List<MovieCreateDto> moviesDtos = getMovies().getResponse();

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
