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
public class NumberEvaluationTest {
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-10;
	
	private String expression;
	private double expectedResult;
	private Parser parser = null;
	
	
	public NumberEvaluationTest(String expression, double expectedResult) {
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
			{ "0", 0.0 },					// Evaluate integer 0
			{ "1", 1.0 },					// Evaluate integer 1
			{ "0000", 0.0 },				// Evaluate valid, though oddly-represented, integer
			{ "98765432", 98765432.0 },		// Evaluate multi-digit integer
			{ "0.0", 0.0 },					// Evaluate real number 0.0
			{ ".0", 0.0 },					// Evaluate valid real number with single digit in decimal position
			{ ".8", 0.8 },					// Evaluate valid real number with single digit in decimal position
			{ ".000", 0.0 },				// Evaluate valid real number with multiple digits in decimal position
			{ ".123", 0.123 },				// Evaluate valid real number with multiple digits in decimal position
			{ "00000.0", 0.0 },				// Evaluate valid, though oddly-represented, real number
			{ "543.0", 543.0 },				// Evaluate valid, real number with multiple digits in whole number position
			{ "232.98", 232.98 }			// Evaluate valid, real number with multiple digits in whole number and decimal positions
		});
	}
	
	
	@Test
	public void testValidNumbers() {
		double result = parser.parseExpression().getValue();
		
		assertEquals(result, this.expectedResult, EPSILON);
	}
}