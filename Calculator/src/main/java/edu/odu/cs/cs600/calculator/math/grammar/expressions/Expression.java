package edu.odu.cs.cs600.calculator.math.grammar.expressions;

/**
 * General interface for an {@link Expression}
 * <br><br>
 * Taken from: <a href="https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/Expression.java">https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/Expression.java</a><br>
 * Write-up: <a href="http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/">http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/</a>
 */
public interface Expression {
	public double getValue();
}