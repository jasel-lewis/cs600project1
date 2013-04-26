package edu.odu.cs.cs600.calculator.math;

public class FactorialEvaluator implements IUnaryEvaluator {

	public int compute(int value) throws ArithmeticException {
		
		// Our factorial may only operate on a non-negative integer.  The definition
		// of the factorial function can also be extended to non-integer arguments,
		// while retaining its most important properties; however, this involves more
		// advanced mathematics, notably techniques from mathematical analysis.
		// http://en.wikipedia.org/wiki/Factorial
		if (value < 0) {
			throw new ArithmeticException("Factor may only operate on positive integers");
		}
		
		// Definition of 0! is 1 according to the convention for an empty product
		int i = 1;
		
		while (i <= value) {
			i = i * i++;
		}
		
		return i;
	}
}