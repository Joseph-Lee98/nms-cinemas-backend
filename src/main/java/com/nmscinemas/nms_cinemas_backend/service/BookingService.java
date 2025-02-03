package com.nmscinemas.nms_cinemas_backend.service;

import org.springframework.stereotype.Service;
import com.nmscinemas.nms_cinemas_backend.dto.BookingDTO;
import com.nmscinemas.nms_cinemas_backend.entity.Booking;
import com.nmscinemas.nms_cinemas_backend.entity.Showtime;
import com.nmscinemas.nms_cinemas_backend.entity.User;
import com.nmscinemas.nms_cinemas_backend.exception.InvalidBookingException;
import com.nmscinemas.nms_cinemas_backend.repository.BookingRepository;
import com.nmscinemas.nms_cinemas_backend.repository.ShowtimeRepository;
import com.nmscinemas.nms_cinemas_backend.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ShowtimeRepository showtimeRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, ShowtimeRepository showtimeRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showtimeRepository = showtimeRepository;
    }

    @Transactional
    public Booking addBooking(BookingDTO bookingDTO) {
        
        User user = userRepository.findById(bookingDTO.getUserId())
                .orElseThrow(() -> new InvalidBookingException("Invalid user ID: " + bookingDTO.getUserId()));

      
        Showtime showtime = showtimeRepository.findById(bookingDTO.getShowtimeId())
                .orElseThrow(() -> new InvalidBookingException("Invalid showtime ID: " + bookingDTO.getShowtimeId()));

      
        if (showtime.getAvailableSeats() < bookingDTO.getNumberOfTickets()) {
            throw new InvalidBookingException("Not enough available seats.");
        }

     
        showtime.setAvailableSeats(showtime.getAvailableSeats() - bookingDTO.getNumberOfTickets());
        showtimeRepository.save(showtime);

     
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowtime(showtime);
        booking.setNumberOfTickets(bookingDTO.getNumberOfTickets());

        return bookingRepository.save(booking);
    }
}
