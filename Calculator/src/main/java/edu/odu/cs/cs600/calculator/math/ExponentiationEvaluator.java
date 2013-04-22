package edu.odu.cs.cs600.calculator.math;

public class ExponentiationEvaluator implements IBinaryEvaluator {

	public double compute(double base, int exponent) throws ArithmeticException {
		// TODO: This is very ugly and brute-force.  Let's look into a more elegant/faster
		// determination such as was explained in class.  Do we wish to accept and
		// evaluate a real number as the exponent?
		// http://en.wikipedia.org/wiki/Exponentiation#Efficient_computation_of_integer_powers
		for (int i = 2; i < exponent; i++) {
			base = base * base;
		}
		
		return base;
	}
}