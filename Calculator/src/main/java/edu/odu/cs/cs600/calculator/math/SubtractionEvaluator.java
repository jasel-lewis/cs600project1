package edu.odu.cs.cs600.calculator.math;

public class SubtractionEvaluator implements IBinaryEvaluator {

	@Override
	public double compute(double x, double y) throws Exception 
	{
		return x + MathUtil.negate(y);
	}

}
