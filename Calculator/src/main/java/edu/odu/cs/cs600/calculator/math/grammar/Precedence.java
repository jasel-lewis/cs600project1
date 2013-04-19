package edu.odu.cs.cs600.calculator.math.grammar;

/**
 * Precedence is part of the magic of Pratt parsers.  This class captures
 * the weighting of each operation.
 * 
 * Write-up: http://journal.stuffwithstuff.com/2011/03/19/pratt-parsers-expression-parsing-made-easy/
 */
public final class Precedence {
	public static final int SUM = 1;
	public static final int PRODUCT = 2;
	public static final int EXPONENT = 3;
	public static final int PREFIX = 4;
	public static final int POSTFIX = 5;
}