package edu.odu.cs.cs600.calculator.math.grammar.expressions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.odu.cs.cs600.calculator.math.MathUtil;
import edu.odu.cs.cs600.calculator.math.grammar.TokenType;
import edu.odu.cs.cs600.calculator.math.grammar.exceptions.ParseException;

/**
 * A postfix unary arithmetic expression such as "!"
 * 
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/PrefixExpression.java
 */
// TODO: This entire postfix implementation may be removed if we succinctly decide
// that factorial is only executed on button-press (Phrase evaluated then factorial
// applied) as opposed to being evaluated as somewhere internal to the Phrase.
public class PostfixExpression implements Expression {
	private static Logger logger = LogManager.getLogger(PostfixExpression.class);
	private final TokenType operator;
	private final Expression left;
	
	
	public PostfixExpression(Expression left, TokenType operator) {
		this.operator = operator;
		this.left = left;
	}
	
	
	
	@Override
	public double getValue() {
		double leftValue = left.getValue();
		double result;
		
		switch(operator) {
			case FACTORIAL:
				try {
					int base = Integer.parseInt(Double.toString((int)leftValue));
					result = MathUtil.factorial(base);
					logger.debug("Evaluating " + base + "! and getting: " + result);
					return result;
				} catch (NumberFormatException nfe) {
					throw new ParseException("Factorial applied to non-integer");
				}
			default:
				throw new ParseException("Unrecognized PostFix operation");
		}
	}
}