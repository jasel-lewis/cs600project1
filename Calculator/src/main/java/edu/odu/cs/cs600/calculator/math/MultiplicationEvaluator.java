package edu.odu.cs.cs600.calculator.math;

/**
 * Evaluator performs the basic multiplication of two values
 */
public class MultiplicationEvaluator implements IBinaryEvaluator {

	/**
	 * Perform simple multiplication on the passed factors
	 * @param x first factor
	 * @param y second factor
	 * @return The product of the two passed values
	 * @throws ArithmeticException
	 */
	public double compute(double x, double y) throws ArithmeticException {
		return x * y;
	}
}