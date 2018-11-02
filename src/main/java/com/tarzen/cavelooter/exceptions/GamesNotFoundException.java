/**
 * 
 */
package com.tarzen.cavelooter.exceptions;

/**
 *
 */
public class GamesNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GamesNotFoundException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public GamesNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public GamesNotFoundException(String message) {
		super(message);
	}

}
