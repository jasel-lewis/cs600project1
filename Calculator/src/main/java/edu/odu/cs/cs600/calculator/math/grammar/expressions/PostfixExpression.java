package edu.odu.cs.cs600.calculator.math.grammar.expressions;

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
				try {
					int base = Integer.parseInt(Double.toString((int)left.getValue()));
					return MathUtil.factorial(base);
				} catch (NumberFormatException nfe) {
					throw new ParseException("Factorial applied to non-integer");
				}
			default:
				throw new ParseException("Unrecognized PostFix operation");
		}
	}
}