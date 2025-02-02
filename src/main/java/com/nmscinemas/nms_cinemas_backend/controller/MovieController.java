package com.nmscinemas.nms_cinemas_backend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nmscinemas.nms_cinemas_backend.constants.MovieGenre;
import com.nmscinemas.nms_cinemas_backend.constants.MovieLanguage;
import com.nmscinemas.nms_cinemas_backend.dto.MovieDTO;
import com.nmscinemas.nms_cinemas_backend.entity.Movie;
import com.nmscinemas.nms_cinemas_backend.exception.InvalidMovieDataException;
import com.nmscinemas.nms_cinemas_backend.service.MovieService;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    
    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody MovieDTO movieDTO) {
        try {
            Movie savedMovie = movieService.addMovie(movieDTO);
            return ResponseEntity.ok(savedMovie);
        } catch (InvalidMovieDataException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    
    @GetMapping("/genres")
    public ResponseEntity<List<String>> getMovieGenres() {
        List<String> genres = Arrays.stream(MovieGenre.values())
                                    .map(Enum::name)
                                    .toList();
        return ResponseEntity.ok(genres);
    }

   
    @GetMapping("/languages")
    public ResponseEntity<List<String>> getMovieLanguages() {
        List<String> languages = Arrays.stream(MovieLanguage.values())
                                       .map(Enum::name)
                                       .toList();
        return ResponseEntity.ok(languages);
    }
}
