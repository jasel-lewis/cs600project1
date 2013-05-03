package edu.odu.cs.cs600.calculator.math.grammar;

import edu.odu.cs.cs600.calculator.math.grammar.parselet.BinaryOperatorParselet;
import edu.odu.cs.cs600.calculator.math.grammar.parselet.GroupParselet;
import edu.odu.cs.cs600.calculator.math.grammar.parselet.NumberParselet;
import edu.odu.cs.cs600.calculator.math.grammar.parselet.PrefixOperatorParselet;

/**
 * Extends the generic {@link Parser} class with support for parsing the actual Calculator
 * grammar.
 */
public class SimpleCalculatorParser extends Parser {
	public SimpleCalculatorParser(Lexer lexer) {
		super(lexer);

		// Register all of the parselets for the grammar

		// Register the ones that need special parselets
		register(TokenType.NUMBER, new NumberParselet());
		register(TokenType.LEFT_PARENTHESIS, new GroupParselet());

		// Register the simple operator parselets
		prefix(TokenType.PLUS, Precedence.PREFIX);
		prefix(TokenType.MINUS, Precedence.PREFIX);
		
		infixLeft(TokenType.PLUS, Precedence.SUM);
		infixLeft(TokenType.MINUS, Precedence.SUM);
		infixLeft(TokenType.MULTIPLY, Precedence.PRODUCT);
		infixLeft(TokenType.DIVIDE, Precedence.PRODUCT);
		infixRight(TokenType.POWER, Precedence.EXPONENT);
	}

	
	
	/**
	 * Registers a new {@link PrefixOperatorParselet} (unary operator) having the passed
	 * precedence for the passed {@link TokenType}
	 * @param token The {@link TokenType} to register with the new {@link PrefixOperatorParselet}
	 * @param precedence The integer precedence to assign to the new {@link PrefixOperatorParselet}
	 */
	public void prefix(TokenType token, int precedence) {
		register(token, new PrefixOperatorParselet(precedence));
	}

	
	
	/**
	 * Registers a left-associative {@link BinaryOperatorParselet} having the passed
	 * precedence for the passed {@link TokenType}
	 * @param token The {@link TokenType} to register with the new {@link BinaryOperatorParselet}
	 * @param precedence The integer precedence to assign to the new {@link BinaryOperatorParselet}
	 */
	public void infixLeft(TokenType token, int precedence) {
		register(token, new BinaryOperatorParselet(precedence, false));
	}

	
	/**
	 * Registers a right-associative {@link BinaryOperatorParselet} having the passed
	 * precedence for the passed {@link TokenType}
	 * @param token The {@link TokenType} to register with the new {@link BinaryOperatorParselet}
	 * @param precedence The integer precedence to assign to the new {@link BinaryOperatorParselet}
	 */
	public void infixRight(TokenType token, int precedence) {
		register(token, new BinaryOperatorParselet(precedence, true));
	}
	
	
	/**
	 * Evaluate the passed {@link Phrase} in its entirety, returning the ultimate,
	 * calculated double value.
	 * @param phrase The {@link Phrase} to evaluate
	 * @return The calculated double value of the passed {@link Phrase} 
	 */
	public static double evaluatePhrase(Phrase phrase)
	{
		Parser parser = new SimpleCalculatorParser(new Lexer(phrase));
		return parser.parseExpression().getValue();
	}
}