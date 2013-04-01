package edu.odu.cs.cs600.calculator.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ComponentInputMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ActionMapUIResource;

import edu.odu.cs.cs600.calculator.Application;

public class OperatorButton extends CalculatorButton {
	
	private static final long serialVersionUID = 7293030709752505015L;
	
	private CalculatorCharacter cc;
	private CalculatorDisplay display;
	
	
	public OperatorButton(String imageFilenamePath, String fallbackText, char morpheme) {
		super(imageFilenamePath, fallbackText);
		
		cc = new CalculatorCharacter(morpheme, fallbackText);
		
		hookKeyInput(morpheme);
	}  // end constructor CharacterButton(String, String, char, CalculatorDisplay)
	
	public CalculatorCharacter getDisplayCharacter() {
		return cc;
	}  // end getCalculatorCharacter()
	

	/**
	 * Return the {@link CalculatorDisplay} assigned to this button
	 * @return
	 */
	public CalculatorDisplay getDisplay() {
		return display;
	}  // end getDisplay()
}  // end class CharacterButton