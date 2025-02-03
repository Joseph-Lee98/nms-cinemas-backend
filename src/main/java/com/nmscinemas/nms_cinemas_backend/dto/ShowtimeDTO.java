package com.nmscinemas.nms_cinemas_backend.dto;

import java.sql.Date;

public class ShowtimeDTO {
    private Long showtimeId;
    private Long movieId;
    private Long theatreId;
    private Date showDate;
    private int availableSeats;

    public ShowtimeDTO(Long showtimeId, Long movieId, Long theatreId, Date showDate, int availableSeats) {
        this.showtimeId = showtimeId;
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.showDate = showDate;
        this.availableSeats = availableSeats;
    }

    public Long getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Long showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
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
}
