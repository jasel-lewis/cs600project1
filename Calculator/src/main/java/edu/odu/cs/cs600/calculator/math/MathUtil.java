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

	public static double reciprocal(double value) throws ArithmeticException {
		return reciprocalEvaluator.compute(value);
	}

	public static double squareRoot(double value) throws ArithmeticException {
		return squareRootEvaluator.compute(value);
	}
	
	public static double subtract(double x, double y) throws ArithmeticException {
		return subtractionEvaluator.compute(x, y);
	}
}