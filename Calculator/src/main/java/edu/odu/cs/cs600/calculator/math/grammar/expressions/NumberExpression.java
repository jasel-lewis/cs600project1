package edu.odu.cs.cs600.calculator.math.grammar.expressions;

/**
 * A number expression such as "3", "3874", ".9823", "0.0" and "12.873"
 * 
 * Adapted from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/NameExpression.java
 */
public class NumberExpression implements Expression {
	private final String number;
	private boolean integer = false;
	
	public NumberExpression(String number) {
		this.number = number;
	}
	
	
	
	@Override
	public void print(StringBuilder builder) {
		builder.append(number);
	}
	
	
	
	@Override
	public double getValue() {
		try {
			Integer.parseInt(number);
			integer = true;
		} catch (NumberFormatException ne) {
			;  // Do nothing
		}
		return Double.parseDouble(number);
	}
	
	
	
	/**
	 * This method supports the requirement of the factorial operation as a
	 * factorial operates only on integer values
	 * @return
	 */
	public boolean isInt() {
		return integer;
	}
}