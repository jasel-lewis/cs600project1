package edu.odu.cs.cs600.calculator.gui.button;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import edu.odu.cs.cs600.calculator.CalculatorCharacter;

/**
 * Class to represent a {@link CalculatorButton} which provides {@link CalculatorCharacter}
 * input to the current (non-historical) {@Phrase}
 */
public class CharacterInputButton extends CalculatorButton 
{	
	private static final long serialVersionUID = 1L;
	
	private CalculatorCharacter calculatorInputCharacter;	
	
	
	/**
	 * Constructor
	 * @param imageFilename filename of the image for use as the {@link ImageIcon} for this CharacterInputButton
	 * @param imageOverFilename filename of the image for use as the {@link ImageIcon} for this CharacterInputButton when hovered over
	 * @param calculatorCharacter the {@link CalculatorCharacter} to attribute to this CharacterInputButton
	 */
	public CharacterInputButton(String imageFilename, String imageOverFilename, CalculatorCharacter calculatorCharacter) 
	{
		super(imageFilename, imageOverFilename);
		
		this.calculatorInputCharacter = calculatorCharacter;
		
		hookKeyInput(this.calculatorInputCharacter.getMorpheme());
	} 
	
	
	/**
	 * Return the {@link CalculatorCharacter} attributed to this CharacterInputButton
	 * @return
	 */
	public CalculatorCharacter getCalclatorCharacter() 
	{
		return calculatorInputCharacter;
	}
	
	
	/**
	 * Trigger the passed {@link ActionEvent} on this CharacterInputButton
	 */
	@Override
	protected void fireActionPerformed(ActionEvent event) {
		super.fireActionPerformed(event);
	}	
}