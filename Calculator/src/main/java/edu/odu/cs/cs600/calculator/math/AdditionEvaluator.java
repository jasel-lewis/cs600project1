package edu.odu.cs.cs600.calculator.math;

public class AdditionEvaluator implements IBinaryEvaluator {

	/**
	 * Perform simple addition of the passed terms
	 * @param x first term
	 * @param y second term
	 * @return
	 * @throws ArithmeticException
	 */
	public double compute(double x, double y) throws ArithmeticException {
		return x + y;
	}
}