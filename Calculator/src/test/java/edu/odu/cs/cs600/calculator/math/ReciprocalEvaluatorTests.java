package edu.odu.cs.cs600.calculator.math;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ReciprocalEvaluatorTests 
{
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-12;

	private ReciprocalEvaluator reciprocalEvaluator = null;
	
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
	
	@Test(expected= ArithmeticException.class)
	public void testZero() {
		reciprocalEvaluator.compute(0);
	}
	
	@Test
	public void testOne() {
		assertEquals(1.0, reciprocalEvaluator.compute(1.0), EPSILON);
	}
	
	@Test
	public void testGreaterThanOne() {
		assertEquals(1.0/4.0, reciprocalEvaluator.compute(4.0), EPSILON);
		assertEquals(1.0/16.0, reciprocalEvaluator.compute(16.0), EPSILON);
		assertEquals(1.0/100.0, reciprocalEvaluator.compute(100.0), EPSILON);
	}
	
	@Test
	public void testLessThanOneGreaterThanZero() {
		//assertEquals(1.0/0.5, reciprocalEvaluator.compute(0.5), EPSILON);
		//assertEquals(1.0/0.25, reciprocalEvaluator.compute(0.25), EPSILON);
		//assertEquals(1.0/0.333, reciprocalEvaluator.compute(0.333), EPSILON);
		assertEquals(100000, reciprocalEvaluator.compute(0.00001), EPSILON);
	}
	
	@Test
	public void testLessThanZero() {
		assertEquals(1.0/-1.0, reciprocalEvaluator.compute(-1.0), EPSILON);
		assertEquals(1.0/-0.5, reciprocalEvaluator.compute(-0.5), EPSILON);
		assertEquals(1.0/-2.0, reciprocalEvaluator.compute(-2.0), EPSILON);
		assertEquals(1.0/-20.0, reciprocalEvaluator.compute(-20.0), EPSILON);
	}

}
