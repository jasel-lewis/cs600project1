package edu.odu.cs.cs600.calculator.math;

/**
 * Evaluator computes the difference of two values.  See {@link #compute(double, double)}
 * for implementation details
 */
public class SubtractionEvaluator implements IBinaryEvaluator {

	/**
	 * Calculate the result of the first term reduced by the second.  This method
	 * employs {@link MathUtil#negate(double)} add the negation of the second
	 * term to the first term.
	 * @param x first term
	 * @param y second term
	 * @return The difference of the first and second term (x-y)
	 * @throws ArithmeticException
	 */
	public double compute(double x, double y) throws ArithmeticException 
	{
		return x + MathUtil.negate(y);
	}
}