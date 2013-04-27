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
public class AbsoluteValueEvaluationTest 
{
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 0;
	private AbsoluteValueEvaluator absoluteValueEvaluator = null;
	private double inputValue;
	private double expectedResult;
	
	public AbsoluteValueEvaluationTest(double inputValue, double expectedResult)
	{
		this.inputValue = inputValue;
		this.expectedResult = expectedResult;
	}
	
	@Before
	public void setUp()
	{
		absoluteValueEvaluator = new AbsoluteValueEvaluator();
	}
	
	@After
	public void tearDown()
	{
		absoluteValueEvaluator = null;
	}
	
	@Parameters
	public static Collection<Object[]> testData()
	{
		return Arrays.asList(new Object[][] {
			/* { inputValue, expectedValue }, */
			{-123.321,123.321},
			{-1.0,1.0},
			{-0.1,0.1},
			{0,0},
			{1.0,1.0},
			{0.1,0.1},
			{123.321,123.321}
		});
	}
	
	@Test
	public void testReciprocalEvaluator()
	{
		double actualResult = absoluteValueEvaluator.compute(this.inputValue);
		assertEquals(
			actualResult,
			this.expectedResult,
			EPSILON
		);
	}

}
