package com.nmscinemas.nms_cinemas_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nmscinemas.nms_cinemas_backend.entity.Movie;
import com.nmscinemas.nms_cinemas_backend.repository.MovieRepository;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
