package edu.odu.cs.cs600.calculator.math;

/**
 * Evaluator performs simple addition of two passed values.
 */
public class AdditionEvaluator implements IBinaryEvaluator {

	/**
	 * Perform simple addition of the passed terms
	 * @param x first term
	 * @param y second term
	 * @return the sum of the two passed terms
	 * @throws ArithmeticException
	 */
	public double compute(double x, double y) throws ArithmeticException {
		return x + y;
	}
}