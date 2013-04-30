package edu.odu.cs.cs600.calculator.math;

/**
 * Evaluator computes the factorial of a passed value.
 */
public class FactorialEvaluator implements IUnaryEvaluator {

	/**
	 * Compute the factorial of the passed value.  Throws {@link ArithmeticException}
	 * if value is not a positive integer.
	 * @param value The value to compute the factorial of
	 * @return the factorial of the passed value
	 * @throws ArithmeticException
	 */
	public double compute(double value) throws ArithmeticException {
		
		if  (((value > 0.0) && (Double.compare(MathUtil.floor(value), value) != 0))
		  || ((value < 0.0) && (Double.compare(MathUtil.ceiling(value), value) != 0))) {
			throw new ArithmeticException("Exponent must be an integer");
		}
		
		// Our factorial may only operate on a non-negative integer.  The definition
		// of the factorial function can also be extended to non-integer arguments,
		// while retaining its most important properties; however, this involves more
		// advanced mathematics, notably techniques from mathematical analysis.
		// http://en.wikipedia.org/wiki/Factorial
		if (value < 0) {
			throw new ArithmeticException("Factorial may only operate on positive integers");
		} else if (value == 0.0) { 
			return 1;
		} else if (value == 1.0) {
			return value;
		} else {		
			//return (MathUtil.multiply(value, compute(--value)));
			return (value * compute(--value));
		}
	}
}