package edu.odu.cs.cs600.calculator.math.grammar.expressions;

/**
 * A number expression such as "3", "3874", ".9823", "0.0" and "12.873"
 * 
 * Adapted from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/NameExpression.java
 */
public class NumberExpression implements Expression {
	private final String number;
	
	public NumberExpression(String number) {
		this.number = number;
	}
	
	
	
	public String getNumber() {
		return number;
	}
	
	
	
	public void print(StringBuilder builder) {
		builder.append(number);
	}
}