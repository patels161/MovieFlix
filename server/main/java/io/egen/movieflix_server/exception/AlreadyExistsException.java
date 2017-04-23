package io.egen.movieflix_server.exception;

public class AlreadyExistsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyExistsException(String message){
		super(message);
	
	}
	
	public AlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
