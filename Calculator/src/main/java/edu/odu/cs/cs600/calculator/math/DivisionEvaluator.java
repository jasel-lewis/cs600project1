package edu.odu.cs.cs600.calculator.math;

/**
 * Provides the implementation for the division on the numerator by the denominator 
 * by multiplying the numerator by the reciprocal of the denominator (accomplished using
 * {@link MathUtil#reciprocate(double)})
 */
public class DivisionEvaluator implements IBinaryEvaluator {

	/**
	 * Divides a numerator by a divisor.  See {@link DivisionEvaluator} for details
	 * regarding this Evaluator's implementation.
	 * @param numerator
	 * @param divisor
	 * @return the dividend of the division operation
	 * @throws ArithmeticException
	 */
	public double compute(double numerator, double divisor) throws ArithmeticException 
	{
		return numerator * MathUtil.reciprocate(divisor);
	}

}
