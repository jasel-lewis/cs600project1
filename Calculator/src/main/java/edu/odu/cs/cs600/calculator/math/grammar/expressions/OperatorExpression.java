package edu.odu.cs.cs600.calculator.math.grammar.expressions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.odu.cs.cs600.calculator.math.MathUtil;
import edu.odu.cs.cs600.calculator.math.grammar.TokenType;
import edu.odu.cs.cs600.calculator.math.grammar.exceptions.ParseException;

/**
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/OperatorExpression.java
 */
public class OperatorExpression implements Expression {
	private static Logger logger = LogManager.getLogger(OperatorExpression.class);
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
		double leftValue = left.getValue();
		double rightValue = right.getValue();
		double result;
		
		switch (operator) {
			case PLUS:
				result = MathUtil.add(leftValue, rightValue); 
				logger.debug("Parser evaluating " + leftValue + " + " + rightValue + " and getting: " + result);
				return result;
			case MINUS:
				result = MathUtil.subtract(leftValue, rightValue); 
				logger.debug("Parser evaluating " + leftValue + " - " + rightValue + " and getting: " + result);
				return result;
			case MULTIPLY:
				result = MathUtil.multiply(leftValue, rightValue); 
				logger.debug("Parser evaluating " + leftValue + " * " + rightValue + " and getting: " + result);
				return result;
			case DIVIDE:
				result = MathUtil.divide(leftValue, rightValue); 
				logger.debug("Parser evaluating " + leftValue + " / " + rightValue + " and getting: " + result);
				return result;
			case POWER:
				try {
					int exponent = Integer.parseInt(Double.toString(rightValue));
					result = MathUtil.exponentiate(leftValue, exponent); 
					logger.debug("Parser evaluating " + leftValue + " ^ " + exponent + " and getting: " + result);
					return result;
				} catch (NumberFormatException nfe) {
					throw new ParseException("Exponent must be an integer");
				}
				
			default:
				throw new ParseException("Unrecognized operator");
		}
	}
}