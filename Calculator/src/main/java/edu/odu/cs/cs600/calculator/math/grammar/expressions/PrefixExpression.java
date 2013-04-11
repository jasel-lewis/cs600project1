package edu.odu.cs.cs600.calculator.math.grammar.expressions;

import edu.odu.cs.cs600.calculator.math.grammar.TokenType;

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
	
	
	
	public void print(StringBuilder builder) {
		builder.append("(").append(operator.punctuator());
		right.print(builder);
		builder.append(")");
	}
}