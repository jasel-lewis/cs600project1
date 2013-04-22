package edu.odu.cs.cs600.calculator.math.grammar.expressions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.odu.cs.cs600.calculator.math.MathUtil;
import edu.odu.cs.cs600.calculator.math.grammar.TokenType;
import edu.odu.cs.cs600.calculator.math.grammar.exceptions.ParseException;

/**
 * Prefix unary expression.  For our calculator, the only legal prefix
 * is "-".
 * 
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/PrefixExpression.java
 */
public class PrefixExpression implements Expression {
	private static Logger logger = LogManager.getLogger(PrefixExpression.class);
	private final TokenType operator;
	private final Expression right;
	
	
	public PrefixExpression(TokenType operator, Expression right) {
		this.operator = operator;
		this.right = right;
	}
	
	
	
	@Override
	public double getValue() {
		double rightValue = right.getValue();
		double result;
		
		switch(operator) {
			case PLUS:
				// A unary plus prior to the expression
				result = right.getValue();
				logger.debug("Evaluating unary '+" + rightValue + "' and getting: " + result);
				return result;
			case MINUS:
				// A unary minus prior to the expression
				result = MathUtil.negate(right.getValue());
				logger.debug("Evaluating unary '-" + rightValue + "' and getting: " + result);
				return result;
			default:
				throw new ParseException("Unrecognized prefix operation");
		}
	}
}