package edu.odu.cs.cs600.calculator.math.grammar;

import edu.odu.cs.cs600.calculator.exceptions.InvalidTokenException;

public class NumberToken extends Token {
	private static final String NUMBERS = "0123456789";

	public NumberToken(StringBuffer phrase) {
		super(phrase);
	}

	
	
	@Override
	public void recognize() {
		consumeNumbers();
		
		if ((phrase.length() > 0) && (phrase.charAt(0) == '.')) {
			popCharIntoLexeme();
			consumeNumbers();
		}
	}
	
	
	
	private void consumeNumbers() {
		while ((phrase.length() > 0) && (NUMBERS.indexOf(phrase.charAt(0)) >= 0)) {
			popCharIntoLexeme();
		}
	}
	
	
	
	public double getDoubleRepresentation() {
		double retVal = 0.0;
		
		try {
			retVal = Double.parseDouble(lexeme.toString());
		} catch (NumberFormatException nfe) {
			throw new InvalidTokenException(nfe.toString());
		}
		
		return retVal;
	}
}