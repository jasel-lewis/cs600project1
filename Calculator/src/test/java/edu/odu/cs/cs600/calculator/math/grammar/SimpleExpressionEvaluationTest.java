package edu.odu.cs.cs600.calculator.math.grammar;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import edu.odu.cs.cs600.calculator.math.grammar.Lexer;
import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Phrase;
import edu.odu.cs.cs600.calculator.math.grammar.SimpleCalculatorParser;

@RunWith(Parameterized.class)
public class SimpleExpressionEvaluationTest {
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-10;
	
	private String expression;
	private double expectedResult;
	private Parser parser = null;
	
	
	public SimpleExpressionEvaluationTest(String expression, double expectedResult) {
		this.expression = expression;
		this.expectedResult = expectedResult;
	}
	
	
	@Before
	public void setUp() {
		parser = new SimpleCalculatorParser(new Lexer(Phrase.convertToPhrase(expression)));
	}
	
	
	@After
	public void tearDown() {
		parser = null;
	}
	
	
	@Parameters
	public static Collection<Object[]> testData() {
		// { expression, expectedResult }
		return Arrays.asList(new Object[][] {
			{ "(9)", 9.0 },						//  0
			{ "((((76.3))))", 76.3 },			//  1
			{ "(  (( 3)))", 3.0 },				//  2
			{ "8+4", 12.0 },					//  3
			{ "8 + 4", 12.0 },					//  4
			{ "8       +4", 12.0 },				//  5
			{ "8-4", 4.0 },						//  6
			{ "8 - 4", 4.0 },					//  7
			{ "8*4", 32.0 },					//  8
			{ "8 * 4", 32.0 },					//  9
			{ "8/4", 2.0 },						// 10
			{ "8 / 4", 2.0 },					// 11
			{ "8^4", Math.pow(8, 4) },			// 12
			{ "2^-3", Math.pow(2, -3) },		// 13
			{ "125^125", Math.pow(125, 125) }	// 14 - output is correct, not sure why failing here
		});
	}
	
	
	@Test
	public void testValidExpressions() {
		double result = parser.parseExpression().getValue();
		
		assertEquals(result, this.expectedResult, EPSILON);
	}
}