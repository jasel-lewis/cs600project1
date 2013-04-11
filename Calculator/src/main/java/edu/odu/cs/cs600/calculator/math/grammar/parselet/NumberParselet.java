package edu.odu.cs.cs600.calculator.math.grammar.parselet;

import edu.odu.cs.cs600.calculator.math.grammar.Expression;
import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Token;

/**
 * Class to parse numbers.
 * Write-up: http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/
 */
public class NumberParselet implements PrefixParselet {
	public Expression parse(Parser parser, Token token) {
		return new NumberExpression(token.getLexeme());
	}
}