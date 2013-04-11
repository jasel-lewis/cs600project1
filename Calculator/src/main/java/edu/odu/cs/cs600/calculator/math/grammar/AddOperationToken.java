package edu.odu.cs.cs600.calculator.math.grammar;

import edu.odu.cs.cs600.calculator.exceptions.InvalidTokenException;

public class AddOperationToken extends Token {
	private static final String ADD_OPERATORS = "+-";

	public AddOperationToken(StringBuffer phrase) {
		super(phrase);
	}
	
	

	@Override
	public void recognize() throws InvalidTokenException {
		if ((phrase.length() > 0) && (ADD_OPERATORS.indexOf(phrase.charAt(0)) >= 0)) {
			popCharIntoLexeme();
		}
	}
}