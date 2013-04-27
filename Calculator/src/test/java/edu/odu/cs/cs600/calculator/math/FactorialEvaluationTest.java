package edu.odu.cs.cs600.calculator.math;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FactorialEvaluationTest {
	int number = 0;
	int expectedResult = 0;
	
	
	public FactorialEvaluationTest(int number, int expectedResult) {
		this.number = number;
		this.expectedResult = expectedResult;
	}
	
	
	@Parameters
	public static Collection<Object[]> testData() {
		// { expression, expectedResult }
		return Arrays.asList(new Object[][] {
			{  0, 1 },			//  0
			{  1, 1 },			//  1
			{  2, 2 },			//  2
			{  3, 6 },			//  3
			{  4, 24 },			//  4
			{  5, 120 },		//  5
			{  6, 720 },		//  6
			{  7, 5040 },		//  7
			{  8, 40320 },		//  8
			{  9, 362880 },		//  9
			{ 10, 3628800 }		// 10
		});
	}
	
	
	@Test
	public void testFactorial() {
		assertEquals(MathUtil.factorial(number), expectedResult);
	}
}