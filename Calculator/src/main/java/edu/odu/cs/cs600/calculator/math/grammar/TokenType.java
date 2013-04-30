package edu.odu.cs.cs600.calculator.math.grammar;

/**
 * Adapted from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/TokenType.java
 * Write-up: http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/
 */
public enum TokenType {
	LEFT_PARENTHESIS,
	RIGHT_PARENTHESIS,
	PLUS,
	MINUS,
	MULTIPLY,
	DIVIDE,
	POWER,
	NUMBER,
	EOF;
	
	/**
	 * "Punctuators" are tokens that can split identifiers.  If this TokenType represents
	 * a punctuator, this method will get its represented character (wrapped as a {@link Character}).
	 * @return The {@link Character} associated with this TokenType (if a punctuator)
	 */
	public Character getPunctuator() {
		switch (this) {
			case LEFT_PARENTHESIS:
				return '(';
			case RIGHT_PARENTHESIS:
				return ')';
			case PLUS:
				return '+';
			case MINUS:
				return '-';
			case MULTIPLY:
				return '*';
			case DIVIDE:
				return '/';
			case POWER:
				return '^';
			default:
				return null;
		}
	}
}