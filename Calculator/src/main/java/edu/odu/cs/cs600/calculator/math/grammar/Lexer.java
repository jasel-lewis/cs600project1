package edu.odu.cs.cs600.calculator.math.grammar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
// TODO: R. J. - go through and comment all grammar-related classes once Jared's done working on them
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
	 * Create a new Lexer to tokenize the given Phrase
	 * @param phrase {@link Phrase} to tokenize
	 */
	public Lexer(Phrase phrase) {
		this.phrase = phrase.toString(false);
		init();
	}

	
	
	private void init() {
		index = 0;

		// Register all of the TokenTypes that are explicit punctuators
		for (TokenType type : TokenType.values()) {
			Character punctuator = type.getPunctuator();
			
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
//		boolean decimalEncountered = false;
		
		while (index < phrase.length()) {
			char c = phrase.charAt(index++);

			if (punctuatorsMap.containsKey(c)) {
				// Handle punctuator
				return new Token(punctuatorsMap.get(c), Character.toString(c));
			} else if ((Character.isDigit(c)) || (c == '.')) {
				// Handle numbers
				// digit       [0-9]
				// integer     {digit}+
				// exponent    [eE][+-]?{integer}
				// real        ({integer}("."{integer})?|"."{integer}){exponent}?
				int start = index - 1;
				while (index < phrase.length()) {
					c = phrase.charAt(index);
					
					if (Character.isDigit(c) || (c == '.')) {
//					if (Character.isDigit(c)) {
//						index++;
//					} else if ((c == '.') && !decimalEncountered) {
//						decimalEncountered = true;
						index++;
					} else {
						break;
					}
				}

				String number = phrase.substring(start, index);
				return new Token(TokenType.NUMBER, number);
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