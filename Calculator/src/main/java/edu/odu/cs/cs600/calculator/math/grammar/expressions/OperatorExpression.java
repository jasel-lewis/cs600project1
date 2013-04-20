package edu.odu.cs.cs600.calculator.math.grammar.expressions;

import edu.odu.cs.cs600.calculator.math.grammar.TokenType;

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
				return (left.getValue() + right.getValue());
			case MINUS:
				return (left.getValue() - right.getValue());
			case MULTIPLY:
				return (left.getValue() * right.getValue());
			case DIVIDE:
				return (left.getValue() / right.getValue());
			case POWER:
				return (Math.pow(left.getValue(), right.getValue()));
			default:
				return 0.0;
		}
	}
}