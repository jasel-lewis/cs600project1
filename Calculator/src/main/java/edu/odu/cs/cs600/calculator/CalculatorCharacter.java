package edu.odu.cs.cs600.calculator;

public class CalculatorCharacter {
	private char morpheme;
	private String isoRepresentation;
	private boolean hasISORepresentation = false;
	
	
	public CalculatorCharacter(char morpheme) {
		this.morpheme = morpheme;
		this.isoRepresentation = String.valueOf(morpheme);
	}
	
	public CalculatorCharacter(char morpheme, String isoRepresentation) {
		this.morpheme = morpheme;
		this.isoRepresentation = isoRepresentation;
		hasISORepresentation = true;
	}
	
	
	
	public char getMorpheme() {
		return morpheme;
	}
	
	
	
	public String getISORepresentation() {
		return isoRepresentation;
	}



	public boolean requiresISORepresentation() {
		return hasISORepresentation;
	}



	public boolean equalsMorpheme(char morpheme) {
		return(this.morpheme == morpheme);
	}
}  // end class CalculatorCharacter