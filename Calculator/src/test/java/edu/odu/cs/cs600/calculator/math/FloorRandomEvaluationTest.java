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

public class FloorRandomEvaluationTest {
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-10;
	
	
	@Test
	public void testRandomNumbers() {
		Random random = new Random(1337);
		double randomDouble = 0.0;
		
		for (int i = 0; i < 1000; i++) {
			randomDouble = random.nextGaussian();
			assertEquals(Math.floor(randomDouble), MathUtil.floor(randomDouble), EPSILON);
		}
	}
}