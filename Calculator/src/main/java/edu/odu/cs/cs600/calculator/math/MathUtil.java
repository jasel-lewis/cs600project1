package edu.odu.cs.cs600.calculator.math;

/**
 * Class containing static mathematical methods.  These methods employ the appropriate
 * Evaluators.
 */
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

	/**
	 * Returns the absolute value of the passed value.  Employs the {@link AbsoluteValueEvaluator}.
	 * @param value
	 * @return
	 * @throws ArithmeticException
	 */
	public static double abs(double value) throws ArithmeticException {
		return absoluteValueEvaluator.compute(value);
	}
	
	/**
	 * Returns the value of the numerator divided by the divisor.  Employs the {@link DivisionEvaluator}.
	 * @param numerator
	 * @param divisor
	 * @return
	 * @throws ArithmeticException
	 */
	public static double divide(double numerator, double divisor) throws ArithmeticException {
		return divisionEvaluator.compute(numerator, divisor);
	}
	
	/**
	 * Returns a double representation of the ceiling of the passed value.  Employs the {@link CeilingEvaluator}.
	 * @param value
	 * @return
	 * @throws ArithmeticException
	 */
	public static double ceiling(double value) throws ArithmeticException {
		return ceilingEvaluator.compute(value);
	}

	/**
	 * Returns a double representation of the floor of the passed value.  Employs the {@link FloorEvaluator}.
	 * @param value
	 * @return
	 * @throws ArithmeticException
	 */
	public static double floor(double value) throws ArithmeticException {
		return floorEvaluator.compute(value);
	}

	/**
	 * Returns the negated value of the passed value.  Employs the {@link NegationEvaluator}.
	 * @param value
	 * @return
	 * @throws ArithmeticException
	 */
	public static double negate(double value) throws ArithmeticException {
		return negationEvaluator.compute(value);
	}

	/**
	 * Returns the reciprocal of the passed value.  Employs the {@link ReciprocalEvaluator}.
	 * @param value
	 * @return
	 * @throws ArithmeticException
	 */
	public static double reciprocate(double value) throws ArithmeticException {
		return reciprocalEvaluator.compute(value);
	}

	/**
	 * Returns the square root of the passed value.  Employs the {@link SquareRootEvaluator}.
	 * @param value
	 * @return
	 * @throws ArithmeticException
	 */
	public static double squareRoot(double value) throws ArithmeticException {
		return squareRootEvaluator.compute(value);
	}
	
	/**
	 * Returns the result of the first term reduced by the second term.  Employs the {@link SubtractionEvaluator}.
	 * @param x first term
	 * @param y second term
	 * @return
	 * @throws ArithmeticException
	 */
	public static double subtract(double x, double y) throws ArithmeticException {
		return subtractionEvaluator.compute(x, y);
	}
	
	/**
	 * Returns the exponentiation of the base by the exponent.  Employs the {@link ExponentiationEvaluator}.
	 * @param x base
	 * @param y exponent
	 * @return
	 * @throws ArithmeticException
	 */
	public static double exponentiate(double x, double y) throws ArithmeticException {
		return exponentiationEvaluator.compute(x, y);
	}
	
	/**
	 * Returns the factorial of the passed value.  Employs the {@link FactorialEvaluator}.
	 * @param x
	 * @return
	 * @throws ArithmeticException
	 */
	public static int factorial(int x) throws ArithmeticException {
		return factorialEvaluator.compute(x);
	}
	
	/**
	 * Returns the first factor multiplied by the second factor.  Employs the {@link MultiplicationEvaluator}.
	 * @param x first factor
	 * @param y second factor
	 * @return
	 * @throws ArithmeticException
	 */
	public static double multiply(double x, double y) throws ArithmeticException {
		return multiplicationEvaluator.compute(x, y);
	}
	
	/**
	 * Returns the second term added to the first term.  Employs the {@link AdditionEvaluator}.
	 * @param x first term
	 * @param y second term
	 * @return
	 * @throws ArithmeticException
	 */
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
		int num = 1;
		
		if (exponent < 0) {
			throw new ArithmeticException("Argument must be positive");
		} else {
			while (exponent-- > 0) {
				num = num << 1;
			}
		}
		
		return num;
	}
}