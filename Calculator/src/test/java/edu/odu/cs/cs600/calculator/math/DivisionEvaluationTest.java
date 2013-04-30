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
public class DivisionEvaluationTest 
{
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-12;
	private DivisionEvaluator divisionEvaluator = null;
	private double x;
	private double y;
	private double expectedResult;
	
	public DivisionEvaluationTest(double x, double y, double expectedResult)
	{
		this.x = x;
		this.y = y;
		this.expectedResult = expectedResult;
	}
	
	@Before
	public void setUp()
	{
		divisionEvaluator = new DivisionEvaluator();
	}
	
	@After
	public void tearDown()
	{
		divisionEvaluator = null;
	}
	
	@Parameters
	public static Collection<Object[]> testData()
	{
		return Arrays.asList(new Object[][] {
			/* { inputValue, expectedValue }, */
			{1.0, 4.0, 1.0/4.0},
			{1.0, 1.0, 1.0/1.0},
			{1.0, 0.25, 1.0/0.25},
			{500.25, 25.0, 500.25/25.0},
			{.0625, 13.0, .0625/13.0},
			{999.0, 12.0, 999.0/12.0},
			{456.654, 789.987, 456.654/789.987}
		});
	}
	
	@Test
	public void testReciprocalEvaluator()
	{
		double actualResult = divisionEvaluator.compute(x,y);
		assertEquals(
			actualResult,
			this.expectedResult,
			EPSILON
		);
	}

}

