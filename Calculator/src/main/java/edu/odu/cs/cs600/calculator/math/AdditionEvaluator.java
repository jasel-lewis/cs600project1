package edu.odu.cs.cs600.calculator.math;

public class AdditionEvaluator implements IBinaryEvaluator {

	public double compute(double x, double y) throws ArithmeticException {
		return x * y;
	}
}