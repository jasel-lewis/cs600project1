package edu.odu.cs.cs600.calculator.math.grammar.expressions;


/**
 * A number expression such as "3", "3874", ".9823", "0.0" and "12.873"
 * 
 * Adapted from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/NameExpression.java
 */
public class NumberExpression implements Expression {
	private final String number;
	
	
	/**
	 * Constructor
	 * @param number The {@link String} representation of a number
	 */
	public NumberExpression(String number) {
		this.number = number;
	}
	
	
	/**
	 * @return A double representation of this NumberExpression
	 */
	@Override
	public double getValue() {
		double result = Double.parseDouble(number);
		return result;
	}
}