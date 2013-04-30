package edu.odu.cs.cs600.calculator.math;

import org.junit.Test;

public class InvalidDivisionEvaluationTest {

	@Test(expected = ArithmeticException.class)  
	public void divideByZeroThrowsException() {
		DivisionEvaluator evaluator = new DivisionEvaluator();
		evaluator.compute(5.0, 0.0);
	}

}
