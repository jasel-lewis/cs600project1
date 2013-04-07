package edu.odu.cs.cs600.calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.odu.cs.cs600.calculator.grammar.Phrase;
import edu.odu.cs.cs600.calculator.math.grammar.Parser;

public class ParserTest {
	private static final double EPSILON = 1e-12;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testBlankPhrase() {
		// "Blank Phrase" is really a falsity, at a minimum, 0 is always the value of a new Phrase
		Phrase phrase = new Phrase();
		double val = 0.0;
		
		assertEquals("\"Blank\" phrase test", val, Parser.parse(phrase), EPSILON);
	}

	@Test
	public void integerInputTest() {
		Phrase phrase = new Phrase();
		double val = 0.0;
		
		phrase.convertToPhrase("1");
		val = 1.0;
		assertEquals("Parsing integer value 1", val, Parser.parse(phrase), EPSILON);
	}
	
	@Test
	public void doubleInputTest() {
		Phrase phrase = new Phrase();
		double val = 0.0;
		
		phrase.convertToPhrase("3.0");
		val = 3.0;
		assertEquals("Parsing double \"3.0\"", val, Parser.parse(phrase), EPSILON);
		
		phrase.convertToPhrase("6.000");
		val = 6.0;
		assertEquals("Parsing double \"6.000\"", val, Parser.parse(phrase), EPSILON);
		
		phrase.convertToPhrase("9.00000000");
		val = 9.0;
		assertEquals("Parsing double \"9.00000000\"", val, Parser.parse(phrase), EPSILON);
		
		phrase.convertToPhrase(".12345");
		val = 0.12345;
		assertEquals("Parsing double \".12345\"", val, Parser.parse(phrase), EPSILON);
		
		phrase.convertToPhrase("0.0");
		val = 0.0;
		assertEquals("Parsing double \"0.0\"", val, Parser.parse(phrase), EPSILON);
		
		phrase.convertToPhrase("0.8765");
		val = 0.8765;
		assertEquals("Parsing double \"0.8765\"", val, Parser.parse(phrase), EPSILON);
	}
}