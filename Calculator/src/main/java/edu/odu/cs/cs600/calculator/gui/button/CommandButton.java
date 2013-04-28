package edu.odu.cs.cs600.calculator.gui.button;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import edu.odu.cs.cs600.calculator.CalculatorCharacter;
import edu.odu.cs.cs600.calculator.CalculatorCommand;

/**
 * Class to represent a {@link CalculatorButton} which triggers a specific action/command
 */
public class CommandButton extends CalculatorButton {

	private static final long serialVersionUID = 7320338606786314438L;
	private CalculatorCommand command = null;
	
	
	/**
	 * Constructor for a CommandButton without an attributed keyboard key
	 * @param imageFilename filename of the image for use as the {@link ImageIcon} for this CommandButton
	 * @param imageOverFilename filename of the image for use as the {@link ImageIcon} for this CommandButton when hovered over
	 * @param command the {@link CalculatorCommand} to attribute to this CommandButton
	 */
	public CommandButton(String imageFilename, String imageOverFilename, CalculatorCommand command)
	{
		super(imageFilename, imageOverFilename);
		this.command = command;
	}
	
	
	/**
	 * Constructor for a CommandButton with an attributed keyboard key
	 * @param imageFilename filename of the image for use as the {@link ImageIcon} for this CommandButton
	 * @param imageOverFilename filename of the image for use as the {@link ImageIcon} for this CommandButton when hovered over
	 * @param command the {@link CalculatorCommand} to attribute to this CommandButton
	 * @param keyCode enumerated {@link KeyEvent} key code for the keyboard key to attribute to this CommandButton
	 */
	public CommandButton(String imageFilename, String imageOverFilename, CalculatorCommand command, int keyCode)
	{
		super(imageFilename, imageOverFilename, keyCode);
		this.command = command;
	}
	
	
	/**
	 * Constructor for a CommandButton with an attributed keyboard key and attributed {@link ActionListener}
	 * @param imageFilename filename of the image for use as the {@link ImageIcon} for this CommandButton
	 * @param imageOverFilename filename of the image for use as the {@link ImageIcon} for this CommandButton when hovered over
	 * @param command the {@link CalculatorCommand} to attribute to this CommandButton
	 * @param keyCode enumerated {@link KeyEvent} key code for the keyboard key to attribute to this CommandButton
	 * @param al the {@link ActionListener} to attribute to this CommandButton
	 */
	public CommandButton(String imageFilename, String imageOverFilename, CalculatorCommand command, int keyCode, ActionListener al) 
	{
		this(imageFilename, imageOverFilename, command, keyCode);
		addActionListener(al);
	}
	
	
	/**
	 * Return the {@link CalculatorCommand} attributed to this CommandButton
	 * @return
	 */
	public CalculatorCommand getCommand()
	{
		return this.command;
	}
}