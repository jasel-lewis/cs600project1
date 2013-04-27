package edu.odu.cs.cs600.calculator.math;

public class MathUtil 
{
	private static final AbsoluteValueEvaluator absoluteValueEvaluator = new AbsoluteValueEvaluator();
	private static final CeilingEvaluator ceilingEvaluator = new CeilingEvaluator();
	private static final FloorEvaluator floorEvaluator = new FloorEvaluator();
	private static final NegationEvaluator negationEvaluator = new NegationEvaluator();
	private static final ReciprocalEvaluator reciprocalEvaluator = new ReciprocalEvaluator();
	private static final SquareRootEvaluator squareRootEvaluator = new SquareRootEvaluator();
	private static final SubtractionEvaluator subtractionEvaluator = new SubtractionEvaluator();
	private static final DivisionEvaluator divisionEvaluator = new DivisionEvaluator();
	private static final ExponentiationEvaluator exponentiationEvaluator = new ExponentiationEvaluator();
	private static final FactorialEvaluator factorialEvaluator = new FactorialEvaluator();
	private static final MultiplicationEvaluator multiplicationEvaluator = new MultiplicationEvaluator();
	private static final AdditionEvaluator additionEvaluator = new AdditionEvaluator();

	public static double abs(double value) throws ArithmeticException {
		return absoluteValueEvaluator.compute(value);
	}
	
	public static double divide(double numerator, double divisor) throws ArithmeticException {
		return divisionEvaluator.compute(numerator, divisor);
	}
	
	public static double ceiling(double value) throws ArithmeticException {
		return ceilingEvaluator.compute(value);
	}

	public static double floor(double value) throws ArithmeticException {
		return floorEvaluator.compute(value);
	}

	public static double negate(double value) throws ArithmeticException {
		return negationEvaluator.compute(value);
	}

	public static double reciprocate(double value) throws ArithmeticException {
		return reciprocalEvaluator.compute(value);
	}

	public static double squareRoot(double value) throws ArithmeticException {
		return squareRootEvaluator.compute(value);
	}
	
	public static double subtract(double x, double y) throws ArithmeticException {
		return subtractionEvaluator.compute(x, y);
	}
	
	public static double exponentiate(double x, double y) throws ArithmeticException {
		return exponentiationEvaluator.compute(x, y);
	}
	
	public static int factorial(int x) throws ArithmeticException {
		return factorialEvaluator.compute(x);
	}
	
	public static double multiply(double x, double y) throws ArithmeticException {
		return multiplicationEvaluator.compute(x, y);
	}
	
	public static double add(double x, double y) throws ArithmeticException {
		return additionEvaluator.compute(x, y);
	}
	

	/**
	 * This method accepts a positive integer value as the exponent with which to
	 * perform binary exponentiation.  {@link #exponentiate(double, double)} could
	 * not be utilized as this would have set up a circular dependency
	 * ({@link ExponentialEvaluator} relies on {@link #floor(double)} and
	 * {@link #ceiling(double)} which then relies on this method).  If a negative
	 * value is passed, an {@link ArithmeticException} is thrown.
	 * @param exponent
	 * @return
	 * @throws {@link ArithmeticException}
	 */
	public static int binaryExponentiation(int exponent) {
		if (exponent == 0) {
			return 1;
		} else if (exponent == 1) {
			return 2;
		} else if (exponent > 1) {
			int result = 2;
			
			while (exponent-- > 1) {
				result = result * 2;
			}
			
			return result;
		} else {
			throw new ArithmeticException("Argument must be positive");
		}
	}
}