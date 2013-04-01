package edu.odu.cs.cs600.calculator;

import edu.odu.cs.cs600.calculator.gui.CalculatorView;

public class Application 
{
	
	public static boolean state = true;  // true: calculator is "on"; false: "off"
	public static final boolean debug = true;  // Set the debug mode

	public static void main(String[] args) 
	{
		// Schedule a job for the event-dispatching thread:        
		// creating and showing this application's GUI.        
		javax.swing.SwingUtilities.invokeLater(new Runnable() {            
			public void run() {
				
				CalculatorModel model = new CalculatorModel();
				CalculatorView view = new CalculatorView(model);
				CalculatorController controller = new CalculatorController(model, view);
				
				view.setVisible(true);
			}        
		});
	}
	
	
	
	/**
	 * Put the calculator into an "off" state
	 */
	public static void off() {
		state = false;
	}
	
	
	
	/**
	 * Put the calculator into an "on" state
	 */
	public static void on() {
		state = true;
	}



	/**
	 * Returns true if the calculator is in an "on" state, false otherwise
	 * @return
	 */
	public static boolean isOn() {
		return state;
	}
}