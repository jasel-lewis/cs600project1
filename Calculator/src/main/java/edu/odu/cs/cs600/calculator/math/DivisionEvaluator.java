package edu.odu.cs.cs600.calculator.math;

public class DivisionEvaluator implements IBinaryEvaluator {

	/**
	 * Performs division on the numerator by the denominator by multiplying the
	 * numerator by the reciprocal of the denominator (accomplished using
	 * {@link MathUtil#reciprocate(double)})
	 * @param numerator
	 * @param divisor
	 * @return
	 * @throws ArithmeticException
	 */
	public double compute(double numerator, double divisor) throws ArithmeticException 
	{
		return numerator * MathUtil.reciprocate(divisor);
	}

}
