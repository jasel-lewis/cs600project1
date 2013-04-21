package edu.odu.cs.cs600.calculator.math.grammar;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.odu.cs.cs600.calculator.math.grammar.Lexer;
import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Phrase;
import edu.odu.cs.cs600.calculator.math.grammar.SimpleCalculatorParser;

public class InvalidNumberEvaluationTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testInvalidNumberMultipleDecimalPoints() {
		Parser parser = new SimpleCalculatorParser(new Lexer(Phrase.convertToPhrase("0.0.0")));
		
		thrown.expect(NumberFormatException.class);
		thrown.expectMessage("multiple points");
		
		double result = parser.parseExpression().getValue();
	}
}