package edu.odu.cs.cs600.calculator.math.parser;

public class Parser 
{
	// Kept private to prevent instantiation of this object, the evaluate() method is all you'll need,
	// and this utility class should remain stateless.
	private Parser() {};
	
	public static double evaluate(String expression)
	{
		// TODO : Replace the contents of this method w/ the logic to actually evaluate the expression
		return Double.valueOf(expression);
	}
}
