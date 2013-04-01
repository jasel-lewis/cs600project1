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
	private CalculatorDisplay display;
	

	public CharacterButton(String imageFilenamePath, char morpheme, CalculatorDisplay display) {
		super(imageFilenamePath, String.valueOf(morpheme));
		
		cc = new CalculatorCharacter(morpheme);
		
		this.display = display;
		
		hookKeyInput(morpheme);
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (Application.isOn()) {
					CharacterButton cb = (CharacterButton)ae.getSource();
					cb.getDisplay().push(cb.getCalclatorCharacter());
					//display.push(((CharacterButton)ae.getSource()).getMorpheme());
				}
			}
		});
	}  // end constructor CharacterButton(String, char, CalculatorDisplay)
		
	
	public CalculatorCharacter getCalclatorCharacter() {
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