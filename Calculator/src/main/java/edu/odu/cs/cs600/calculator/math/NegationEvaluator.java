package edu.odu.cs.cs600.calculator.math;

/**
 * Evaluator negates a passed value.
 */
public class NegationEvaluator implements IUnaryEvaluator {

	/**
	 * Perform simple negation on the passed value
	 * @param value The value to negate
	 * @return The negated value
	 * @throws ArithmeticException
	 */
	public double compute(double value) throws ArithmeticException
	{
		return -value;
	}	
}