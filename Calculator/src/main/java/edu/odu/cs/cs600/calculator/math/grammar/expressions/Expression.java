package edu.odu.cs.cs600.calculator.math.grammar.expressions;

/**
 * Taken from: https://github.com/munificent/bantam/blob/master/src/com/stuffwithstuff/bantam/expressions/Expression.java
 * Write-up: http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/
 */
public interface Expression {
	void print(StringBuilder builder);
}