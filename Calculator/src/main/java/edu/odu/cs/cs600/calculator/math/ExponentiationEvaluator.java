package edu.odu.cs.cs600.calculator.math;

public class ExponentiationEvaluator implements IBinaryEvaluator {

	/**
	 * Calculates a double representation of the passed base taken to the passed exponent.
	 * There exists a way to calculate a base to a real number exponent, however, this
	 * gets deep into number theory and such is not the intention here.  The passed value
	 * for exponent must be a double representation of an integer value.  If this is not
	 * adhered to, an {@link ArithmeticException} is thrown.  The recursive method
	 * {@link #helper(double, int)} is used to efficiently evaluate the computation in
	 * O(log n) time.
	 * @param base
	 * @param exponent
	 * @return
	 * @throws ArithmeticException
	 */
	public double compute(double base, double exponent) throws ArithmeticException {
		// We're only going to perform the common notion of exponentiation where the exponent
		// must be an integer.  Have to be considerate of the sign...
		if (((exponent > 0.0) && (Double.compare(MathUtil.floor(exponent), exponent) != 0))
		|| ((exponent < 0.0) && (Double.compare(MathUtil.ceiling(exponent), exponent) != 0))) {
			throw new ArithmeticException("Exponent must be an integer");
		}
		
		return helper(base, (int)exponent);
	}
	
	
	
	/**
	 * O(log n) calculation of an exponent (similar to what we did in class) - taken from
	 * <a href="http://en.wikipedia.org/wiki/Exponentiation_by_squaring">.  This practice of
	 * squaring the base for every even exponent and for every odd exponent, squaring the
	 * base and multiplying the result by the base, extends beautifully to a simple
	 * introspection of a binary representation of the exponent.  Exposing and identifying
	 * individual bits is not that easy in Java, so this is a version of such an
	 * implementation.
	 * @param base
	 * @param exponent
	 * @return
	 */
	private double helper(double base, int exponent) {
		if (exponent < 0) {
			return helper(MathUtil.reciprocate(base), -exponent);
		} else if (exponent == 0) {
			return 1;
		} else if (exponent == 1) {
			return base;
		} else if ((exponent % 2) == 0) {  // If exponent is even
			return helper((base * base), (exponent / 2));
		} else {
			return (base * helper((base * base), ((exponent - 1) / 2)));
		}
	}
}