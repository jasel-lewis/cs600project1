package edu.odu.cs.cs600.calculator.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ApplicationFrame extends JFrame 
{

	private static final long serialVersionUID = 1L;

	public ApplicationFrame()
	{
		super("Calculator");
		
		// Set defaults
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
		
		//Add the ubiquitous "Hello World" label.       
		JLabel label = new JLabel("Hello World");        
		this.getContentPane().add(label);
	}

}
