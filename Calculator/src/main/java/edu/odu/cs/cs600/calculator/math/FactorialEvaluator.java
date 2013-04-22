package edu.odu.cs.cs600.calculator.math;

public class FactorialEvaluator implements IUnaryEvaluator {

	@Override
	public double compute(double value) throws ArithmeticException {
		// This method really needs to accept an int and return an int.
		// Factorial may only operate on integers.
		try {
			int i = Integer.parseInt(Double.toString(value));
			
			if (i < 0) {
				throw new ArithmeticException("Factor may only operate on positive integers");
			}
			
			while (i > 1) {
				value = value * i;
				i--;
			}
			
			return value;
		} catch (NumberFormatException nfe) {
			throw new ArithmeticException("Factorial may only operate on integers");
		}
	}
}