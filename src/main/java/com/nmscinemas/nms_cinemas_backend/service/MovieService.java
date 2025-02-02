package com.nmscinemas.nms_cinemas_backend.service;

import com.nmscinemas.nms_cinemas_backend.constants.MovieGenre;
import com.nmscinemas.nms_cinemas_backend.constants.MovieLanguage;
import com.nmscinemas.nms_cinemas_backend.dto.MovieDTO;
import com.nmscinemas.nms_cinemas_backend.entity.Movie;
import com.nmscinemas.nms_cinemas_backend.exception.InvalidMovieDataException;
import com.nmscinemas.nms_cinemas_backend.exception.MovieNotFoundException;
import com.nmscinemas.nms_cinemas_backend.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    public Movie addMovie(MovieDTO movieDTO) {
       
        validateMovieDTO(movieDTO);

        Movie movie = new Movie(
                movieDTO.getTitle().trim(),
                MovieGenre.valueOf(movieDTO.getGenre().toUpperCase()), 
                MovieLanguage.valueOf(movieDTO.getLanguage().toUpperCase()), 
                movieDTO.getDurationMinutes(),
                movieDTO.getDescription().trim(),
                movieDTO.getPosterUrl().trim()
        );

        return movieRepository.save(movie);
    }

  
    private void validateMovieDTO(MovieDTO movieDTO) {
        if (movieDTO.getTitle() == null || movieDTO.getTitle().trim().isEmpty()) {
            throw new InvalidMovieDataException("Movie title cannot be empty.");
        }
        if (movieDTO.getTitle().length() > 255) {
            throw new InvalidMovieDataException("Movie title cannot exceed 255 characters.");
        }

       
        try {
            MovieGenre.valueOf(movieDTO.getGenre().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidMovieDataException("Invalid movie genre: " + movieDTO.getGenre());
        }

        try {
            MovieLanguage.valueOf(movieDTO.getLanguage().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidMovieDataException("Invalid movie language: " + movieDTO.getLanguage());
        }

        if (movieDTO.getDurationMinutes() <= 0) {
            throw new InvalidMovieDataException("Duration must be a positive integer.");
        }

        if (movieDTO.getDescription() == null || movieDTO.getDescription().trim().isEmpty()) {
            throw new InvalidMovieDataException("Description cannot be empty.");
        }

        if (movieDTO.getPosterUrl() == null || movieDTO.getPosterUrl().trim().isEmpty()) {
            throw new InvalidMovieDataException("Poster URL cannot be empty.");
        }
    }
    
}
