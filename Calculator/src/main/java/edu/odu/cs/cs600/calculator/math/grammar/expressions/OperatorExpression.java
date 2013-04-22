package edu.odu.cs.cs600.calculator.math.grammar.expressions;

import edu.odu.cs.cs600.calculator.math.DivisionEvaluator;
import edu.odu.cs.cs600.calculator.math.ExponentiationEvaluator;
import edu.odu.cs.cs600.calculator.math.MathUtil;
import edu.odu.cs.cs600.calculator.math.NegationEvaluator;
import edu.odu.cs.cs600.calculator.math.grammar.TokenType;
import edu.odu.cs.cs600.calculator.math.grammar.exceptions.ParseException;

/**
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/OperatorExpression.java
 */
public class OperatorExpression implements Expression {
	private final Expression left;
	private final Expression right;
	private final TokenType operator;
	
	public OperatorExpression(Expression left, TokenType operator, Expression right) {
		this.left = left;
		this.operator = operator;
		this.right = right;
	}
	
	
	
	@Override
	public void print(StringBuilder builder) {
		builder.append("(");
		left.print(builder);
		builder.append(" ").append(operator.getPunctuator()).append(" ");
		right.print(builder);
		builder.append(")");
	}
	
	
	
	@Override
	public double getValue() {
		switch (operator) {
			case PLUS:
				return (MathUtil.add(left.getValue(), right.getValue()));
			case MINUS:
				return (MathUtil.subtract(left.getValue(), right.getValue()));
			case MULTIPLY:
				return (MathUtil.multiply(left.getValue(), right.getValue()));
			case DIVIDE:
				return (MathUtil.divide(left.getValue(), right.getValue()));
			case POWER:
				try {
					int exponent = Integer.parseInt(Double.toString(right.getValue()));
					return (MathUtil.exponentiate(left.getValue(), exponent));
				} catch (NumberFormatException nfe) {
					throw new ParseException("Exponent must be an integer");
				}
				
			default:
				throw new ParseException("Unrecognized operator");
		}
	}
}