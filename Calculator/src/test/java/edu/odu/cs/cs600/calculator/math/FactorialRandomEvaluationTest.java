package edu.odu.cs.cs600.calculator.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialRandomEvaluationTest {
	
	@Test
	public void testRandomNumbers() {
		int result = 0;
		
		for (int i = 0; i < 10; i++) {
			result = MathUtil.factorial(i);
			
			// Not the best way to do this as we're comparing two, not-so-fully-evaluated
			// algorithm implementations - but whatevs...
			assertEquals(iterativeImplementation(i), result);
		}
	}
	
	
	private int iterativeImplementation(int value) {
		int x, fact = 1;
		
		for (x = value; x > 1; x--) {
			fact *= x;
		}

		return fact;
	}
}