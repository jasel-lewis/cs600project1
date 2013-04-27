package edu.odu.cs.cs600.calculator.math;

public class NegationEvaluator implements IUnaryEvaluator {

	/**
	 * Perform simple negation on the passed value
	 * @param value
	 * @return
	 * @throws ArithmeticException
	 */
	public double compute(double value) throws ArithmeticException
	{
		return -value;
	}	
}