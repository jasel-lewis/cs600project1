package edu.odu.cs.cs600.calculator.math.grammar.parselet;

import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Token;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.Expression;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.PostfixExpression;

/**
 * Generic infix parselet for an unary arithmetic operator. Parses postfix unary expressions
 * 
 * Write-up: http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/parselets/PrefixOperatorParselet.java
 */
public class PostfixOperatorParselet implements InfixParselet {
	private final int precedence;
	
	public PostfixOperatorParselet(int precedence) {
		this.precedence = precedence;
	}
	
	
	
	public Expression parse(Parser parser, Expression left, Token token) {
		// Make a call to parseExpression() to pick up the operand that appears
		// after the operator (to parse the a in "-a").  This recursion is
		// mindful of nested operators like "-+a" should we implement such
		// functionality in the future.
		return new PostfixExpression(left, token.getTokenType());
	}
	
	
	
	public int getPrecedence() {
		return precedence;
	}
}