package edu.odu.cs.cs600.calculator.math;

/**
 * Evaluator determines the absolute value of a passed value.  Uses trivial logic to
 * determine if the passed value is less than 0, and if so, returns the passed value negated.
 * Otherwise, the passed value is return unchanged.
 */
public class AbsoluteValueEvaluator implements IUnaryEvaluator
{
	/**
	 * Calculate the absolute value of the passed value
	 * @param value The value to calculate the absolute value of
	 * @return The absolute value of the passed value
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
