package edu.odu.cs.cs600.calculator.math;

public class MathUtil 
{
	private static final IUnaryEvaluator absoluteValueEvaluator = new AbsoluteValueEvaluator();
	private static final IUnaryEvaluator ceilingEvaluator = new CeilingEvaluator();
	private static final IUnaryEvaluator floorEvaluator = new FloorEvaluator();
	private static final IUnaryEvaluator negationEvaluator = new NegationEvaluator();
	private static final IUnaryEvaluator reciprocalEvaluator = new ReciprocalEvaluator();
	private static final IUnaryEvaluator squareRootEvaluator = new SquareRootEvaluator();
	private static final IBinaryEvaluator subtractionEvaluator = new SubtractionEvaluator();
	private static final IBinaryEvaluator divisionEvaluator = new DivisionEvaluator();

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