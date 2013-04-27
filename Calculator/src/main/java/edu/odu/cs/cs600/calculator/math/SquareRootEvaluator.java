package edu.odu.cs.cs600.calculator.math;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SquareRootEvaluator implements IUnaryEvaluator 
{
	private static Logger logger = LogManager.getLogger(SquareRootEvaluator.class);
	private static final double EPSILON = 0.0000000000001;
	
	// TODO: Jared explain this implementation in the Javadoc comments below
	/**
	 * 
	 * @param value
	 * @return
	 * @throws ArithmeticException
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
			x= 0.5 * ( x + MathUtil.divide(value, x) );
			logger.debug("Square Root: Iteration=" + i + " xi=" + x + " xi-1=" + xPrev);
		} while(MathUtil.abs(xPrev-x) >= EPSILON);
		
		return x;
	}
}
