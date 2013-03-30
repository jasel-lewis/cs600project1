package edu.odu.cs.cs600.calculator.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ComponentInputMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ActionMapUIResource;

import edu.odu.cs.cs600.calculator.Application;

public class FunctionButton extends CalculatorButton {

	private static final long serialVersionUID = 7320338606786314438L;


	public FunctionButton(String imageFilenamePath, String fallbackText, int keyCode, ActionListener al) {
		super(imageFilenamePath, fallbackText);
		
		if (keyCode != KeyEvent.VK_UNDEFINED) {
			hookKeyInput(keyCode);
		}
		
		addActionListener(al);
	}  // end constructor FunctionButton(String, String, int, ActionListener)
	
	
	
	private void hookKeyInput(int keyCode) {
		InputMap keyMap = new ComponentInputMap(this);
		
		// TODO: Figure out why the fuck getFallbackText() got put in here
		keyMap.put(KeyStroke.getKeyStroke(keyCode, 0), this.getFallbackText());
		
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
}  // end class OperationButton