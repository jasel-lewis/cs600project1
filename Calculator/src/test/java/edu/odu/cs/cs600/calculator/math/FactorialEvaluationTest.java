package edu.odu.cs.cs600.calculator.math;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FactorialEvaluationTest
{
	private static final double EPSILON = 1e-12;
	
	double number;
	double expectedResult;
	
	public FactorialEvaluationTest(double number, double expectedResult) {
		this.number = number;
		this.expectedResult = expectedResult;
	}	
	
	@Parameters
	public static Collection<Object[]> testData() {
		// { expression, expectedResult }
		return Arrays.asList(new Object[][] {
			{  0.0, 1.0 },			//  0
			{  1.0, 1.0 },			//  1
			{  2.0, 2.0 },			//  2
			{  3.0, 6.0 },			//  3
			{  4.0, 24.0 },			//  4
			{  5.0, 120.0 },		//  5
			{  6.0, 720.0 },		//  6
			{  7.0, 5040.0 },		//  7
			{  8.0, 40320.0 },		//  8
			{  9.0, 362880.0 },		//  9
			{ 10.0, 3628800.0 }		// 10
		});
	}
	
	@Test
	public void testFactorial() {
		assertEquals(MathUtil.factorial(number), expectedResult, EPSILON);
	}
}