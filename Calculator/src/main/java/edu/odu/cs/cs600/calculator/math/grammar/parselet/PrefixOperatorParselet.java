package edu.odu.cs.cs600.calculator.math.grammar.parselet;

import edu.odu.cs.cs600.calculator.math.grammar.Expression;
import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Token;

/**
 * Single class for all of the prefix operators (which in our grammar is solely the "-" which
 * indicates negation of a number).
 * 
 * Write-up: http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/parselets/PrefixOperatorParselet.java
 */
public class PrefixOperatorParselet implements PrefixParselet {
	private final int precedence;
	
	public PrefixOperatorParselet(int precedence) {
		this.precedence = precedence;
	}
	
	
	
	public Expression parse(Parser parser, Token token) {
		// Make a call to parseExpression() to pick up the operand that appears
		// after the operator (to parse the a in "-a").  This recursion is
		// mindful of nested operators like "-+a" should we implement such
		// functionality in the future.
		Expression right = parser.parseExpression(precedence);
		
		return new PrefixExpression(token.getTokenType(), right);
	}
	
	
	
	public int getPrecedence() {
		return precedence;
	}
}