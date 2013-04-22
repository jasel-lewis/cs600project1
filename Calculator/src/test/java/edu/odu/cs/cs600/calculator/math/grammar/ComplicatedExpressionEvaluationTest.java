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
public class ComplicatedExpressionEvaluationTest {
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-10;
	
	private String expression;
	private double expectedResult;
	private Parser parser = null;
	
	
	public ComplicatedExpressionEvaluationTest(String expression, double expectedResult) {
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
			{ "6 + 5 - 4 * 3 / 2 ", 5.0 },				//  0
			{ "6 - 5 * 4 / 3 + 2 ", 1.3333333333 },		//  1
			{ "6 * 5 / 4 + 3 - 2 ", 8.5 },				//  2
			{ "6 / 5 + 4 - 3 * 2 ", -0.8 },				//  3
			{ "6 - 5 + 4 * 3 / 2 ", 7.0 },				//  4
			{ "6 + 5 - 4 / 3 * 2 ", 8.3333333333 },		//  5
			{ "6 / 5 - 4 * 3 + 2 ", -8.8 },				//  6
			{ "6 + 5 * 4 - 3 / 2 ", 24.5 },				//  7
			{ "6 * 5 + 4 / 3 - 2 ", 29.3333333333 },	//  8
			{ "6 * 5 - 4 + 3 / 2 ", 27.5 },				//  9
			{ "(6+5)/(4-3)*2", 22.0 },					// 10
			{ "(6-5*4)/(3+2*3)", -1.5555555555 },		// 11
			{ "((6-5)*4)/((3+2)*3)", 0.2666666666 }		// 12
		});
	}
	
	
	@Test
	public void testValidExpressions() {
		double result = parser.parseExpression().getValue();
		
		assertEquals(result, this.expectedResult, EPSILON);
	}
}