package com.springcoding.springboot.restapi.exception;

/**
 * Exception class for User Not found
 * 
 * @author Srikanth
 *
 */
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long id) {
		super("Could not find User " + id);
	}
}
