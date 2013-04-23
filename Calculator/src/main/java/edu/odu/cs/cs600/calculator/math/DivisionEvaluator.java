package edu.odu.cs.cs600.calculator.math;

public class DivisionEvaluator implements IBinaryEvaluator {

	public double compute(double numerator, double divisor) throws ArithmeticException 
	{
		return numerator * MathUtil.reciprocate(divisor);
	}

}
