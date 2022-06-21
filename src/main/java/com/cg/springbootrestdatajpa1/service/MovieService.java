package com.cg.springbootrestdatajpa1.service;

import java.util.List;
import java.util.Optional;


import com.cg.springbootrestdatajpa1.model.Movie;



public interface MovieService {
	public Movie createMovie(Movie movie);
	public List<Movie> getAllMovies();
	public Optional<Movie> getMovieBySno(Long serno);
	public List<Movie> getAllMoviesBygenre(String genre);
	public Movie updateMovie(Movie movie);
	public void deleteMovie(Movie movie);

}
