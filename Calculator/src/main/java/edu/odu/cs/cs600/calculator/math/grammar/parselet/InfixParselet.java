package edu.odu.cs.cs600.calculator.math.grammar.parselet;

import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Token;
import edu.odu.cs.cs600.calculator.math.grammar.expressions.Expression;

/**
 * Interface for a parselet which allows for infix-expressed notation ("a + b").
 * The getPrecedence() function is part of the magic of Pratt parsers in that if
 * the parser encounters an {@link Expression} with a precedence lower than
 * that which is allowed by the currently-parsed {@link Expression}, parsing
 * halts and what has been parsed so far is returned.
 * <br><br>
 * An {@link InfixParselet} is associated with a token that appears in the
 * <i>middle</i> of an expression being parsed.
 * <br><br>
 * <b>NOTE</b>: The {@link InfixParselet} is also used to support postfix
 * expressions, however, postfix operations are not a consideration in the
 * grammar of this project.
 * <br><br>
 * Write-up: <a href="http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/">http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/</a><br>
 * Taken from: <a href="https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/parselets/InfixParselet.java">https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/parselets/InfixParselet.java</a>
 */
public interface InfixParselet {
	Expression parse(Parser parse, Expression left, Token token);
	
	int getPrecedence();
}