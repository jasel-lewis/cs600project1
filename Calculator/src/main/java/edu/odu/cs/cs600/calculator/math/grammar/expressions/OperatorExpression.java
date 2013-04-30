package edu.odu.cs.cs600.calculator.math.grammar.expressions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.odu.cs.cs600.calculator.math.MathUtil;
import edu.odu.cs.cs600.calculator.math.grammar.TokenType;
import edu.odu.cs.cs600.calculator.math.grammar.exceptions.ParseException;

/**
 * Class to represent an OperatorExpression
 * 
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/OperatorExpression.java
 */
public class OperatorExpression implements Expression {
	private static Logger logger = LogManager.getLogger(OperatorExpression.class);
	private final Expression left;
	private final Expression right;
	private final TokenType operator;
	
	
	/**
	 * Constructor
	 * @param left The left-side {@link Expression}
	 * @param operator The {@link TokenType} of the operation to perform on the left and right expression
	 * @param right The right-side {@link Expression}
	 */
	public OperatorExpression(Expression left, TokenType operator, Expression right) {
		this.left = left;
		this.operator = operator;
		this.right = right;
	}
	
	
	/**
	 * @return Returns the left-side {@link Expression} operated on by the right {@link Expression}
	 * evaluated as a double value
	 */
	@Override
	public double getValue() {
		double leftValue = left.getValue();
		double rightValue = right.getValue();
		double result;
		
		switch (operator) {
			case PLUS:
				result = MathUtil.add(leftValue, rightValue); 
				logger.debug("Evaluating " + leftValue + " + " + rightValue + " and getting: " + result);
				return result;
			case MINUS:
				result = MathUtil.subtract(leftValue, rightValue); 
				logger.debug("Evaluating " + leftValue + " - " + rightValue + " and getting: " + result);
				return result;
			case MULTIPLY:
				result = MathUtil.multiply(leftValue, rightValue); 
				logger.debug("Evaluating " + leftValue + " * " + rightValue + " and getting: " + result);
				return result;
			case DIVIDE:
				result = MathUtil.divide(leftValue, rightValue); 
				logger.debug("Evaluating " + leftValue + " / " + rightValue + " and getting: " + result);
				return result;
			case POWER:
				result = MathUtil.exponentiate(leftValue, rightValue); 
				logger.debug("Evaluating " + leftValue + " ^ " + rightValue + " and getting: " + result);
				return result;
			default:
				throw new ParseException("Unrecognized operator");
		}
	}
}