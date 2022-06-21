package com.cg.springbootrestdatajpa1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springbootrestdatajpa1.exception.MovieNotFoundException;
import com.cg.springbootrestdatajpa1.model.Movie;
import com.cg.springbootrestdatajpa1.service.MovieService;


@RestController
@RequestMapping("/api")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@PostMapping("/movie/new")
	public Movie createMovie(@Valid @RequestBody Movie movie) {
		return movieService.createMovie(movie);
	}
	@GetMapping("/movie/all")
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	@GetMapping("/movie/sno/{sno}")
	public ResponseEntity<Movie> getMovieBySno(@PathVariable(value="sno") Long serNo) throws MovieNotFoundException{
		Movie movie=movieService.getMovieBySno(serNo).orElseThrow(() -> new MovieNotFoundException("No Movie found with this id:"+serNo));
		return ResponseEntity.ok().body(movie);
	}
	
	
	@GetMapping("/movie/genre/{genre}")
	public List<Movie> getAllMoviesByGenre(@PathVariable(value="genre") String genre){
		return movieService.getAllMoviesBygenre(genre);
	}
	@PutMapping("/movie/update/{sno}")
	public ResponseEntity<Movie> updateMovie(@Valid @PathVariable(value="sno") Long serNo, @RequestBody Movie movDetails) throws MovieNotFoundException{
		Movie movie=movieService.getMovieBySno(serNo).orElseThrow(() -> new MovieNotFoundException("No Movie found with this id:"+serNo));
		movie.setMovieName(movDetails.getMovieName());
		movie.setRating(movDetails.getRating());
		movie.setGenre(movDetails.getGenre());
		
		Movie updatedMovie=movieService.updateMovie(movie);
		return ResponseEntity.ok(updatedMovie);
	}
	
	@DeleteMapping("/movie/delete/{sno}")
	public Map<String, Boolean> deleteMovie(@PathVariable(value="sno") Long serNo) throws MovieNotFoundException {
		Movie movie=movieService.getMovieBySno(serNo).orElseThrow(() -> new MovieNotFoundException("No Movie found with this id:"+serNo));
		movieService.deleteMovie(movie);
		Map<String, Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;	
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgNotValid(MethodArgumentNotValidException ex){
		 Map<String, String> errors=new HashMap<>();
		 ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage())); 
		 return errors;
	}
}


