package edu.odu.cs.cs600.calculator.math;

public class MultiplicationEvaluator implements IBinaryEvaluator {

	/**
	 * Perform simple multiplication on the passed factors
	 * @param x first factor
	 * @param y second factor
	 * @return
	 * @throws ArithmeticException
	 */
	public double compute(double x, double y) throws ArithmeticException {
		return x * y;
	}
}