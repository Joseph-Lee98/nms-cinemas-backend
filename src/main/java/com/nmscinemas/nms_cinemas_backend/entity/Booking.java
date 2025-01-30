package com.nmscinemas.nms_cinemas_backend.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    private Showtime showtime;

    @Column(nullable = false)
    private int numberOfTickets;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp bookedAt;
    
    public Booking() {}

	public Booking(Long bookingId, User user, Showtime showtime, int numberOfTickets, Timestamp bookedAt) {
		this.bookingId = bookingId;
		this.user = user;
		this.showtime = showtime;
		this.numberOfTickets = numberOfTickets;
		this.bookedAt = bookedAt;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Showtime getShowtime() {
		return showtime;
	}

	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public Timestamp getBookedAt() {
		return bookedAt;
	}

	public void setBookedAt(Timestamp bookedAt) {
		this.bookedAt = bookedAt;
	}
    
    
}
