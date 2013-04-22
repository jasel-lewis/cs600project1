package edu.odu.cs.cs600.calculator.math;

public class ExponentiationEvaluator implements IBinaryEvaluator {

	public double compute(double base, double exponent) throws ArithmeticException {
		// TODO: This is very ugly and brute-force.  Let's look into a more elegant/faster
		// determination such as was explained in class.
		// Also look at:
		// http://en.wikipedia.org/wiki/Exponentiation#Efficient_computation_of_integer_powers
		
		// We're only going to accept the common notion that the exponent must
		// be an integer.
		if (MathUtil.floor(exponent) != exponent) {
			throw new ArithmeticException("Exponent must be an integer");
		}
		
		for (int i = 2; i < (int)exponent; i++) {
			base = base * base;
		}
		
		return base;
	}
}