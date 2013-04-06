package edu.odu.cs.cs600.calculator.math;

public class ReciprocalEvaluator implements IUnaryEvaluator 
{
	private static final double EPSILON = 0.0000000001;
	
	public double compute(double value) throws Exception
	{
		if(value == 0)
			throw new Exception("Cannot divide by 0");
		
		if(value > 1)
			throw new Exception("ReciprocalEvaluator only supports values in the range (0,1). Need to scale algorithm to support all values");
		
		int i = 0;
		double x = 1;
		double y = MathUtil.subtract(1, value);
		double tolerance = EPSILON * value * value;
		double yPrev;
		
		do
		{
			yPrev = y;
			i = i + 1;
			x = x * (1+y);
			y = y*y;
		} while (MathUtil.abs(yPrev - y) >= tolerance);
		
		System.err.println("Function utilized that has not yet been completed.  Half implemented and only works for values where (0 < x < 1).");
		
		return x;
	}
	
}
