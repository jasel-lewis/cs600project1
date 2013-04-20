package edu.odu.cs.cs600.calculator.math.grammar.expressions;

import edu.odu.cs.cs600.calculator.math.grammar.TokenType;

/**
 * A postfix unary arithmetic expression such as "!"
 * 
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/PrefixExpression.java
 */
public class PostfixExpression implements Expression {
	private final TokenType operator;
	private final Expression left;
	
	private double value = 0.0;
	
	public PostfixExpression(Expression left, TokenType operator) {
		this.operator = operator;
		this.left = left;
	}
	
	
	
	@Override
	public void print(StringBuilder builder) {
		builder.append("(");
		left.print(builder);
		builder.append(operator.getPunctuator()).append(")");
	}
	
	
	
	@Override
	public double getValue() {
		return value;
	}
	
	
	
	@Override
	public void evaluate() {
		switch(operator) {
			case FACTORIAL:
				int i = (int)left.getValue();
				
				value = i;
				
				while (i > 1) {
					value = value * i;
					i--;
				}
			default:
				;
		}
	}
}