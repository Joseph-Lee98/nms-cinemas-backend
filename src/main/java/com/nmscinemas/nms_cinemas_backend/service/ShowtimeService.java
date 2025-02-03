package com.nmscinemas.nms_cinemas_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nmscinemas.nms_cinemas_backend.dto.ShowtimeDTO;
import com.nmscinemas.nms_cinemas_backend.entity.Movie;
import com.nmscinemas.nms_cinemas_backend.entity.Showtime;
import com.nmscinemas.nms_cinemas_backend.entity.Theatre;
import com.nmscinemas.nms_cinemas_backend.exception.InvalidShowtimeDataException;
import com.nmscinemas.nms_cinemas_backend.repository.MovieRepository;
import com.nmscinemas.nms_cinemas_backend.repository.ShowtimeRepository;
import com.nmscinemas.nms_cinemas_backend.repository.TheatreRepository;

@Service
public class ShowtimeService {
	private final ShowtimeRepository showtimeRepository;
	private final MovieRepository movieRepository;
	private final TheatreRepository theatreRepository;

	public ShowtimeService(ShowtimeRepository showtimeRepository, MovieRepository movieRepository,
			TheatreRepository theatreRepository) {
		this.showtimeRepository = showtimeRepository;
		this.movieRepository = movieRepository;
		this.theatreRepository = theatreRepository;
	}

	public List<ShowtimeDTO> getAllShowtimes() {
		return showtimeRepository.findAll().stream()
				.map(showtime -> new ShowtimeDTO(showtime.getShowtimeId(), showtime.getMovie().getMovieId(),
						showtime.getTheatre().getTheatreId(), showtime.getShowDate(), showtime.getAvailableSeats()))
				.toList();
	}
	
	public List<ShowtimeDTO> getShowtimesByMovieId(Long movieId) {
        return showtimeRepository.findByMovie_MovieId(movieId).stream()
                .map(showtime -> new ShowtimeDTO(
                        showtime.getShowtimeId(),
                        showtime.getMovie().getMovieId(),
                        showtime.getTheatre().getTheatreId(),
                        showtime.getShowDate(),
                        showtime.getAvailableSeats()
                ))
                .collect(Collectors.toList());
    }

	public Showtime addShowtime(ShowtimeDTO showtimeDTO) {
		validateShowtimeDTO(showtimeDTO);

		Movie movie = movieRepository.findById(showtimeDTO.getMovieId())
				.orElseThrow(() -> new InvalidShowtimeDataException("Invalid movie ID: " + showtimeDTO.getMovieId()));

		Theatre theatre = theatreRepository.findById(showtimeDTO.getTheatreId()).orElseThrow(
				() -> new InvalidShowtimeDataException("Invalid theatre ID: " + showtimeDTO.getTheatreId()));

		Showtime showtime = new Showtime();
		showtime.setMovie(movie);
		showtime.setTheatre(theatre);
		showtime.setShowDate(showtimeDTO.getShowDate());
		showtime.setAvailableSeats(showtimeDTO.getAvailableSeats());

		return showtimeRepository.save(showtime);
	}

	private void validateShowtimeDTO(ShowtimeDTO showtimeDTO) {
		if (showtimeDTO.getMovieId() == null) {
			throw new InvalidShowtimeDataException("Movie ID is required.");
		}
		if (showtimeDTO.getTheatreId() == null) {
			throw new InvalidShowtimeDataException("Theatre ID is required.");
		}
		if (showtimeDTO.getShowDate() == null) {
			throw new InvalidShowtimeDataException("Show date is required.");
		}
		if (showtimeDTO.getAvailableSeats() <= 0) {
			throw new InvalidShowtimeDataException("Available seats must be greater than zero.");
		}
	}
}
