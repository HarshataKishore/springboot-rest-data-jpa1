package com.cg.springbootrestdatajpa1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends Exception {
	public MovieNotFoundException() {}
	public MovieNotFoundException(String message) {
		super(message);
	}

}
