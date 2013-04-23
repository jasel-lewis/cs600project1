package edu.odu.cs.cs600.calculator.math;

public class ExponentiationEvaluator implements IBinaryEvaluator {

	public double compute(double base, double exponent) throws ArithmeticException {
		// We're only going to perform the common notion of exponentiation where the exponent
		// must be an integer.  Have to be considerate of the sign...
		if (((exponent > 0.0) && (Double.compare(MathUtil.floor(exponent), exponent) != 0))
		|| ((exponent < 0.0) && (Double.compare(MathUtil.ceiling(exponent), exponent) != 0))) {
			throw new ArithmeticException("Exponent must be an integer");
		}
		
		return helper(base, (int)exponent);
	}
	
	
	
	// O(log n) calculation of an exponent (similar to what we did in class):
	// http://en.wikipedia.org/wiki/Exponentiation_by_squaring
	private double helper(double base, int exponent) {
		if (exponent < 0) {
			return helper(MathUtil.reciprocate(base), -exponent);
		} else if (exponent == 0) {
			return 1;
		} else if (exponent == 1) {
			return base;
		} else if ((exponent % 2) == 0) {  // If even
			return helper(base * base, exponent/2);
		//} else if ((exponent % 2) == 1) {  // If odd
		} else {
			return (base * helper(base * base, (exponent - 1)/2));
		}
	}
}