package edu.odu.cs.cs600.calculator.math.grammar;

import edu.odu.cs.cs600.calculator.exceptions.InvalidTokenException;

public class MultiplyOperationToken extends Token {
	private static final String MULTIPLY_OPERATORS = "*/";
	
	public MultiplyOperationToken(StringBuffer phrase) {
		super(phrase);
	}
	
	

	@Override
	public void recognize() throws InvalidTokenException {
		if ((phrase.length() > 0) && (MULTIPLY_OPERATORS.indexOf(phrase.charAt(0)) >= 0)) {
			popCharIntoLexeme();
		}
	}
}