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
public class UnaryExpressionEvaluationTest {
	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-10;
	
	private String expression;
	private double expectedResult;
	private Parser parser = null;
	
	
	public UnaryExpressionEvaluationTest(String expression, double expectedResult) {
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
			{ "+9", 9.0 },
			{ "-76.3", -76.3 },
			{ "++++++3.000", 3.0 },
			{ "------12", 12.0 },
			{ "---12", -12.0 },
			{ "- - - 13", -13.0 },
			{ "-.043", -0.043 },
			{ "++.976", 0.976 },
			{ "+(8)", 8.0 },
			{ "-(9.1)", -9.1 },
			{ "-(-(-(-4.3)))", 4.3 },	// Yes, more than 10 characters, but this is a test
			{ "(+(+(+(+5))))", 5.0 },	// Yes, more than 10 characters, but this is a test
			{ "+(+(+(+(+5))))", 5.0 }	// Yes, more than 10 characters, but this is a test
		});
	}
	
	
	@Test
	public void testValidExpressions() {
		double result = parser.parseExpression().getValue();
		
		assertEquals(result, this.expectedResult, EPSILON);
	}
}