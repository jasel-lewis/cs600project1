package edu.odu.cs.cs600.calculator.math.grammar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import edu.odu.cs.cs600.calculator.math.grammar.Lexer;
import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Phrase;
import edu.odu.cs.cs600.calculator.math.grammar.SimpleCalculatorParser;

public class ParserNumberRecognitionTest {
	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}
	
	@Test
	public void testBlankPhrase() {
		// "Blank Phrase" is really a falsity, at a minimum, 0 is always the value of a new Phrase
		Phrase phrase = new Phrase();
		Parser parser = new SimpleCalculatorParser(new Lexer(phrase));
		StringBuilder builder = new StringBuilder();
		parser.parseExpression().print(builder);
		
		assertEquals("Blank phrase test should equal 0", "0", builder.toString());
	}

	@Test
	public void testSingleDigitIntegerInput() {
		Phrase phrase = Phrase.convertToPhrase("1");
		Parser parser = new SimpleCalculatorParser(new Lexer(phrase));
		StringBuilder builder = new StringBuilder();
		parser.parseExpression().print(builder);
		
		assertEquals("Integer should have been parsed as 1", "1", builder.toString());
	}
	
	@Test
	public void testTwoDigitIntegerInput() {
		Phrase phrase = Phrase.convertToPhrase("54");
		Parser parser = new SimpleCalculatorParser(new Lexer(phrase));
		StringBuilder builder = new StringBuilder();
		parser.parseExpression().print(builder);
		
		assertEquals("Integer should have been parsed as 54", "54", builder.toString());
	}
	
	@Test
	public void testMultipleDigitIntegerInput() {
		Phrase phrase = Phrase.convertToPhrase("9876543210");
		Parser parser = new SimpleCalculatorParser(new Lexer(phrase));
		StringBuilder builder = new StringBuilder();
		parser.parseExpression().print(builder);
		
		assertEquals("Integer should have been parsed as 9876543210", "9876543210", builder.toString());
	}
	
	@Test
	public void testRealNumberInput() {
		Phrase phrase = Phrase.convertToPhrase("0.0");
		Parser parser = new SimpleCalculatorParser(new Lexer(phrase));
		StringBuilder builder = new StringBuilder();
		parser.parseExpression().print(builder);
		
		assertEquals("Real number should have been parsed as 0.0", "0.0", builder.toString());
	}
	
	@Test
	public void testRealNumberInput2() {
		Phrase phrase = Phrase.convertToPhrase("0.123");
		Parser parser = new SimpleCalculatorParser(new Lexer(phrase));
		StringBuilder builder = new StringBuilder();
		parser.parseExpression().print(builder);
		
		assertEquals("Real number should have been parsed as 0.123", "0.123", builder.toString());
	}
	
	@Test
	public void testRealNumberInput3() {
		Phrase phrase = Phrase.convertToPhrase("9876.6879");
		Parser parser = new SimpleCalculatorParser(new Lexer(phrase));
		StringBuilder builder = new StringBuilder();
		parser.parseExpression().print(builder);
		
		assertEquals("Real number should have been parsed as 9876.6879", "9876.6879", builder.toString());
	}
	
	@Test
	public void testRealNumberInput4() {
		Phrase phrase = Phrase.convertToPhrase(".69");
		Parser parser = new SimpleCalculatorParser(new Lexer(phrase));
		StringBuilder builder = new StringBuilder();
		parser.parseExpression().print(builder);
		
		assertEquals("Real number should have been parsed as .69", ".69", builder.toString());
	}
	
	@Test
	public void testUnrealNumberInput() {
		Phrase phrase = Phrase.convertToPhrase("12.34.56");
		Parser parser = new SimpleCalculatorParser(new Lexer(phrase));
		StringBuilder builder = new StringBuilder();
		parser.parseExpression().print(builder);
		
		assertEquals("Real number should have been parsed as 12.34", "12.34", builder.toString());
	}
}