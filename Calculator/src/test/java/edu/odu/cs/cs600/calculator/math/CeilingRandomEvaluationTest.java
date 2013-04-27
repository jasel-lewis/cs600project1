package edu.odu.cs.cs600.calculator.math;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class CeilingRandomEvaluationTest {
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-10;
	
	
	@Test
	public void testRandomNumbers() {
		Random random = new Random(1337);
		double randomDouble = 0.0;
		int intMultiplier = 0;
		
		for (int i = 0; i < 10000; i++) {
			randomDouble = random.nextDouble();
			intMultiplier = random.nextInt(6);
			
			randomDouble = randomDouble * Math.pow(10, intMultiplier);
			assertEquals(Math.ceil(randomDouble), MathUtil.ceiling(randomDouble), EPSILON);
		}
	}
}