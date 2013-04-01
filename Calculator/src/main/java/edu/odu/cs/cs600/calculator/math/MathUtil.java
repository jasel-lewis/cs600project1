package edu.odu.cs.cs600.calculator.math;

public class MathUtil 
{
	public static double evaluate(String expression)
	{
		return ExpressionEvaluator.evaluate(expression);
	}
	
	public static double ceiling(double value)
	{
		return CeilingEvaluator.compute(value);
	}
	
	public static double floor(double value)
	{
		return FloorEvaluator.compute(value);
	}
	
	public static double negate(double value)
	{
		return NegationEvaluator.compute(value);
	}
	
	public static double reciprocal(double value)
	{
		return ReciprocalEvaluator.compute(value);
	}
	
	public static double squareRoot(double value)
	{
		return SquareRootEvaluator.compute(value);
	}
}
