package edu.odu.cs.cs600.calculator.math.grammar;

import java.util.Vector;

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
class TokenizerOld {
	private static final int INVALID = 0;
	private static final int END_OF_INPUT = 1;
	private static final int POSITIVE_WHOLE_NUMBER = 2;
	private static final int POSITIVE_REAL_NUMBER = 3;
	private static final int OPERATOR = 4;
	private static final boolean caseSensitive = false;
	private String buffer = null;
	private String lexeme = null;
	private int tokenType = 0;
	private boolean signedNumbers;
	private boolean[][] characterCodes;
	
	
	public TokenizerOld(Phrase phrase) {
		buffer = phrase.toString();
		lexeme = new String();
		signedNumbers = false;
	}
	
	
	
	void setCharType(char c, int characterType) {
		characterCodes[characterType][c] = true;
	}
	
	
	
	void setCharType(char cstart, char cstop, int characterType) {
		for (char c = cstart; c <= cstop; ++c) {
			characterCodes[characterType][c] = true;
		}
	}
	
	
	
	void clearCharType(int characterType) {
		for (int i = 0; i < 256; ++i) {
			characterCodes[characterType][i] = false;
		}
	}
	
	
	
	void clearCharType(char c, int characterType) {
		characterCodes[characterType][c] = false;
	}
	
	
	
	void clearCharType(char cstart, char cstop, int characterType) {
		for (char c = cstart; c <= cstop; ++c) {
			characterCodes[characterType][c] = false;
		}
	}
	
	
	
	
	void setSignedNumbers(boolean signed) {
		signedNumbers = signed;
	}
	
	
	
	// Get a token, discarding all info about the previous token (if any)
	int getNextToken() {
		tokenType = INVALID;
		lexeme = "";
		
		if (buffer.length() == 0) {
			return (tokenType = END_OF_INPUT); 
		}
		
		// Check for numbers
		if (((!signedNumbers) &&
				(buffer.charAt(0) == '+' || buffer.charAt(0) == '-')) ||
				(buffer.charAt(0) >= '0' && buffer.charAt(0) <= '9')) {
			int matchedLength = 0;
			
			if ((!signedNumbers)
					&& (buffer.charAt(0) == '+' || buffer.charAt(0) == '-')) {
				matchedLength = 1;
			}
			
			tokenType = INVALID;
			
			while (matchedLength < buffer.length() &&
					buffer.charAt(matchedLength) >= '0' &&
					buffer.charAt(matchedLength) <= '9') {
				tokenType = POSITIVE_WHOLE_NUMBER;
				++matchedLength;
			}
			
			int lastAcceptedLength = matchedLength;
			
			if (matchedLength < buffer.length() &&
					(buffer.charAt(matchedLength) == '.' ||
					buffer.charAt(matchedLength) == 'E' ||
					buffer.charAt(matchedLength) == 'e')) {
				
				if (buffer.charAt(matchedLength) == '.') {
					++matchedLength;
					tokenType = POSITIVE_REAL_NUMBER;
					
					while (matchedLength < buffer.length() &&
							buffer.charAt(matchedLength) >= '0' &&
							buffer.charAt(matchedLength) <= '9') {
						++matchedLength;
					}
					
					lastAcceptedLength = matchedLength;
				}
				
				if (matchedLength < buffer.length() &&
						(buffer.charAt(matchedLength) == 'E' ||
						buffer.charAt(matchedLength) == 'e')) {
					++matchedLength;
					
					if (buffer.charAt(matchedLength) == '+' ||
							buffer.charAt(matchedLength) == '-') {
						++matchedLength;
					}
					
					while (matchedLength < buffer.length() &&
							buffer.charAt(matchedLength) >= '0' &&
							buffer.charAt(matchedLength) <= '9') {
						++matchedLength;
						tokenType = POSITIVE_REAL_NUMBER;
						lastAcceptedLength = matchedLength;
					}
				}
			}
			
			if (tokenType != INVALID) {
				lexeme = buffer.substring(0, lastAcceptedLength);
				buffer = buffer.substring(lastAcceptedLength);
				return tokenType;
			}
		}
		
		// Anything else is an operator
		lexeme = buffer.substring(0, 1);
		buffer = buffer.substring(1);
		tokenType = OPERATOR;
		return tokenType;
	}
	
	
	
	/**
	 * Return the type of the current token
	 * @return
	 */
	public int getTokenType() {
		return tokenType;
	}
	
	
	
	/**
	 * Return the lexeme of the current token
	 * @return
	 */
	public String getLexeme() {
		return lexeme;
	}
	
	
	
	/**
	 * Lexeme has been identified as a WHOLE_NUMBER.  Attempt to
	 * return the lexeme as an integer
	 * @return
	 */
	public int getIntegerValue() {
		try {
			Integer i = new Integer(lexeme);
			return i.intValue();
		} catch (NumberFormatException nfe) {
			return 0;
		}
	}
	
	
	
	/**
	 * Lexeme has been identified as a REAL_NUMBER.  Attempt to
	 * return the lexeme as a double
	 * @return
	 */
	public double getRealValue() {
		try {
			Double d = new Double(lexeme);
			return d.doubleValue();
		} catch (NumberFormatException nfe) {
			return 0.0;
		}
	}


//TODO: Do we need this method?
    boolean matchPrefix(String str)
    // Compare str agaisnt the start of the buffer
    {
    	for (int i = 0; i < str.length(); ++i) {
    		if (buffer.charAt(i) != str.charAt(i)) {
    			if (!caseSensitive) {
    				char bc = buffer.charAt(i);
    				char sc = str.charAt(i);
    				if (bc >= 'A' && bc <= 'Z')
    					bc += ('a' - 'A');
    				if (sc >= 'A' && sc <= 'Z')
    					sc += ('a' - 'A');
    				if (bc != sc)
    					return false;
    			}
    			else
    				return false;
    		}
    	}
    	return true;
    }
}