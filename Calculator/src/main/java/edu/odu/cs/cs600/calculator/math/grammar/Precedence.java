package edu.odu.cs.cs600.calculator.math.grammar;

/**
 * Precedence is part of the magic of <a href="http://en.wikipedia.org/wiki/Pratt_parser">Pratt parsers</a>.  This class captures the
 * weighting of each operation which determines the order in which expressions are evaluated.
 * <br><br>
 * Write-up: <a href="http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/">http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/</a>
 */
public final class Precedence {
	public static final int SUM = 1;
	public static final int PRODUCT = 2;
	public static final int EXPONENT = 3;
	public static final int PREFIX = 4;
	public static final int POSTFIX = 5;
}