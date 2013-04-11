package edu.odu.cs.cs600.calculator.exceptions;

public class InvalidTokenException extends RuntimeException {
	private static final long serialVersionUID = -5573921940891741046L;
	private String message = null;

	public InvalidTokenException(String message) {
		super(message);
		this.message = message;
	}
	
	
	
	public InvalidTokenException(Throwable cause) {
		super(cause);
	}
	
	
	
	public InvalidTokenException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}
	
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
	
	@Override
	public String toString() {
		return message;
	}
}