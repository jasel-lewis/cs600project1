package edu.odu.cs.cs600.calculator.math.grammar.parselet;

import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Token;
import edu.odu.cs.cs600.calculator.math.grammar.TokenType;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.Expression;

/**
 * Parses the parentheses used to group an {@link Expression}.
 * 
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/parselets/GroupParselet.java
 */
public class GroupParselet implements PrefixParselet {
	
	/**
	 * Parse until the associated right parenthesis is reached
	 * @return The resultant {@link Expression}
	 */
	public Expression parse(Parser parser, Token token) {
		Expression expression = parser.parseExpression();
		
		parser.consume(TokenType.RIGHT_PARENTHESIS);
		
		return expression;
	}
}