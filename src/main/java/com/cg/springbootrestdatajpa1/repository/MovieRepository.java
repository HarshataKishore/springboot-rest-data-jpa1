package com.cg.springbootrestdatajpa1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.springbootrestdatajpa1.model.Movie;



@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	public List<Movie> findByGenre(String genre);
}
