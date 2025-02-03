package com.nmscinemas.nms_cinemas_backend.exception;

public class InvalidShowtimeDataException extends RuntimeException {
    public InvalidShowtimeDataException(String message) {
        super(message);
    }
}
