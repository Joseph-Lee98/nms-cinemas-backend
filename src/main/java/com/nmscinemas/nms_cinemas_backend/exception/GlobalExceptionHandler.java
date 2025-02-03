package com.nmscinemas.nms_cinemas_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidBookingException.class)
	public ResponseEntity<Map<String, String>> handleInvalidBookingException(InvalidBookingException ex) {
	    Map<String, String> errorResponse = new HashMap<>();
	    errorResponse.put("error", "Invalid booking request");
	    errorResponse.put("message", ex.getMessage());
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleBookingNotFoundException(BookingNotFoundException ex) {
	    Map<String, String> errorResponse = new HashMap<>();
	    errorResponse.put("error", "Booking not found");
	    errorResponse.put("message", ex.getMessage());
	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleUserNotFoundException(UserNotFoundException ex) {
	    Map<String, String> errorResponse = new HashMap<>();
	    errorResponse.put("error", "User not found");
	    errorResponse.put("message", ex.getMessage());
	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidShowtimeDataException.class)
	public ResponseEntity<Map<String, String>> handleInvalidShowtimeDataException(InvalidShowtimeDataException ex) {
	    Map<String, String> errorResponse = new HashMap<>();
	    errorResponse.put("error", "Invalid showtime data");
	    errorResponse.put("message", ex.getMessage());
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidTheatreDataException.class)
    public ResponseEntity<Map<String, String>> handleInvalidTheatreDataException(InvalidTheatreDataException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Invalid theatre data");
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "User already exists");
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Map<String, String>> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Invalid credentials");
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleMovieNotFoundException(MovieNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Movie not found");
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Map<String, String>> handleGeneralException(GeneralException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Internal server error");
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class) 
    public ResponseEntity<Map<String, String>> handleAllExceptions(Exception ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Unexpected error");
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    

    @ExceptionHandler(InvalidMovieDataException.class)
    public ResponseEntity<Map<String, String>> handleInvalidMovieDataException(InvalidMovieDataException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Invalid movie data");
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
