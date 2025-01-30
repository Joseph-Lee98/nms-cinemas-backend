package com.nmscinemas.nms_cinemas_backend.entity;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.nmscinemas.nms_cinemas_backend.constants.MovieGenre;
import com.nmscinemas.nms_cinemas_backend.constants.MovieLanguage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movieId;

	@Column(nullable = false, length = 255)
	private String title;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private MovieGenre genre;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private MovieLanguage language;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE) 
	private Date releaseDate;

	@Column(nullable = false)
	private int durationMinutes;

	@Column(nullable=false) 
	private String description;

	@Column(nullable=false)
	private String posterUrl;

	@CreationTimestamp 
	@Column(nullable = false, updatable = false)
	private Timestamp createdAt;
	
	public Movie() {}

	public Movie(Long movieId, String title, MovieGenre genre, MovieLanguage language, Date releaseDate,
			int durationMinutes, String description, String posterUrl, Timestamp createdAt) {
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.language = language;
		this.releaseDate = releaseDate;
		this.durationMinutes = durationMinutes;
		this.description = description;
		this.posterUrl = posterUrl;
		this.createdAt = createdAt;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MovieGenre getGenre() {
		return genre;
	}

	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}

	public MovieLanguage getLanguage() {
		return language;
	}

	public void setLanguage(MovieLanguage language) {
		this.language = language;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
