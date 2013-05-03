package edu.odu.cs.cs600.calculator.math.grammar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.odu.cs.cs600.calculator.math.grammar.exceptions.ParseException;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.Expression;
import edu.odu.cs.cs600.calculator.math.grammar.parselet.InfixParselet;
import edu.odu.cs.cs600.calculator.math.grammar.parselet.PrefixParselet;

/**
 * This is a top-down, predictive (recursive-descent) LL(1) Pratt parser.  This class
 * effectively owns the Token stream, handles the look ahead and provides the numerous,
 * small functions (one for each non-terminal) corresponding to the left side
 * non-terminal of the applied productions.
 * <br><br>
 * The expression grammar:
 * <pre>
 * {@code
 * <phrase> ::= <term> {<addop> <term>}  
 * <term>   ::= <factor> {<mulop> <factor>}
 * <factor> ::= -<item> 
 *            | <item>
 * <item>   ::= <number>
 *            | (<phrase>)
 * <number> ::= WholeNumber
 *            | RealNumber
 * <addop>  ::= +
 *            | -
 * <mulop>  ::= *
 *            | /
 * }
 * </pre>
 * 
 * Adapted from: <a href="https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/Parser.java">https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/Parser.java</a><br>
 * Write-up: <a href="http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/">http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/</a><br>
 * <br>
 * Modified using information from:
 * <ul>
 *   <li><a href="http://dragonbook.stanford.edu/lecture-notes/Stanford-CS143/07-Top-Down-Parsing.pdf">http://dragonbook.stanford.edu/lecture-notes/Stanford-CS143/07-Top-Down-Parsing.pdf</a></li>
 *   <li><a href="http://code.google.com/p/pegtl/">http://code.google.com/p/pegtl/</a></li>
 * </ul>
 * Further references:
 * <ul>
 *   <li><a href="https://www.dpmms.cam.ac.uk/~wtg10/grammar.pdf">https://www.dpmms.cam.ac.uk/~wtg10/grammar.pdf</a></li>
 *   <li><a href="http://en.wikipedia.org/wiki/Addition">http://en.wikipedia.org/wiki/Addition</a></li>
 * </ul>
 */
public class Parser {
	private final Iterator<Token> tokenIterator;
	private final List<Token> tokens = new ArrayList<Token>();
	private final Map<TokenType, PrefixParselet> prefixParseletMap = new HashMap<TokenType, PrefixParselet>();
	private final Map<TokenType, InfixParselet> infixParseletMap = new HashMap<TokenType, InfixParselet>();
	
	
	/**
	 * Constructor
	 * @param tokenIterator The {@link Iterator}<{@link Token}> for the Parser to parse 
	 */
	public Parser(Iterator<Token> tokenIterator) {
		this.tokenIterator = tokenIterator;
	}
	
	
	/**
	 * Pair the passed {@link TokenType} with the passed {@link PrefixParselet}
	 * internally within the {@link Map}<{@link TokenType},{@link InfixParselet}>
	 * @param token The {@link TokenType} to pair
	 * @param parselet The {@link PrefixParselet} to pair
	 */
	public void register(TokenType token, PrefixParselet parselet) {
		prefixParseletMap.put(token, parselet);
	}
	
	
	/**
	 * Pair the passed {@link TokenType} with the passed {@link InfixParselet}
	 * internally within the {@link Map}<{@link TokenType},{@link InfixParselet}>
	 * @param token The {@link TokenType} to pair
	 * @param parselet The {@link InfixParselet} to pair
	 */
	public void register(TokenType token, InfixParselet parselet) {
		infixParseletMap.put(token, parselet);
	}
	
	
	/**
	 * Recursive driver of this class.  Recursively consumes {@link Token}s while
	 * making determinations as to sub-{@link Expression}s (via identification of
	 * {@link PrefixParselet}s and {@link InfixParselet}s).
	 * @param precedence The integer value (as defined in {@link Precedence}) for which
	 * to apply precedence for the parser
	 * @return The {@link Expression} (resultant of any parsed sub-Expressions)
	 */
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
	
	
	/**
	 * Bootstrap {@link #parseExpression(int)} with the lowest precedence value 
	 * @return The {@link Expression} of all sub-Expressions
	 */
	public Expression parseExpression() {
		return parseExpression(0);
	}
	
	
	/**
	 * Utilize the {@link #lookAhead(int)} method in an attempt to find the
	 * passed {@link TokenType}
	 * @param expected The {@link TokenType} to match
	 * @return true if found, false if not
	 */
	public boolean match(TokenType expected) {
		Token token = lookAhead(0);
		
		if (token.getTokenType() != expected) {
			return false;
		}

		consume();
		
		return true;
	}
	
	
	/**
	 * Process an expected {@link TokenType} from the list of Tokens.  Employs the
	 * {@link #consume()} method.
	 * @param expected The expected {@link TokenType}
	 * @return The {@link Token} if it matches the passed {@link TokenType}
	 */
	public Token consume(TokenType expected) {
		Token token = lookAhead(0);
		
		if (token.getTokenType() != expected) {
			throw new RuntimeException("Expected token " + expected + " and found " + token.getTokenType());
		}

		return consume();
	}
	
	
	/**
	 * Process the current {@link Token} utilizing the {@link #lookAhead(int)} method
	 * then pop the Token from the list of Tokens
	 * @return The current {@link Token}
	 */
	public Token consume() {
		lookAhead(0);

		return tokens.remove(0);
	}
	
	
	/**
	 * Reads in the number of {@link Token}s passed to this method
	 * @param numTokens The desired number of {@link Token}s 
	 * @return The {@link Token} at position numTokens
	 */
	private Token lookAhead(int numTokens) {
		while (numTokens >= tokens.size()) {
			tokens.add(tokenIterator.next());
		}

		return tokens.get(numTokens);
	}
	
	
	/**
	 * Return the integer precedence of the current {@link InfixParselet}
	 * @return The integer precedence
	 */
	private int getPrecedence() {
		InfixParselet parser = infixParseletMap.get(lookAhead(0).getTokenType());
		int retVal = 0;
		
		if (parser != null) {
			retVal = parser.getPrecedence();
		}

		return retVal;
	}
}