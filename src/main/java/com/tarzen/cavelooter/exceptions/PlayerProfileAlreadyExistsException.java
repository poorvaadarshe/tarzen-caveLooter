package com.tarzen.cavelooter.exceptions;

public class PlayerProfileAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PlayerProfileAlreadyExistsException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PlayerProfileAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public PlayerProfileAlreadyExistsException(String message) {
		super(message);
	}

	
}
