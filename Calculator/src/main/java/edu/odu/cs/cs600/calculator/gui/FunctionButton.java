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

	public FunctionButton(String imageFilenamePath, String fallbackText, int keyCode)
	{
		super(imageFilenamePath, fallbackText);
		
		if (keyCode != KeyEvent.VK_UNDEFINED) {
			this.hookKeyInput(keyCode);
		}
	}
	
	public FunctionButton(String imageFilenamePath, String fallbackText, int keyCode, ActionListener al) 
	{
		this(imageFilenamePath, fallbackText, keyCode);
		addActionListener(al);
	}
	
}  // end class OperationButton