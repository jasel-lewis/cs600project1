package edu.odu.cs.cs600.calculator.math.grammar.exceptions;

/**
 * Generic ParseException to throw when there is a parsing error
 */
public class ParseException extends RuntimeException {
	private static final long serialVersionUID = -4001066107552152346L;

	public ParseException(String message) {
		super(message);
	}
}