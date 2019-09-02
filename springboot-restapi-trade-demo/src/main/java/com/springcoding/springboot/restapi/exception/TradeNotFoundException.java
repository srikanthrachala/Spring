package com.springcoding.springboot.restapi.exception;

/**
 * Exception Class for Trade Not Found
 * 
 * @author Srikanth
 *
 */
public class TradeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TradeNotFoundException(Long id) {
		super("Could not find Trade " + id);
	}

	public TradeNotFoundException(String message) {
		super(message);
	}
}
