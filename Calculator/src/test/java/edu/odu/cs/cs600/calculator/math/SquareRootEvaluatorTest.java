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
public class SquareRootEvaluatorTest 
{
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-10;
	private SquareRootEvaluator squareRootEvaluator = null;
	private double inputValue;
	private double expectedResult;
	
	public SquareRootEvaluatorTest(double inputValue, double expectedResult)
	{
		this.inputValue = inputValue;
		this.expectedResult = expectedResult;
	}
	
	@Before
	public void setUp()
	{
		squareRootEvaluator = new SquareRootEvaluator();
	}
	
	@After
	public void tearDown()
	{
		squareRootEvaluator = null;
	}
	
	@Parameters
	public static Collection<Object[]> testData()
	{
		return Arrays.asList(new Object[][] {
			/* { inputValue, expectedValue }, */
			{0.0, 0.0},
			{1.0, 1.0},
			{4.0, 2.0},
			{16.0, 4.0},
			{5.5, Math.sqrt(5.5)},
			{456.654, Math.sqrt(456.654)}
		});
	}
	
	@Test
	public void testReciprocalEvaluator()
	{
		double actualResult = squareRootEvaluator.compute(this.inputValue);
		assertEquals(
			actualResult,
			this.expectedResult,
			EPSILON
		);
	}

}
