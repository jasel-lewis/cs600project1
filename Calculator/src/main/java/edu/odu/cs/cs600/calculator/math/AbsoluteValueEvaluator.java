package edu.odu.cs.cs600.calculator.math;

public class AbsoluteValueEvaluator implements IUnaryEvaluator
{
	/**
	 * Calculate the absolute value of the passed value
	 * @param value
	 * @return
	 * @throws ArithmeticException
	 */
	public double compute(double value) throws ArithmeticException 
	{
		if(value < 0)
			return MathUtil.negate(value);
		else
			return value;
	}

}
