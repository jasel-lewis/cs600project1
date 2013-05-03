package edu.odu.cs.cs600.calculator.math.grammar.parselet;

import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Token;
import edu.odu.cs.cs600.calculator.math.grammar.TokenType;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.Expression;

/**
 * A parselet to encapsulate a parenthetically-grouped {@link Expression}.
 * <br><br>
 * Adapted from: <a href="https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/parselets/GroupParselet.java">https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/parselets/GroupParselet.java</a>
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