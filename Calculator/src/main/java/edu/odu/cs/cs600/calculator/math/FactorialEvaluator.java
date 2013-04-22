package edu.odu.cs.cs600.calculator.math;

public class FactorialEvaluator implements IUnaryEvaluator {

	@Override
	public double compute(double value) throws ArithmeticException {
		// TODO: Need to make sure that we only accept an integer before a factorial in the Phrase.
		// Not because of the below line (of which we'd get rounding errors) - but because factorial
		// only operates on whole numbers.
		int i = (int)value;
		
		while (i > 1) {
			value = value * i;
			i--;
		}
		
		return value;
	}
}