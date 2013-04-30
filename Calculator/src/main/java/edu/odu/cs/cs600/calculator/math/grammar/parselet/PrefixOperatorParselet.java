package edu.odu.cs.cs600.calculator.math.grammar.parselet;

import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Token;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.Expression;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.OperatorExpression;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.PrefixExpression;

/**
 * Single class for all prefix operators (which according to the grammar for
 * this project are solely the "+" and "-" unary operators).
 * 
 * Write-up: http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/parselets/PrefixOperatorParselet.java
 */
public class PrefixOperatorParselet implements PrefixParselet {
	private final int precedence;
	
	
	/**
	 * Constructor
	 * @param precedence The integer precedence value to assign to this PrefixOperatorParselet
	 */
	public PrefixOperatorParselet(int precedence) {
		this.precedence = precedence;
	}
	
	
	/**
	 * Create a new {@link PrefixExpression} from the passed (operator) {@link Token}
	 * and right-side {@link Expression} as determined from the passed {@link Parser}.
	 * @return The resultant {@link Expression}
	 */
	public Expression parse(Parser parser, Token token) {
		// Make a call to parseExpression() to pick up the operand that appears
		// after the operator (to parse the a in "-a").  This recursion is
		// mindful of nested operators such as "-+a".
		Expression right = parser.parseExpression(precedence);
		
		return new PrefixExpression(token.getTokenType(), right);
	}
	
	
	/**
	 * @return The integer precedence attributed to this PrefixOperatorParselet
	 */
	public int getPrecedence() {
		return precedence;
	}
}