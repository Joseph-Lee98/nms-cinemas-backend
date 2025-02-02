package com.nmscinemas.nms_cinemas_backend.service;

import org.springframework.stereotype.Service;

import com.nmscinemas.nms_cinemas_backend.dto.TheatreDTO;
import com.nmscinemas.nms_cinemas_backend.entity.Theatre;
import com.nmscinemas.nms_cinemas_backend.exception.InvalidTheatreDataException;
import com.nmscinemas.nms_cinemas_backend.repository.TheatreRepository;

@Service
public class TheatreService {
	private final TheatreRepository theatreRepository;

	public TheatreService(TheatreRepository theatreRepository) {
		this.theatreRepository = theatreRepository;
	}
	
	 public Theatre addTheatre(TheatreDTO theatreDTO) {
	        validateTheatreDTO(theatreDTO);

	        Theatre theatre = new Theatre(
	                theatreDTO.getName().trim(),
	                theatreDTO.getLocation().trim(),
	                theatreDTO.getCapacity()
	        );

	        return theatreRepository.save(theatre);
	 }
	 
	 private void validateTheatreDTO(TheatreDTO theatreDTO) {
	        if (theatreDTO.getName() == null || theatreDTO.getName().trim().isEmpty()) {
	            throw new InvalidTheatreDataException("Theatre name cannot be empty.");
	        }
	        if (theatreDTO.getName().length() > 255) {
	            throw new InvalidTheatreDataException("Theatre name cannot exceed 255 characters.");
	        }
	        if (theatreDTO.getLocation() == null || theatreDTO.getLocation().trim().isEmpty()) {
	            throw new InvalidTheatreDataException("Theatre location cannot be empty.");
	        }
	        if (theatreDTO.getCapacity() <= 0) {
	            throw new InvalidTheatreDataException("Theatre capacity must be a positive integer.");
	        }
	    }
}
