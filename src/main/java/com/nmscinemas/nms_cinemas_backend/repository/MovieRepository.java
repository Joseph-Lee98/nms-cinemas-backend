package com.nmscinemas.nms_cinemas_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nmscinemas.nms_cinemas_backend.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
  
}
