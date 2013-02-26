package edu.odu.cs.cs600.calculator;

import edu.odu.cs.cs600.calculator.gui.ApplicationFrame;

public class Application 
{

	public static void main(String[] args) 
	{
		// Schedule a job for the event-dispatching thread:        
		// creating and showing this application's GUI.        
		javax.swing.SwingUtilities.invokeLater(new Runnable() {            
			public void run() {                
				ApplicationFrame appFrame = new ApplicationFrame();
				appFrame.pack();
				appFrame.setVisible(true);
			}        
		});
	}

}
