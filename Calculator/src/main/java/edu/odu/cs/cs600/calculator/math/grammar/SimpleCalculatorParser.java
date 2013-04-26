package edu.odu.cs.cs600.calculator.math.grammar;

import edu.odu.cs.cs600.calculator.math.grammar.parselet.BinaryOperatorParselet;
import edu.odu.cs.cs600.calculator.math.grammar.parselet.GroupParselet;
import edu.odu.cs.cs600.calculator.math.grammar.parselet.NumberParselet;
import edu.odu.cs.cs600.calculator.math.grammar.parselet.PrefixOperatorParselet;

/**
 * Extends the generic Parser class with support for parsing the actual Bantam
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
	 * Registers a prefix unary operator parselet for the given token and precedence
	 * @param token
	 * @param precedence
	 */
	public void prefix(TokenType token, int precedence) {
		register(token, new PrefixOperatorParselet(precedence));
	}

	
	
	/**
	 * Registers a left-associative binary operator parselet for the given token
	 * and precedence
	 * @param token
	 * @param precedence
	 */
	public void infixLeft(TokenType token, int precedence) {
		register(token, new BinaryOperatorParselet(precedence, false));
	}

	
	
	/**
	 * Registers a right-associative binary operator parselet for the given token
	 * and precedence
	 * @param token
	 * @param precedence
	 */
	public void infixRight(TokenType token, int precedence) {
		register(token, new BinaryOperatorParselet(precedence, true));
	}
}