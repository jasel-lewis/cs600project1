package edu.odu.cs.cs600.calculator.math;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Evaluator computes the floor of a passed value.  See {@link #compute(double)} 
 * for implementation details.
 */
public class FloorEvaluator implements IUnaryEvaluator {

	private static Logger logger = LogManager.getLogger(FloorEvaluator.class);
	
	/**
	 * Determine the floor of the passed value.  Divide the realm of infinite, real numbers
	 * into a range; bracketing value by two binary integers, 2^k and 2^(k+1), where
	 * 2^k <= value < 2^(k+1).  Perform a binary search for value within this range.  Method
	 * handles special cases such as 0.0 >= value < 1.0 and -1.0 >= value < 0.0 as these
	 * can't be encapsulated by the above process.  Negative input is passed to
	 * {@link MathUtil#ceiling(double)} under the realization that floor(a) = -(ceiling(-a)). 
	 * @param value The value to compute the floor of
	 * @return The floor of the passed value
	 * @throws ArithmeticException
	 */
	public double compute(double value) throws ArithmeticException {
		logger.debug("Computing the floor on value: " + value);
		
		if (value >= 1.0) {
			int k = 0, kPlusOne = 1;
			
			while (MathUtil.binaryExponentiation(kPlusOne) <= value) {
				k = kPlusOne++;
			}
			
			logger.debug("Bounded value with 2^" + k + " and 2^" + kPlusOne);
			
			return (double)floorBinarySearch(MathUtil.binaryExponentiation(k), MathUtil.binaryExponentiation(kPlusOne), value);
		} else if ((value >= 0.0) && (value < 1.0)) {
			logger.debug("Special case handled: value is >= 0.0 && < 1.0");
			return (0.0);
		} else if ((value >= MathUtil.negate(1.0)) && (value < 0.0)) {
			logger.debug("Special case handled: value is >= -1.0 && < 0.0");
			return (MathUtil.negate(1.0));
		} else {
			logger.debug("Value is negative; sending to ceiling() with a negated value");
			
			// If a < 0, Floor(a) = -(Ceiling(-a))
			return (MathUtil.negate(MathUtil.ceiling(MathUtil.negate(value))));
		}
	}
	
	
	
	/**
	 * Perform a binary search for value within the linear set of numbers delineated by lower
	 * and upper; returning the lower bound
	 * @param lower lower bound of the integer range to which value is greater than, <i>or equal to</i>
	 * @param upper upper bound of the integer range to which value is less than
	 * @param value
	 * @return
	 */
	private int floorBinarySearch(int lower, int upper, double value) {
		logger.debug("Performing a binary search on the range " + lower + " to " + upper + " looking for " + value);
		
		if (upper != (lower + 1)) {
			// Find the middle value
			int middle = (int)((lower + upper) * 0.5);
			logger.debug("Middle of the range was determined to be " + middle);
			
			// Does value exist in the left or right partition of the range?
			if (value < middle) {
				logger.debug("Value in lower half of range - making recursive call on lower range (" + lower + " to " + middle + ")");
				return(floorBinarySearch(lower, middle, value));
			} else {
				logger.debug("Value in upper half of range - making recursive call on upper range (" + middle + " to " + upper + ")");
				return(floorBinarySearch(middle, upper, value));
			}
		}
		
		return lower;
	}
}