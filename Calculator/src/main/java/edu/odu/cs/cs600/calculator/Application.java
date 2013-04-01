package edu.odu.cs.cs600.calculator;

import edu.odu.cs.cs600.calculator.gui.CalculatorView;

public class Application {
	public static final boolean debug = true;  // Set the debug mode
	private static final CalculatorModel model = new CalculatorModel();

	public static void main(String[] args) {
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
}  // end class Application