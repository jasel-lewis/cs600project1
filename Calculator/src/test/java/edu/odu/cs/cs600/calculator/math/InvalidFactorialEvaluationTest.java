package edu.odu.cs.cs600.calculator.math;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InvalidFactorialEvaluationTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testInvalidFactorialNegative1() {
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("Factorial may only operate on positive integers");
		
		MathUtil.factorial(-1);
	}
	
	@Test
	public void testInvalidFactorialNegative900() {
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("Factorial may only operate on positive integers");
		
		MathUtil.factorial(-900);
	}
	
	@Test
	public void testInvalidFactorialNonInteger() {
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("Exponent must be an integer");
		
		MathUtil.factorial(0.5);
	}
}