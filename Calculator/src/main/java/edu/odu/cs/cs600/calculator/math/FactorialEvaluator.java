package edu.odu.cs.cs600.calculator.math;

public class FactorialEvaluator implements IUnaryEvaluator {

	/**
	 * Compute the factorial of the passed value.  Throws {@link ArithmeticException}
	 * if value is not a positive integer.
	 * @param value
	 * @return
	 * @throws ArithmeticException
	 */
	public int compute(int value) throws ArithmeticException {
		
		// Our factorial may only operate on a non-negative integer.  The definition
		// of the factorial function can also be extended to non-integer arguments,
		// while retaining its most important properties; however, this involves more
		// advanced mathematics, notably techniques from mathematical analysis.
		// http://en.wikipedia.org/wiki/Factorial
		if (value < 0) {
			throw new ArithmeticException("Factorial may only operate on positive integers");
		} else if (value == 0) { 
			return 1;
		} else if (value == 1) {
			return value;
		} else {		
			return (value * compute(--value));
		}
	}
}