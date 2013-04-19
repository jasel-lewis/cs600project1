package edu.odu.cs.cs600.calculator.math;

public class NegationEvaluator implements IUnaryEvaluator {

	public double compute(double value) throws ArithmeticException
	{
		return -value;
	}
	
}
