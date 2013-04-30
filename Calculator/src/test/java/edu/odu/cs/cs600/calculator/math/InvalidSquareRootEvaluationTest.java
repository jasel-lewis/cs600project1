package edu.odu.cs.cs600.calculator.math;

import org.junit.Test;

public class InvalidSquareRootEvaluationTest {

	@Test(expected = ArithmeticException.class)  
	public void lessThanZeroThrowsException1() {
		SquareRootEvaluator evaluator = new SquareRootEvaluator();
		evaluator.compute(-0.0000001);
	}
	
	@Test(expected = ArithmeticException.class)  
	public void lessThanZeroThrowsException2() {
		SquareRootEvaluator evaluator = new SquareRootEvaluator();
		evaluator.compute(-1.0);
	}
	
	@Test(expected = ArithmeticException.class)  
	public void lessThanZeroThrowsException3() {
		SquareRootEvaluator evaluator = new SquareRootEvaluator();
		evaluator.compute(-123.00);
	}

}
