package com.nmscinemas.nms_cinemas_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.nmscinemas.nms_cinemas_backend.dto.BookingRequestDTO;
import com.nmscinemas.nms_cinemas_backend.dto.BookingResponseDTO;
import com.nmscinemas.nms_cinemas_backend.entity.Booking;
import com.nmscinemas.nms_cinemas_backend.entity.Showtime;
import com.nmscinemas.nms_cinemas_backend.entity.User;
import com.nmscinemas.nms_cinemas_backend.exception.BookingNotFoundException;
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
    public Booking addBooking(BookingRequestDTO bookingRequestDTO) {
        User user = userRepository.findById(bookingRequestDTO.getUserId())
                .orElseThrow(() -> new InvalidBookingException("Invalid user ID: " + bookingRequestDTO.getUserId()));

        Showtime showtime = showtimeRepository.findById(bookingRequestDTO.getShowtimeId())
                .orElseThrow(() -> new InvalidBookingException("Invalid showtime ID: " + bookingRequestDTO.getShowtimeId()));

        if (showtime.getAvailableSeats() < bookingRequestDTO.getNumberOfTickets()) {
            throw new InvalidBookingException("Not enough available seats.");
        }

        showtime.setAvailableSeats(showtime.getAvailableSeats() - bookingRequestDTO.getNumberOfTickets());
        showtimeRepository.save(showtime);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowtime(showtime);
        booking.setNumberOfTickets(bookingRequestDTO.getNumberOfTickets());

        return bookingRepository.save(booking);
    }

    public List<BookingResponseDTO> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserUserId(userId)
                .stream()
                .map(booking -> new BookingResponseDTO(
                        booking.getBookingId(),
                        booking.getUser().getUserId(),
                        booking.getShowtime().getShowtimeId(),
                        booking.getNumberOfTickets()
                ))
                .collect(Collectors.toList());
    }
    
    @Transactional
    public void deleteBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking with ID " + bookingId + " not found."));

        Showtime showtime = booking.getShowtime();
        showtime.setAvailableSeats(showtime.getAvailableSeats() + booking.getNumberOfTickets());
        showtimeRepository.save(showtime);

        bookingRepository.delete(booking);
    }
    
    @Transactional
    public Booking updateBooking(Long bookingId, int newNumberOfTickets) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking with ID " + bookingId + " not found."));

        Showtime showtime = booking.getShowtime();
        int currentTickets = booking.getNumberOfTickets();
        int availableSeats = showtime.getAvailableSeats();

        int ticketDifference = newNumberOfTickets - currentTickets;

        if (ticketDifference > availableSeats) {
            throw new InvalidBookingException("Not enough available seats for the update.");
        }

        showtime.setAvailableSeats(showtime.getAvailableSeats() - ticketDifference);
        showtimeRepository.save(showtime);

        booking.setNumberOfTickets(newNumberOfTickets);
        return bookingRepository.save(booking);
    }
}
