package edu.odu.cs.cs600.calculator.exceptions;

public class InvalidTokenException extends RuntimeException {
	private static final long serialVersionUID = -5573921940891741046L;

	public InvalidTokenException(String message) {
		super(message);
	}
}