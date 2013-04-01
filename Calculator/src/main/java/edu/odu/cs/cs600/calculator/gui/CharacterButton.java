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

public class CharacterButton extends CalculatorButton {
	
	private static final long serialVersionUID = 7293030709752505015L;
	
	private CalculatorCharacter cc;	

	public CharacterButton(String imageFilenamePath, char morpheme) {
		super(imageFilenamePath, String.valueOf(morpheme));
		
		cc = new CalculatorCharacter(morpheme);
		
		hookKeyInput(morpheme);
	}  // end constructor CharacterButton(String, char, CalculatorDisplay)
		
	
	public CalculatorCharacter getCalclatorCharacter() {
		return cc;
	}  // end getCalculatorCharacter()

}  // end class CharacterButton