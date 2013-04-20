package edu.odu.cs.cs600.calculator.math.grammar;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import edu.odu.cs.cs600.calculator.math.ReciprocalEvaluator;
import edu.odu.cs.cs600.calculator.math.grammar.Lexer;
import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Phrase;
import edu.odu.cs.cs600.calculator.math.grammar.SimpleCalculatorParser;

public class InvalidNumberEvaluationTest {
	@Before
	public void setUp() {
	}
	
	
	@After
	public void tearDown() {
	}
	
	
	@Test
	public void testInvalidNumber() {
		Parser parser = new SimpleCalculatorParser(new Lexer(Phrase.convertToPhrase("0.0.0")));
		double result = parser.parseExpression().getValue();
		
		assertFalse(Double.compare(0.0, result) == 0);
	}
}