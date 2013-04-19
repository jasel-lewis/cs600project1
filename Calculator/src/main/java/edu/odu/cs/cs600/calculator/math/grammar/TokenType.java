package edu.odu.cs.cs600.calculator.math.grammar;

/**
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/TokenType.java
 * Write-up: http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/
 */
public enum TokenType {
	LEFT_PARENTHESIS,
	RIGHT_PARENTHESIS,
	PLUS,
	MINUS,
	ASTERISK,
	SLASH,
	CARET,
	BANG,
	NUMBER,
	EOF;
	
	/**
	 * "Punctuators" are tokens that can split identifiers.  If the TokenType represents
	 * a punctuator, this function will get its represented character.
	 * @return
	 */
	public Character punctuator() {
		switch (this) {
			case LEFT_PARENTHESIS:
				return '(';
			case RIGHT_PARENTHESIS:
				return ')';
			case PLUS:
				return '+';
			case MINUS:
				return '-';
			case ASTERISK:
				return '*';
			case SLASH:
				return '/';
			case CARET:
				return '^';
			case BANG:
				return '!';
			default:
				return null;
		}
	}
}