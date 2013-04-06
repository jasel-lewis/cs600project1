package edu.odu.cs.cs600.calculator.gui.button;

import java.awt.event.ActionEvent;

import edu.odu.cs.cs600.calculator.gui.CalculatorCharacter;

public class CharacterInputButton extends CalculatorButton 
{	
	private CalculatorCharacter calculatorInputCharacter;	

	public CharacterInputButton(String imageFilenamePath, CalculatorCharacter calculatorCharacter) 
	{
		super(imageFilenamePath, String.valueOf(calculatorCharacter.getMorpheme()));
		
		this.calculatorInputCharacter = calculatorCharacter;
		
		hookKeyInput(this.calculatorInputCharacter.getMorpheme());
	} 
		
	public CalculatorCharacter getCalclatorCharacter() 
	{
		return calculatorInputCharacter;
	}

	@Override
	protected void fireActionPerformed(ActionEvent event) {
		super.fireActionPerformed(event);
	} 
	
	
}