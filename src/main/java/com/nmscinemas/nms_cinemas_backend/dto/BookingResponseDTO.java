package com.nmscinemas.nms_cinemas_backend.dto;

public class BookingResponseDTO {
    private Long bookingId;
    private Long userId;
    private Long showtimeId;
    private int numberOfTickets;

    public BookingResponseDTO() {}

    public BookingResponseDTO(Long bookingId, Long userId, Long showtimeId, int numberOfTickets) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.showtimeId = showtimeId;
        this.numberOfTickets = numberOfTickets;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Long showtimeId) {
        this.showtimeId = showtimeId;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
