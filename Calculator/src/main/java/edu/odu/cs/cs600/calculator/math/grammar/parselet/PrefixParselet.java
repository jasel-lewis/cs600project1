package edu.odu.cs.cs600.calculator.math.grammar.parselet;

import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Token;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.Expression;

/**
 * Interface for a {@link PrefixParselet}
 * <br><br>
 * Write-up: <a href="http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/">http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/</a><br>
 * Taken from: <a href="https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/parselets/PrefixParselet.java">https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/parselets/PrefixParselet.java</a>
 */
public interface PrefixParselet {
	Expression parse(Parser parser, Token token);
}