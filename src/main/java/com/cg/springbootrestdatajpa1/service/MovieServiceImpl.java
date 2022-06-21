package com.cg.springbootrestdatajpa1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.springbootrestdatajpa1.model.Movie;
import com.cg.springbootrestdatajpa1.repository.MovieRepository;



@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Optional<Movie> getMovieBySno(Long sno) {
		return movieRepository.findById(sno);
	}

	@Override
	public List<Movie> getAllMoviesBygenre(String genre) {
		return movieRepository.findByGenre(genre);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(Movie movie) {
		movieRepository.delete(movie);
	}

}
