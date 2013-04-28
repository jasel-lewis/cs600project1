package edu.odu.cs.cs600.calculator;

import edu.odu.cs.cs600.calculator.gui.CalculatorView;

/**
 * Represents entry-point to the Calculator application.  This application
 * has been developed using an MVC design pattern.  In the main, the
 * primary controller, model, and views are instantiated and wired together.
 * The image below shows a diagram of the interactions between the model,
 * view, and controller.
 * <img alt="" src="doc-files/mvc.gif" />
 */
public class Application {
	
	public static final boolean debug = true;  // Set the debug mode

	public static void main(String[] args) {		
		
		// Schedule a job for the event-dispatching thread:        
		// creating and showing this application's GUI.        
		javax.swing.SwingUtilities.invokeLater(new Runnable() {            
			public void run() {
				CalculatorModel model = new CalculatorModel();
				CalculatorView view = new CalculatorView();
				
				@SuppressWarnings("unused")
				CalculatorController controller = new CalculatorController(model, view);
				
				view.setVisible(true);
			}        
		});
	}
}
