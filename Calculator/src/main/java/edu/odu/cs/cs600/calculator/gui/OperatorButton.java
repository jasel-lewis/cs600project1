package edu.odu.cs.cs600.calculator.gui;

public class OperatorButton extends CalculatorButton {
	
	private static final long serialVersionUID = 7293030709752505015L;
	
	private CalculatorCharacter cc;
	
	
	public OperatorButton(String imageFilenamePath, String fallbackText, char morpheme) {
		super(imageFilenamePath, fallbackText);
		
		cc = new CalculatorCharacter(morpheme, fallbackText);
		
		hookKeyInput(morpheme);
	}  // end constructor CharacterButton(String, String, char, CalculatorDisplay)
	
	public CalculatorCharacter getDisplayCharacter() {
		return cc;
	}  // end getCalculatorCharacter()
}  // end class CharacterButton