package edu.odu.cs.cs600.calculator.math.grammar;

import edu.odu.cs.cs600.calculator.grammar.Phrase;

// Tokenizer provides a mechanism for dividing a string into "Tokens",
// units that we want to treat as single elements during parsing or 
// structured inputs. This Tokenizer (a.k.a., "scanner" or "lexical 
// analyzer") is oriented towards recognizing
//    1) numbers
//    2) string literals
//    3) reserved words
//    4) non-reserved words
//    5) comments
//    6) operators (any non-whitespace character not contributing to one
//         of the above token categories
// The Tokenizer indicates both the kind of token found and the "lexeme", the
// precise string of characters contributing to that token.
//
// Most of the operations of the Tokenizer class are for tweaking the 
// character set that can appear in words, operators, whitespace, etc.
// and for predefining a set of reserved words.
//
class Tokenizer {
	public static final int NUMBER = 1;
	public static final int OPERATOR = 2;
	public static final int GROUPER = 3;
	public static final int END_OF_PHRASE = 5;
	public static final int INVALID = 8;
	
	private static String NUMBERS = "0123456789";
	private static String DECIMAL = ".";
	private StringBuffer buffer = null;
	private StringBuffer lexeme = null;
	private int tokenType = 0;
	
	
	public Tokenizer(Phrase phrase) {
		buffer = new StringBuffer(phrase.toString());
		lexeme = new StringBuffer();
		tokenType = INVALID;
	}
	
	
	
	/**
	 * Identify the next token, discard the past-recognized token
	 * @return
	 */
	public int recognizeNextToken() {
		tokenType = INVALID;
		lexeme = new StringBuffer();
		
		if (buffer.length() > 0) {
			if ((NUMBERS.indexOf(buffer.charAt(0)) >= 0) || (DECIMAL.indexOf(buffer.charAt(0)) >= 0)) {
System.err.println("in recognizeNextToken(): buffer.charAt(0): " + buffer.charAt(0));
				tokenType = recognizeNumber();
			}
		} else {
			tokenType = END_OF_PHRASE;
		}
		
		return (tokenType);
	}
	
	
	
	private int recognizeNumber() {
		tokenType = NUMBER;
		
		recognizeWholeNumber();
		
		if ((buffer.length() > 0) && (buffer.charAt(0) == '.')) {
System.err.println("in recognizeNumber(): buffer.charAt(0): " + buffer.charAt(0));
			lexeme.append(buffer.charAt(0));
			buffer = buffer.deleteCharAt(0);
			
			recognizeWholeNumber();
		}
		
		return tokenType;
	}
	
	
	
	private void recognizeWholeNumber() {
		lexeme.append(buffer.charAt(0));
		buffer = buffer.deleteCharAt(0);
		
		while ((buffer.length() > 0) && (NUMBERS.indexOf(buffer.charAt(0)) >= 0)) {
System.err.println("in recognizeWholeNumber(): buffer.charAt(0): " + buffer.charAt(0));
			lexeme.append(buffer.charAt(0));
			buffer = buffer.deleteCharAt(0);
		}
	}
	
	
	
	/**
	 * Return the type of the current, identified token
	 * @return
	 */
	public int getTokenType() {
		return tokenType;
	}
	
	
	
	/**
	 * Return the lexeme of the current, identified token
	 * @return
	 */
	public String getToken() {
		return lexeme.toString();
	}
}