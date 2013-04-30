package edu.odu.cs.cs600.calculator.math.grammar.parselet;

import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Token;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.Expression;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.OperatorExpression;

/**
 * Class to support an infix parselet for binary operators (+, -, *, /, ^).
 * The only difference when parsing the bianry operators is precedence and
 * associativity.  This allows us to use a single parselet class.
 * 
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/parselets/BinaryOperatorParselet.java
 * Write-up: http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/
 */
public class BinaryOperatorParselet implements InfixParselet {
	private final int precedence;
	private final boolean isRightAssociative;
	
	
	/**
	 * Constructor
	 * @param precedence The integer precedence value attributed to this BinaryOperatorParselet
	 * @param isRightAssociative true if this BinaryOperatorParselt should be considered as right-associative
	 */
	public BinaryOperatorParselet(int precedence, boolean isRightAssociative) {
		this.precedence = precedence;
		this.isRightAssociative = isRightAssociative;
	}
	
	
	/**
	 * Create a new {@link OperatorExpression} from the passed left-side {@link Expression},
	 * passed (operator) {@link Token} and right-side {@link Expression} as determined from
	 * the passed {@link Parser}.
	 * @return The resultant {@link Expression}
	 */
	public Expression parse(Parser parser, Expression left, Token token) {
		// To be right-associative (for the "^" operator), the call to
		// parseExpression() should take one _less_than_ the precedence.  This
		// will let a parselet with the same precedence appear on the right, which
		// will then take _this_ parselet's result as its left-hand argument.
		int detraction = 0;
		
		if (isRightAssociative) {
			detraction = 1;
		}
		
		Expression right = parser.parseExpression(precedence - detraction);
		
		return new OperatorExpression(left, token.getTokenType(), right);
	}

	
	/**
	 * @return The precedence attributed to this BinaryOperatorParselet
	 */
	@Override
	public int getPrecedence() {
		return precedence;
	}
}