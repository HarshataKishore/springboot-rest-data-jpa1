package com.cg.springbootrestdatajpa1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sno;
	
	@NotEmpty(message = "Movie Name is required")
	private String movieName;
	
	@Min(value=1)
	@Max(value=5)
	@NotNull(message = "Rating is required")
	private long rating;
	
	@NotEmpty(message = "Genre is required")
	private String genre;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(long sno, @NotEmpty(message = "Movie Name is required") String movieName,
			@NotNull(message = "Rating is required") long rating,
			@NotEmpty(message = "Genre is required") String genre) {
		super();
		this.sno = sno;
		this.movieName = movieName;
		this.rating = rating;
		this.genre = genre;
	}

	public long getSno() {
		return sno;
	}

	public void setSno(long sno) {
		this.sno = sno;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public long getRating() {
		return rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [sno=" + sno + ", movieName=" + movieName + ", rating=" + rating + ", genre=" + genre + "]";
	}

	

}
