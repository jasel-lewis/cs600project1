package edu.odu.cs.cs600.calculator.math.grammar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Takes a string and splits it into a series of Tokens. Operators and punctuation
 * are mapped to unique keywords. Numbers are turned into NUMBER tokens. All other
 * characters are ignored.
 * 
 * Write-up: http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/
 * Adapted from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/Lexer.java
 */
public class Lexer implements Iterator<Token> {
	private final Map<Character, TokenType> punctuatorsMap = new HashMap<Character, TokenType>();
	private final String phrase;
	private int index = 0;

	/**
	 * Creates a new Lexer to tokenize the given string.
	 * @param phrase String to tokenize
	 */
	public Lexer(String phrase) {
		index = 0;
		this.phrase = phrase;

		// Register all of the TokenTypes that are explicit punctuators
		for (TokenType type : TokenType.values()) {
			Character punctuator = type.punctuator();
			
			if (punctuator != null) {
				punctuatorsMap.put(punctuator, type);
			}
		}
	}

	
	
	@Override
	public boolean hasNext() {
		return true;
	}

	
	
	@Override
	public Token next() {
		while (index < phrase.length()) {
			char c = phrase.charAt(index++);

			if (punctuatorsMap.containsKey(c)) {
				// Handle punctuation
				return new Token(punctuatorsMap.get(c), Character.toString(c));
			} else if (Character.isLetter(c)) {
				// Handle names
				int start = index - 1;
				while (index < phrase.length()) {
					if (!Character.isLetter(phrase.charAt(index))) break;
					index++;
				}

				String name = phrase.substring(start, index);
				return new Token(TokenType.NAME, name);
			} else {
				// Ignore all other characters (whitespace, etc.)
			}
		}

		// Once we've reached the end of the string, just return EOF tokens. We'll
		// just keeping returning them as many times as we're asked so that the
		// parser's lookahead doesn't have to worry about running out of tokens.
		return new Token(TokenType.EOF, "");
	}

	
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}