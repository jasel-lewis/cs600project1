package edu.odu.cs.cs600.calculator.math.grammar.expressions;

import edu.odu.cs.cs600.calculator.math.FactorialEvaluator;
import edu.odu.cs.cs600.calculator.math.grammar.TokenType;
import edu.odu.cs.cs600.calculator.math.grammar.exceptions.ParseException;

/**
 * A postfix unary arithmetic expression such as "!"
 * 
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/PrefixExpression.java
 */
public class PostfixExpression implements Expression {
	private final TokenType operator;
	private final Expression left;
	
	
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
		switch(operator) {
			case FACTORIAL:
				// TODO: Should this be a method call to MathUtil.factorial() (creating that method, of course)
				FactorialEvaluator fe = new FactorialEvaluator();
				return fe.compute((int)left.getValue());
			default:
				throw new ParseException("Unrecognized PostFix operation");
		}
	}
}