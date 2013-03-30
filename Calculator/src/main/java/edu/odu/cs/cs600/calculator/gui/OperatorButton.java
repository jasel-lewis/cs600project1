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
	
	
	public OperatorButton(String imageFilenamePath, String fallbackText, char morpheme, CalculatorDisplay display) {
		super(imageFilenamePath, fallbackText);
		
		cc = new CalculatorCharacter(morpheme, fallbackText);
		this.display = display;
		
		hookKeyInput(morpheme);
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (Application.isOn()) {
					OperatorButton ob = (OperatorButton)ae.getSource();
					ob.getDisplay().push(ob.getDisplayCharacter());
					//display.push(((CharacterButton)ae.getSource()).getMorpheme());
				}
			}
		});
	}  // end constructor CharacterButton(String, String, char, CalculatorDisplay)



	private void hookKeyInput(char character) {
		InputMap keyMap = new ComponentInputMap(this);
		
		// TODO: Figure out why the fuck getFallbackText() got put in here
		keyMap.put(KeyStroke.getKeyStroke(character), this.getFallbackText());
		
		ActionMap actionMap = new ActionMapUIResource();
		actionMap.put(this.getFallbackText(), new AbstractAction() {
			private static final long serialVersionUID = 303540849078642457L;

			public void actionPerformed(ActionEvent ae) {
				if (Application.debug) {
					System.err.println("ActionEvent: " + ae);
				}
				((CalculatorButton)ae.getSource()).doClick();
			}
		});
		
		SwingUtilities.replaceUIActionMap(this,  actionMap);
		SwingUtilities.replaceUIInputMap(this, JComponent.WHEN_IN_FOCUSED_WINDOW, keyMap);
	}  // end hookKeyInput(char)
	
	
	
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