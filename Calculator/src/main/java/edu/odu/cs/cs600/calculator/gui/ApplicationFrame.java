package edu.odu.cs.cs600.calculator.gui;

import javax.swing.JFrame;

public class ApplicationFrame extends JFrame 
{

	private static final long serialVersionUID = 1L;

	public ApplicationFrame()
	{
		super("Calculator");
		
		// Set defaults
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
		
		this.setContentPane(new CalculatorPanel());
		
		this.setResizable(false);
	}
}