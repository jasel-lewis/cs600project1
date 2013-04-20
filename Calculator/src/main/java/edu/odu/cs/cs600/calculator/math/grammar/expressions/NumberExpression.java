package edu.odu.cs.cs600.calculator.math.grammar.expressions;

/**
 * A number expression such as "3", "3874", ".9823", "0.0" and "12.873"
 * 
 * Adapted from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/NameExpression.java
 */
public class NumberExpression implements Expression {
	private final String number;
	private final double value;
	
	public NumberExpression(String number) {
		this.number = number;
		this.value = Double.parseDouble(number);
	}
	
	
	
	@Override
	public void print(StringBuilder builder) {
		builder.append(number);
	}
	
	
	
	@Override
	public double getValue() {
		return value;
	}
	
	
	
	@Override
	public void evaluate() {
		// Do nothing - value is set by the constructor
		;
	}
}