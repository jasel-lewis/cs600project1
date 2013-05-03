package edu.odu.cs.cs600.calculator.math.grammar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
// TODO: R. J. - go through and comment all grammar-related classes once Jared's done working on them
// TODO: R. J. - update the PROJECT SUMMARY section of the README file with a summary of the parser implementation
// TODO: Jared - Update the GETTING STARTED and DEVELOPER NOTES in the README
// TODO: R. J. - Develop test cases for the rest of the evaluators
/**
 * Takes a string and splits it into a series of Tokens. Operators and punctuation
 * are mapped to enumerated values. Numbers are turned into NUMBER tokens. All other
 * characters are ignored (entry of such characters is impossible via the GUI
 * interface).
 * <br><br>
 * Write-up: <a href="http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/">http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/</a><br>
 * Adapted from: <a href="https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/Lexer.java">https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/Lexer.java</a>
 */
public class Lexer implements Iterator<Token> 
{
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

	
	/**
	 * Register each of the TokenTypes that are explicit "puncutators"
	 */
	private void init() {
		index = 0;
		
		for (TokenType type : TokenType.values()) {
			Character punctuator = type.getPunctuator();
			
			if (punctuator != null) {
				punctuatorsMap.put(punctuator, type);
			}
		}
	}

	
	/**
	 * Overridden method for the {@link Iterator} interface - for the purposes of this
	 * class, always return true
	 * @return boolean value true
	 */
	@Override
	public boolean hasNext() {
		return true;
	}
	
	
	/**
	 * Return the next identified {@link Token}
	 * @return the next {@link Token}
	 */
	@Override
	public Token next() {
		while (index < phrase.length()) {
			char c = phrase.charAt(index++);

			if (punctuatorsMap.containsKey(c)) {
				// Handle punctuator
				return new Token(punctuatorsMap.get(c), Character.toString(c));
			} else if ((Character.isDigit(c)) || (c == '.')) {
				// Handle numbers
				// digit       [0-9]
				// integer     {digit}+
				// real        ({integer}("."{integer})?|"."{integer}){exponent}?
				int start = index - 1;
				
				while (index < phrase.length()) {
					c = phrase.charAt(index);
					
					if (Character.isDigit(c) || (c == '.')) {
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

	
	/**
	 * Overridden method for the {@link Iterator} interface - for the purposes of this
	 * class, simply throw an {@link UnsupportedOperationException} as this method
	 * holds no value in the overall implementation and should not be called
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
