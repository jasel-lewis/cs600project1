package edu.odu.cs.cs600.calculator.gui.button;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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