package com.nmscinemas.nms_cinemas_backend.dto;

import java.time.LocalDate;

public class MovieDTO {
    private String title;
    private String genre;
    private String language;
    private int durationMinutes;
    private String description;
    private String posterUrl;

    public MovieDTO() {}

    public MovieDTO(String title, String genre, String language, int durationMinutes, String description, String posterUrl) {
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.durationMinutes = durationMinutes;
        this.description = description;
        this.posterUrl = posterUrl;
    }

  
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
