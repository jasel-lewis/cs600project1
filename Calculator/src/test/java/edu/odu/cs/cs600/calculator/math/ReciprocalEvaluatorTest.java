package edu.odu.cs.cs600.calculator.math;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ReciprocalEvaluatorTest 
{
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-12;
	private ReciprocalEvaluator reciprocalEvaluator = null;
	private double inputValue;
	private double expectedResult;
	
	public ReciprocalEvaluatorTest(double inputValue, double expectedResult)
	{
		this.inputValue = inputValue;
		this.expectedResult = expectedResult;
	}
	
	@Before
	public void setUp()
	{
		reciprocalEvaluator = new ReciprocalEvaluator();
	}
	
	@After
	public void tearDown()
	{
		reciprocalEvaluator = null;
	}
	
	@Parameters
	public static Collection testData()
	{
		return Arrays.asList(new Object[][] {
			/* { inputValue, expectedValue }, */
			{1.0, 1.0},
			// x > 1
			{4.0, 1.0/4.0},
			{15.0, 1.0/15.0},
			{99.0, 1.0/99.0},
			// x = 1
			// 0 < x < 1
			{0.25, 1.0/0.25},
			{0.33, 1.0/0.33},
			{0.576, 1.0/0.576}
			// -1 < x < 0
			// x = -1
			// x <= -1
		});
	}
	
	@Test
	public void testReciprocalEvaluator()
	{
		double actualResult = reciprocalEvaluator.compute(this.inputValue);
		assertEquals(
			actualResult,
			this.expectedResult,
			EPSILON
		);
	}

}
