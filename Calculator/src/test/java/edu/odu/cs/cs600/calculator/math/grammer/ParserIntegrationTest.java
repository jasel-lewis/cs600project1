package edu.odu.cs.cs600.calculator.math.grammer;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import edu.odu.cs.cs600.calculator.math.grammar.Phrase;

@RunWith(Parameterized.class)
public class ParserIntegrationTest 
{

	// For double comparison, this is the precision to which assertEquals will compare values
	private static final double EPSILON = 1e-10;
	
	// State variables used internally for each test.
	private Phrase phrase;
	private double expectedResult;
	
		
	public ParserIntegrationTest(String phrase, double expectedResult)
	{
		this.phrase = Phrase.convertToPhrase(phrase);
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Collection<Object[]> testData()
	{
		return Arrays.asList(new Object[][] {
			{ "0", 0.0, },
			{ "1", 1.0 },
			{ "54", 54.0 },
			{ "987654321", 987654321 },
			{ "0.0", 0.0 },
			{ "0.123", 0.123 },
			{ "9876.6789", 9876.6789 },
			{ "0.69", 0.69 },
			{ "12.34", 12.34 }
		});
	}
	
	@Ignore
	@Test
	public void testParser()
	{
//		double actualResult = Parser.parse(this.phrase);
//		assertEquals(
//			actualResult,
//			this.expectedResult,
//			EPSILON
//		);
	}

}
