package edu.odu.cs.cs600.calculator.math.grammar;

import edu.odu.cs.cs600.calculator.exceptions.InvalidTokenException;
import edu.odu.cs.cs600.calculator.grammar.Phrase;

/**
 * https://www.dpmms.cam.ac.uk/~wtg10/grammar.pdf
 * http://en.wikipedia.org/wiki/Addition
 * 
 * The expression grammar:
 * <phrase> ::= <term> {<addop> <term>}  
 * <term>   ::= <factor> {<mulop> <factor>}
 * <factor> ::= -<item> 
 *            | <item>
 * <item>   ::= <number>
 *            | (<phrase>)
 * <number> ::= PositiveWholeNumber
 *            | PositiveRealNumber
 * <addop>  ::= +
 *            | -
 * <mulop>  ::= *
 *            | /
 */
public class ParserOld {
	// Kept private to prevent instantiation of this object, the parse() method is all you'll need,
	// and this utility class should remain stateless.
	private ParserOld() {};
	
	public static double parse(String expression) {
		// TODO : Replace the contents of this method w/ the logic to actually evaluate the expression
		return Double.valueOf(expression);
	}
	
	
	
	public static double parse(Phrase phrase) {
		Tokenizer tokenizer = new Tokenizer(phrase);
		Double value = null;
		
		while (tokenizer.recognizeNextToken() != Tokenizer.END_OF_PHRASE) {
			switch (tokenizer.getTokenType()) {
				case Tokenizer.NUMBER:
					try {
						value = new Double(tokenizer.getToken());
					} catch (NumberFormatException nfe) {
						return 0.0;
					}
					break;
				case Tokenizer.OPERATOR:
					System.err.println("Tokenizer.getNextToken() returned operator");
					break;
				case Tokenizer.GROUPER:
					System.err.println("Tokenizer.getNextToken() returned grouper");
					break;
				case Tokenizer.INVALID:
					String message = "Encountered an invalid token in the Phrase.\n";
					message.concat("-- Original Phrase: " + phrase.toString() + "\n");
					message.concat("-- Tokenizer has processed: " + tokenizer.getToken() + "\n");
					message.concat("-- Tokenizer has not processed: " + tokenizer.getBufferString() + "\n");
					throw new InvalidTokenException(message);
				default:
					System.err.println("Tokenizer.getNextToken() returned unknown token type");
			
			}
		}
		
		return value.doubleValue();
	}
}