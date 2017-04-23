package io.egen.movieflix_server.exception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1249486451193722196L;

	public UserNotFoundException(String message){
		super(message);
	
	}
	
	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}
}
