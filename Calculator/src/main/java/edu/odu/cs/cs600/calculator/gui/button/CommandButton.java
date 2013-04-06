package edu.odu.cs.cs600.calculator.gui.button;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class CommandButton extends CalculatorButton {

	private static final long serialVersionUID = 7320338606786314438L;
	
	public CommandButton(String imageFilenamePath, String fallbackText)
	{
		super(imageFilenamePath, fallbackText);
	}

	public CommandButton(String imageFilenamePath, String fallbackText, int keyCode)
	{
		super(imageFilenamePath, fallbackText, keyCode);
	}
	
	public CommandButton(String imageFilenamePath, String fallbackText, int keyCode, ActionListener al) 
	{
		this(imageFilenamePath, fallbackText, keyCode);
		addActionListener(al);
	}
	
}  // end class OperationButton