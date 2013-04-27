package edu.odu.cs.cs600.calculator.math;

public class SubtractionEvaluator implements IBinaryEvaluator {

	/**
	 * Calculate the result of the first term reduced by the second.  This method
	 * employs {@link MathUtil#negate(double)} add the negation of the second
	 * term to the first term.
	 * @param x first term
	 * @param y second term
	 * @return
	 * @throws ArithmeticException
	 */
	public double compute(double x, double y) throws ArithmeticException 
	{
		return x + MathUtil.negate(y);
	}
}