package edu.odu.cs.cs600.calculator.gui;

import javax.swing.JFrame;

import edu.odu.cs.cs600.calculator.Phrase;

public class ApplicationFrame extends JFrame 
{

	private static final long serialVersionUID = 1L;

	public ApplicationFrame(Phrase phrase)
	{
		super("Calculator");
		
		// Set defaults
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
		
		this.setContentPane(new CalculatorPanel(phrase, this.getRootPane()));
		
		this.setResizable(false);
	}
}