package edu.odu.cs.cs600.calculator.gui.button;

import java.awt.event.ActionListener;
import edu.odu.cs.cs600.calculator.CalculatorCommand;

public class CommandButton extends CalculatorButton {

	private static final long serialVersionUID = 7320338606786314438L;
	private CalculatorCommand command = null;
	
	public CommandButton(String imagePath, String imageOverPath, CalculatorCommand command)
	{
		super(imagePath, imageOverPath);
		this.command = command;
	}

	public CommandButton(String imagePath, String imageOverPath, CalculatorCommand command, int keyCode)
	{
		super(imagePath, imageOverPath, keyCode);
		this.command = command;
	}
	
	public CommandButton(String imagePath, String imageOverPath, CalculatorCommand command, int keyCode, ActionListener al) 
	{
		this(imagePath, imageOverPath, command, keyCode);
		addActionListener(al);
	}
	
	public CalculatorCommand getCommand()
	{
		return this.command;
	}
	
}