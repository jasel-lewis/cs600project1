package edu.odu.cs.cs600.calculator.gui.button;

import java.awt.event.ActionListener;
import edu.odu.cs.cs600.calculator.CalculatorCommand;

public class CommandButton extends CalculatorButton {

	private static final long serialVersionUID = 7320338606786314438L;
	private CalculatorCommand command = null;
	
	public CommandButton(String imagePath, String imageOverPath, String altText, CalculatorCommand command)
	{
		super(imagePath, imageOverPath, altText);
		this.command = command;
	}

	public CommandButton(String imagePath, String imageOverPath, String altText, CalculatorCommand command, int keyCode)
	{
		super(imagePath, imageOverPath, altText, keyCode);
		this.command = command;
	}
	
	public CommandButton(String imagePath, String imageOverPath, String altText, CalculatorCommand command, int keyCode, ActionListener al) 
	{
		this(imagePath, imageOverPath, altText, command, keyCode);
		addActionListener(al);
	}
	
	public CalculatorCommand getCommand()
	{
		return this.command;
	}
	
}