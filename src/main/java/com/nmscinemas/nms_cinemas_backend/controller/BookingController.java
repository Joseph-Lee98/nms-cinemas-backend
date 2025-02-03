package com.nmscinemas.nms_cinemas_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nmscinemas.nms_cinemas_backend.dto.BookingDTO;
import com.nmscinemas.nms_cinemas_backend.entity.Booking;
import com.nmscinemas.nms_cinemas_backend.service.BookingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        Booking savedBooking = bookingService.addBooking(bookingDTO);

        BookingDTO responseDTO = new BookingDTO(
                savedBooking.getUser().getUserId(),
                savedBooking.getShowtime().getShowtimeId(),
                savedBooking.getNumberOfTickets()
        );

        return ResponseEntity.ok(responseDTO);
    }
}
