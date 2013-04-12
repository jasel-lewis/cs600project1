package edu.odu.cs.cs600.calculator.math;

public class SquareRootEvaluator implements IUnaryEvaluator 
{
	
	private static final double EPSILON = 0.0000000000001;
	
	public double compute(double value) throws ArithmeticException
	{
		System.err.println("Function utilized that has not yet been completed.  Currently using improper implementation.  Need to replace / with division function");
		
		if(value < 0)
			throw new ArithmeticException("Unable to compute the square root negative values.");
		
		int i = 0;
		double x = 1.0;
		double xPrev;
		
		do
		{
			i=i+1;
			xPrev = x;
			//x = 0.5 * ( x + MathUtil.divide(value, x) );
			x = 0.5 * ( x + value/x );
			System.out.println("Square Root: Iteration=" + i + " xi=" + x + " xi-1=" + xPrev);
		} while(MathUtil.abs(xPrev-x) >= EPSILON);
		
		return x;
	}
}
