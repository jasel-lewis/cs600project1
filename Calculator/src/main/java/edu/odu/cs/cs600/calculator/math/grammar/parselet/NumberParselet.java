package edu.odu.cs.cs600.calculator.math.grammar.parselet;

import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Token;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.Expression;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.NumberExpression;

/**
 * A pareslet to encapsulate a {@link NumberExpression}
 * <br><br>
 * Write-up: <a href="http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/">http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/</a>
 */
public class NumberParselet implements PrefixParselet {
	
	/**
	 * @return A new {@link NumberExpression} from the passed {@link Parser} and the
	 * passed lexeme ({@link String} representation of the number)
	 */
	public Expression parse(Parser parser, Token token) {
		return new NumberExpression(token.getLexeme());
	}
}