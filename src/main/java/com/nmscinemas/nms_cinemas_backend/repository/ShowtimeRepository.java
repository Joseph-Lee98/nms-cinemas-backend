package com.nmscinemas.nms_cinemas_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nmscinemas.nms_cinemas_backend.entity.Showtime;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
	  List<Showtime> findByMovie_MovieId(Long movieId);
}
