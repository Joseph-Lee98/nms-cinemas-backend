package com.nmscinemas.nms_cinemas_backend.exception;

public class InvalidMovieDataException extends RuntimeException {
    public InvalidMovieDataException(String message) {
        super(message);
    }
}
