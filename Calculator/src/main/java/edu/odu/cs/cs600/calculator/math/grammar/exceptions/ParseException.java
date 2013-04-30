package edu.odu.cs.cs600.calculator.math.grammar.exceptions;

/**
 * Generic Exception to throw when an error occurs while parsing
 */
public class ParseException extends RuntimeException {
	private static final long serialVersionUID = -4001066107552152346L;
	
	
	/**
	 * Constructor
	 * @param message The explanation for the exception
	 */
	public ParseException(String message) {
		super(message);
	}
}