package com.nmscinemas.nms_cinemas_backend.entity;

import java.sql.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "showtimes")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtimeId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date showDate;

    @Column(nullable = false)
    private int availableSeats;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;
    
    public Showtime() {}

	public Showtime(Long showtimeId, Movie movie, Theatre theatre, Date showDate, int availableSeats,
			Timestamp createdAt) {
		this.showtimeId = showtimeId;
		this.movie = movie;
		this.theatre = theatre;
		this.showDate = showDate;
		this.availableSeats = availableSeats;
		this.createdAt = createdAt;
	}

	public Long getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Long showtimeId) {
		this.showtimeId = showtimeId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
    
    
}
