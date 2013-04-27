package edu.odu.cs.cs600.calculator.math;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CeilingFixedEvaluationTest {
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-10;
	
	private double value;
	
	
	public CeilingFixedEvaluationTest(double value) {
		this.value = value;
	}
	
	
	@Parameters
	public static Collection<Object[]> testData() {
		// { expression, expectedResult }
		return Arrays.asList(new Object[][] {
			{ 1.0 },			//  0
			{ 0.8 },			//  1
			{ 1.23456789 },		//  2
			{ 10.1 },			//  3
			{ 24567.123 },		//  4
			{ 0.0 },			//  5
			{ -0.9 },			//  6
			{ -0.900000 },		//  7
			{ -1.1 },			//  8
			{ -0.111111 },		//  9
			{ -1.3 },			// 10
			{ 1.9 },			// 11
			{ -0.1 },			// 12
			{ -0.0000001 },		// 13
			{ -1.00000000 },	// 14
			{ -9.99999999 }		// 15
		});
	}
	
	
	@Test
	public void testValidNumbers() {
		assertEquals(Math.ceil(value), MathUtil.ceiling(value), EPSILON);
	}
}