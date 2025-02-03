package com.nmscinemas.nms_cinemas_backend.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nmscinemas.nms_cinemas_backend.dto.BookingRequestDTO;
import com.nmscinemas.nms_cinemas_backend.dto.BookingResponseDTO;
import com.nmscinemas.nms_cinemas_backend.dto.BookingUpdateDTO;
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
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {
        Booking savedBooking = bookingService.addBooking(bookingRequestDTO);

        BookingResponseDTO responseDTO = new BookingResponseDTO(
                savedBooking.getBookingId(),
                savedBooking.getUser().getUserId(),
                savedBooking.getShowtime().getShowtimeId(),
                savedBooking.getNumberOfTickets()
        );

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<BookingResponseDTO>> getBookingsByUserId(@PathVariable Long userId) {
        List<BookingResponseDTO> bookings = bookingService.getBookingsByUserId(userId);
        return ResponseEntity.ok(bookings);
    }
    
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok("Booking deleted successfully.");
    }
    
    @PatchMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable Long bookingId, 
            @RequestBody BookingUpdateDTO bookingUpdateDTO) {
        
        Booking updatedBooking = bookingService.updateBooking(bookingId, bookingUpdateDTO.getNumberOfTickets());
        return ResponseEntity.ok(updatedBooking);
    }
}
