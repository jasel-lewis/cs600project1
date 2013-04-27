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

@RunWith(Parameterized.class)
public class FloorFixedEvaluationTest {
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-10;
	
	private double value;
	
	
	public FloorFixedEvaluationTest(double value) {
		this.value = value;
	}
	
	
	@Parameters
	public static Collection<Object[]> testData() {
		// { expression, expectedResult }
		return Arrays.asList(new Object[][] {
			{ 1.0 },			//  0
			{ 1.2 },			//  1
			{ 1.23456789 },		//  2
			{ 9.9 },			//  3
			{ 24567.123 },		//  4
			{ 0.0 },			//  5
			{ 0.1 },			//  6
			{ 0.100000 },		//  7
			{ 0.9 },			//  8
			{ 0.999999 },		//  9
			{ -1.3 },			// 10
			{ -1.9 },			// 11
			{ -0.1 },			// 12
			{ -0.0000001 },		// 13
			{ -1.00000000 },	// 14
			{ -9.99999999 }		// 15
		});
	}
	
	
	@Test
	public void testValidNumbers() {
		assertEquals(Math.floor(value), MathUtil.floor(value), EPSILON);
	}
}