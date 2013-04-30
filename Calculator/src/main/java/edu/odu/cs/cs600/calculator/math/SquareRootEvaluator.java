package edu.odu.cs.cs600.calculator.math;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Evaluator is used to compute the Square Root of an input value.  Result is an approximation of the 
 * square root.  The algorithm is implemented based on Netwon's Approximation Method for finding 
 * roots (utilized both for the division aspects and for the approximation of the ultimate square value).
 */
public class SquareRootEvaluator implements IUnaryEvaluator 
{
	private static Logger logger = LogManager.getLogger(SquareRootEvaluator.class);
	private static final double EPSILON = 0.0000000000001;
	
	/**
	 * Approximates the square root of a given input.
	 * 
	 * @param  value An input value to compute the square root of
	 * @return the square root of the input value
	 * @throws ArithmeticException
	 * @see SquareRootEvaluator
	 */
	public double compute(double value) throws ArithmeticException
	{
		if(value < 0)
			throw new ArithmeticException("Unable to compute the square root negative values.");
		
		int i = 0;
		double x = 1.0;
		double xPrev;
		
		do
		{
			i=i+1;
			xPrev = x;
			x= MathUtil.multiply(0.5, MathUtil.add(x, MathUtil.divide(value, x)));
			logger.debug("Square Root: Iteration=" + i + " xi=" + x + " xi-1=" + xPrev);
		} while(MathUtil.abs(MathUtil.subtract(xPrev, x)) >= EPSILON);
		
		return x;
	}
}