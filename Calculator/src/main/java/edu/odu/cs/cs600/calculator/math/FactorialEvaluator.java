package edu.odu.cs.cs600.calculator.math;

public class FactorialEvaluator implements IUnaryEvaluator {

	@Override
	public double compute(double value) throws ArithmeticException {
		// Taking it on faith here that we're receiving a double form of an
		// integer value.  Relying on NumberExpression.isInt() to determine
		// this.  Factorial may only operate on integers.
		int i = (int)value;
		
		while (i > 1) {
			value = value * i;
			i--;
		}
		
		return value;
	}
}