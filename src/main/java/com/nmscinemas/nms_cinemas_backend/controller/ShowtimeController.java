package com.nmscinemas.nms_cinemas_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nmscinemas.nms_cinemas_backend.dto.ShowtimeDTO;
import com.nmscinemas.nms_cinemas_backend.entity.Showtime;
import com.nmscinemas.nms_cinemas_backend.service.ShowtimeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {
	private final ShowtimeService showtimeService;

	public ShowtimeController(ShowtimeService showtimeService) {
		this.showtimeService = showtimeService;
	}

	@GetMapping
	public List<ShowtimeDTO> getAllShowtimes() {
		return showtimeService.getAllShowtimes();
	}

	@PostMapping
	public ResponseEntity<ShowtimeDTO> addShowtime(@RequestBody ShowtimeDTO showtimeDTO) {
		Showtime savedShowtime = showtimeService.addShowtime(showtimeDTO);

		ShowtimeDTO responseDTO = new ShowtimeDTO(savedShowtime.getShowtimeId(), savedShowtime.getMovie().getMovieId(),
				savedShowtime.getTheatre().getTheatreId(), savedShowtime.getShowDate(),
				savedShowtime.getAvailableSeats());

		return ResponseEntity.ok(responseDTO);
	}
}
