/**
 * 
 */
package com.tarzen.cavelooter.exceptions;

/**
 * This exception is thrown when no player exists.
 */
public class PlayerNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PlayerNotFoundException() {
		super();
	}

	/**
	 * @param message
	 */
	public PlayerNotFoundException(String message) {
		super(message);
	}

}
