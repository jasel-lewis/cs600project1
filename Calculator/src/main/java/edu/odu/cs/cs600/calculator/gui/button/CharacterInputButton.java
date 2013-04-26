package edu.odu.cs.cs600.calculator.gui.button;

import java.awt.event.ActionEvent;

import edu.odu.cs.cs600.calculator.CalculatorCharacter;

public class CharacterInputButton extends CalculatorButton 
{	
	private static final long serialVersionUID = 1L;
	
	private CalculatorCharacter calculatorInputCharacter;	

	public CharacterInputButton(String imagePath, String imageOverPath, CalculatorCharacter calculatorCharacter) 
	{
		super(imagePath, imageOverPath);
		
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