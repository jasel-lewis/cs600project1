package edu.odu.cs.cs600.calculator.math.grammar.expressions;


/**
 * An {@link Expression} to represent a number such as "3", "3874", ".9823", "0.0" and "12.873"
 * <br><br>
 * Adapted from: <a href="https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/NameExpression.java">https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/NameExpression.java</a>
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