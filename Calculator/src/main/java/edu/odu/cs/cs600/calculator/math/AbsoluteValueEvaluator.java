package edu.odu.cs.cs600.calculator.math;

public class AbsoluteValueEvaluator implements IUnaryEvaluator
{

	@Override
	public double compute(double value) throws Exception 
	{
		if(value < 0)
			return MathUtil.negate(value);
		else
			return value;
	}

}
