package edu.odu.cs.cs600.calculator.gui.button;

import java.awt.event.ActionListener;
import edu.odu.cs.cs600.calculator.CalculatorCommand;

public class CommandButton extends CalculatorButton {

	private static final long serialVersionUID = 7320338606786314438L;
	private CalculatorCommand command = null;
	
	public CommandButton(String imageFilenamePath, String altText, CalculatorCommand command)
	{
		super(imageFilenamePath, altText);
		this.command = command;
	}

	public CommandButton(String imageFilenamePath, String fallbackText, CalculatorCommand command, int keyCode)
	{
		super(imageFilenamePath, fallbackText, keyCode);
		this.command = command;
	}
	
	public CommandButton(String imageFilenamePath, String fallbackText, CalculatorCommand command, int keyCode, ActionListener al) 
	{
		this(imageFilenamePath, fallbackText, command, keyCode);
		addActionListener(al);
	}
	
	public CalculatorCommand getCommand()
	{
		return this.command;
	}
	
}