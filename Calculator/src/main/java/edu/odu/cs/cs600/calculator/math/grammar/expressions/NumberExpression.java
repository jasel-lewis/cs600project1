package edu.odu.cs.cs600.calculator.math.grammar.expressions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * A number expression such as "3", "3874", ".9823", "0.0" and "12.873"
 * 
 * Adapted from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/NameExpression.java
 */
public class NumberExpression implements Expression {
	private static Logger logger = LogManager.getLogger(NumberExpression.class);
	private final String number;
	
	public NumberExpression(String number) {
		this.number = number;
	}
	
	
	
	@Override
	public double getValue() {
		double result = Double.parseDouble(number);
		logger.debug("NumberExpression is returning its value as: " + result);
		return result;
	}
}