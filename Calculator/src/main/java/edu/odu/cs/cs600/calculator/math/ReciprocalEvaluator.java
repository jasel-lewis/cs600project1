package edu.odu.cs.cs600.calculator.math;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Computes the reciprocal of a given value.  See {@link #compute(double)}
 * for details regarding the implementation
 */
public class ReciprocalEvaluator implements IUnaryEvaluator 
{
	private static Logger logger = LogManager.getLogger(ReciprocalEvaluator.class);
	private static final double EPSILON = 1e-12;
	
	/**
	 * Computes the reciprocal of the input value provided.  This method uses
	 * Newton's Method to solve f(x) = (1/x) - a = 0 for x gives x = 1/a.  The
	 * algorithm implemented works natively on the input range (0,1), however,
	 * numerical values outside of this range are "scaled" by shifting the
	 * decimal point before computation, and then after.
	 * @param x The value to compute the reciprocal of
	 * @return The reciprocal of the passed value (1/x)
	 * @throws ArithmeticException
	 */
	public double compute(double x) throws ArithmeticException
	{
		logger.debug("Computing 1/x where x = " + x);
		
		if(x == 0)
			throw new ArithmeticException("divide by zero");
		else if (x == 1)
			return 1;
		
		// If the value is negative, then first flip to positive, then revert in the end
		boolean isNegative = (x < 0);
		if(isNegative) x = MathUtil.multiply(x, MathUtil.negate(1));
		
		// If the value is greater than 1, then normalize by shifting the decimal
		// place until the value is in the range of (0,1)
		int factor = 0;
		
		if(x > 1)
		{
			while(x > 1)
			{
				factor++;
				x = MathUtil.multiply(x, 0.1);
			}
		}
		else if(x < 0.1)
		{
			while(x < 0.1)
			{
				factor--;
				x = MathUtil.multiply(x, 10);
			}
		}
		
		double xi = 1;
		double yi = MathUtil.subtract(1, x);
		double xPrev;
		double yPrev;
		double tolerance = MathUtil.multiply(MathUtil.multiply(EPSILON, x), x);
		
		do
		{
			xPrev = xi;
			yPrev = yi;	
			xi = MathUtil.multiply(xPrev, MathUtil.add(yPrev, 1));
			yi = MathUtil.multiply(yPrev, yPrev);
		} 
		while(MathUtil.abs(MathUtil.subtract(yPrev, yi)) >= tolerance);
		x = xi;
		
		if(factor > 0)
		{
			while (factor > 0)
			{
				x = MathUtil.multiply(x, 0.1);
				factor--;
			}
		}
		else if (factor < 1)
		{
			while (factor < 0)
			{
				x = MathUtil.multiply(x, 10);
				factor++;
			}
		}
		
		if(isNegative) x = MathUtil.multiply(x, MathUtil.negate(1));
		
		logger.debug("Computed the reciprocal of x (1/x)="+x);
		
		return x;
	}	
}
