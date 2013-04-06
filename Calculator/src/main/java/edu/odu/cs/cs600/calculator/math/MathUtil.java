package edu.odu.cs.cs600.calculator.math;

public class MathUtil {
	
	private static final IUnaryEvaluator ceilingEvaluator = new CeilingEvaluator();
	private static final IUnaryEvaluator floorEvaluator = new FloorEvaluator();
	private static final IUnaryEvaluator negationEvaluator = new NegationEvaluator();
	private static final IUnaryEvaluator reciprocalEvaluator = new ReciprocalEvaluator();
	private static final IUnaryEvaluator squareRootEvaluator = new SquareRootEvaluator();

	public static double ceiling(double value) {
		return ceilingEvaluator.compute(value);
	}

	public static double floor(double value) {
		return floorEvaluator.compute(value);
	}

	public static double negate(double value) {
		return negationEvaluator.compute(value);
	}

	public static double reciprocal(double value) {
		return reciprocalEvaluator.compute(value);
	}

	public static double squareRoot(double value) {
		return squareRootEvaluator.compute(value);
	}
}