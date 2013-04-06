package edu.odu.cs.cs600.calculator.math;

public class MathUtil {
	
	private static final IEvaluator ceilingEvaluator = new CeilingEvaluator();
	private static final IEvaluator floorEvaluator = new FloorEvaluator();
	private static final IEvaluator negationEvaluator = new NegationEvaluator();
	private static final IEvaluator reciprocalEvaluator = new ReciprocalEvaluator();
	private static final IEvaluator squareRootEvaluator = new SquareRootEvaluator();

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