package edu.odu.cs.cs600.calculator.math.grammar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.odu.cs.cs600.calculator.math.grammar.parselet.InfixParselet;
import edu.odu.cs.cs600.calculator.math.grammar.parselet.PrefixParselet;

/**
 * This is a top-down, predictive (recursive-descent) LL(1) Pratt parser.  This class
 * effectively owns the Token stream, handles the look ahead and provides the numerous,
 * small functions (one for each non-terminal) corresponding to the left side
 * non-terminal of the applied productions.
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
 * 
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/Parser.java
 * Write-up: http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/
 * Modified using information from:
 *  - http://dragonbook.stanford.edu/lecture-notes/Stanford-CS143/07-Top-Down-Parsing.pdf
 *  - http://code.google.com/p/pegtl/
 * Further references:
 *  - https://www.dpmms.cam.ac.uk/~wtg10/grammar.pdf
 *  - http://en.wikipedia.org/wiki/Addition
 */
public class Parser {
	private final Iterator<Token> tokenIterator;
	private final List<Token> tokens = new ArrayList<Token>();
	private final Map<TokenType, PrefixParselet> prefixParseletMap = new HashMap<TokenType, PrefixParselet>();
	private final Map<TokenType, InfixParselet> infixParseletMap = new HashMap<TokenType, InfixParselet>();
	
	public Parser(Iterator<Token> tokenIterator) {
		this.tokenIterator = tokenIterator;
	}

	
	
	public void register(TokenType token, PrefixParselet parselet) {
		prefixParseletMap.put(token, parselet);
	}

	
	
	public void register(TokenType token, InfixParselet parselet) {
		infixParseletMap.put(token, parselet);
	}

	
	
	public Expression parseExpression(int precedence) {
		Token token = consume();
		PrefixParselet prefix = prefixParseletMap.get(token.getTokenType());

		if (prefix == null) {
			throw new ParseException("Could not parse \"" + token.getLexeme() + "\".");
		}

		Expression left = prefix.parse(this, token);

		while (precedence < getPrecedence()) {
			token = consume();
			InfixParselet infix = infixParseletMap.get(token.getTokenType());
			left = infix.parse(this, left, token);
		}

		return left;
	}

	
	
	public Expression parseExpression() {
		return parseExpression(0);
	}

	
	
	public boolean match(TokenType expected) {
		Token token = lookAhead(0);
		
		if (token.getTokenType() != expected) {
			return false;
		}

		consume();
		return true;
	}

	
	
	public Token consume(TokenType expected) {
		Token token = lookAhead(0);
		
		if (token.getTokenType() != expected) {
			throw new RuntimeException("Expected token " + expected + " and found " + token.getTokenType());
		}

		return consume();
	}

	
	
	public Token consume() {
		// Make sure we've read the token.
		lookAhead(0);

		return tokens.remove(0);
	}

	
	
	private Token lookAhead(int distance) {
		// Read in as many as needed.
		while (distance >= tokens.size()) {
			tokens.add(tokenIterator.next());
		}

		// Get the queued token.
		return tokens.get(distance);
	}

	
	
	private int getPrecedence() {
		InfixParselet parser = infixParseletMap.get(lookAhead(0).getTokenType());
		int retVal = 0;
		
		if (parser != null) {
			retVal = parser.getPrecedence();
		}

		return retVal;
	}
}