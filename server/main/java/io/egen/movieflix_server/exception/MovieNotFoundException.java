package io.egen.movieflix_server.exception;

public class MovieNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	public MovieNotFoundException(String message){
		super(message);
	}
	
	public MovieNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}