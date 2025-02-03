package com.nmscinemas.nms_cinemas_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nmscinemas.nms_cinemas_backend.dto.TheatreDTO;
import com.nmscinemas.nms_cinemas_backend.entity.Movie;
import com.nmscinemas.nms_cinemas_backend.entity.Theatre;

import com.nmscinemas.nms_cinemas_backend.exception.InvalidTheatreDataException;
import com.nmscinemas.nms_cinemas_backend.service.TheatreService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/theatres")
public class TheatreController {
	private final TheatreService theatreService;

	public TheatreController(TheatreService theatreService) {
		this.theatreService = theatreService;
	}

	@GetMapping
	public List<Theatre> getAllTheatres() {
		return theatreService.getAllTheatres();
	}

	@PostMapping
	public ResponseEntity<?> addTheatre(@RequestBody TheatreDTO theatreDTO) {
		try {
			Theatre savedTheatre = theatreService.addTheatre(theatreDTO);
			return ResponseEntity.ok(savedTheatre);
		} catch (InvalidTheatreDataException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
