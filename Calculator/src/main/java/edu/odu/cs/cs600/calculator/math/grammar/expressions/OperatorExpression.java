package edu.odu.cs.cs600.calculator.math.grammar.expressions;

import edu.odu.cs.cs600.calculator.math.grammar.TokenType;

/**
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/OperatorExpression.java
 */
public class OperatorExpression implements Expression {
	private final Expression left;
	private final Expression right;
	private final TokenType operator;
	
	private double value = 0.0;
	
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
	public void evaluate() {
		switch (operator) {
			case PLUS:
				value = left.getValue() + right.getValue();
			case MINUS:
				value = left.getValue() - right.getValue();
			case MULTIPLY:
				value = left.getValue() * right.getValue();
			case DIVIDE:
				value = left.getValue() / right.getValue();
			case POWER:
				value = Math.pow(left.getValue(), right.getValue());
			default:
				;
		}
	}



	@Override
	public double getValue() {
		return value;
	}
}