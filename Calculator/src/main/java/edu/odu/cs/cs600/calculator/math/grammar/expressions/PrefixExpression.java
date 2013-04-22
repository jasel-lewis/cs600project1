package edu.odu.cs.cs600.calculator.math.grammar.expressions;

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
	private final TokenType operator;
	private final Expression right;
	
	
	public PrefixExpression(TokenType operator, Expression right) {
		this.operator = operator;
		this.right = right;
	}
	
	
	
	@Override
	public void print(StringBuilder builder) {
		builder.append("(").append(operator.getPunctuator());
		right.print(builder);
		builder.append(")");
	}
	
	
	
	@Override
	public double getValue() {
		switch(operator) {
			case PLUS:
				// A unary plus prior to the expression
				return (right.getValue());
			case MINUS:
				// A unary minus prior to the expression
				return (MathUtil.negate(right.getValue()));
			default:
				throw new ParseException("Unrecognized prefix operation");
		}
	}
}