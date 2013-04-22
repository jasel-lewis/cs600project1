package edu.odu.cs.cs600.calculator.math.grammar.expressions;

import edu.odu.cs.cs600.calculator.math.DivisionEvaluator;
import edu.odu.cs.cs600.calculator.math.ExponentiationEvaluator;
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
				// TODO: The next line is OK to use because we can accept simple addition as a given, correct?
				return (left.getValue() + right.getValue());
			case MINUS:
				// TODO: Should this be a simple addition to the return of a method call to MathUtil.negate()?
				// i.e.: return (left.getValue() + MathUtil.negate(right.getValue()));
				NegationEvaluator ne = new NegationEvaluator();
				return (left.getValue() + ne.compute(right.getValue()));
				//return (left.getValue() - right.getValue());
			case MULTIPLY:
				// TODO: The next line is OK to use because we can accept simple multiplication as a given, correct?
				return (left.getValue() * right.getValue());
			case DIVIDE:
				// TODO: Should this be a simple method call to MathUtil.divide()?
				// i.e.: return (MathUtil.divide(left.getValue(), right.getValue()));
				DivisionEvaluator de = new DivisionEvaluator();
				return (de.compute(left.getValue(), right.getValue()));
				//return (left.getValue() / right.getValue());
			case POWER:
				// TODO: Should this be a method call to MathUtil.exponentiation()? (With the appropriate method created, of course)
				ExponentiationEvaluator ee = new ExponentiationEvaluator();
				return (ee.compute(left.getValue(), right.getValue()));
			default:
				throw new ParseException("Unrecognized operator");
		}
	}
}