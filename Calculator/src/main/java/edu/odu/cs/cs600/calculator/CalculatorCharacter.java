package edu.odu.cs.cs600.calculator;

/**
 * Class to encapsulate a character.  There are certain characters which appear
 * in the Calculator's display as Unicode glyphs, however, a consistent and
 * comparable (character-comparable) representation (morpheme) must be
 * represented within the {@link Phrase}.  A {@link CharacterInputButton} may
 * also utilize the Unicode glyph as a fall-back if the button's image fails to
 * load.
 */
public class CalculatorCharacter {
	private char morpheme;
	private String isoRepresentation;
	private boolean hasISORepresentation = false;
	
	
	/**
	 * Constructor for a CalculatorCharacter that is acceptable to be displayed
	 * using its normal, printable ASCII character representation
	 * @param morpheme printable, ASCII character
	 */
	public CalculatorCharacter(char morpheme) {
		this.morpheme = morpheme;
		this.isoRepresentation = String.valueOf(morpheme);
	}
	
	
	/**
	 * Constructor for a CalculatorCharacter which could be displayed better
	 * using a Unicode glyph
	 * @param morpheme printable, ASCII character
	 * @param isoRepresentation Unicode glyph
	 */
	public CalculatorCharacter(char morpheme, String isoRepresentation) {
		this.morpheme = morpheme;
		this.isoRepresentation = isoRepresentation;
		hasISORepresentation = true;
	}
	
	
	/**
	 * Return the printable, ASCII character representation of this CalculatorCharacter
	 * @return
	 */
	public char getMorpheme() {
		return morpheme;
	}
	
	
	/**
	 * Return the Unicode glyph of this CalculatorCharacter
	 * @return
	 */
	public String getISORepresentation() {
		return isoRepresentation;
	}
	
	
	/**
	 * True if this CalculatorCharacter has a Unicode glyph attributed to it.  False
	 * if not.
	 * @return
	 */
	public boolean requiresISORepresentation() {
		return hasISORepresentation;
	}
	
	
	/**
	 * True if the printable, ASCII representation of this CalculatorCharacter matches
	 * that of the passed character.  False if not.
	 * @param morpheme character to compare
	 * @return
	 */
	public boolean equalsMorpheme(char morpheme) {
		return(this.morpheme == morpheme);
	}
	
	
	/**
	 * String representation of the single, printable, ASCII representation of this
	 * CalculatorCharacter
	 * @return
	 */
	@Override
	public String toString() {
		return String.valueOf(this.morpheme); 
	}
}