package edu.odu.cs.cs600.calculator.math.grammar.parselet;

import edu.odu.cs.cs600.calculator.math.grammar.Expression;
import edu.odu.cs.cs600.calculator.math.grammar.Parser;
import edu.odu.cs.cs600.calculator.math.grammar.Token;

/**
 * Interface for a parselet which allows for infix operators ("a + b").  The
 * getPrecedence() function is part of the magic of Pratt parsers in that if
 * the parser encounters an {@link Expression} with a precedence lower than
 * that which is allowed by the currently-parsed {@link Expression}, parsing
 * halts and what has been parsed so far is returned.
 * 
 * An InfixParselet is associated with a token that appears in the _middle_
 * of an expression it parses.
 * 
 * NOTE: This is also used for postfix expressions, albeit we do not plan for
 * any such functionality in our simple calculator grammar.
 * 
 * Write-up: http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/parselets/InfixParselet.java
 */
public interface InfixParselet {
	Expression parse(Parser parse, Expression left, Token token);
	
	int getPrecedence();
}