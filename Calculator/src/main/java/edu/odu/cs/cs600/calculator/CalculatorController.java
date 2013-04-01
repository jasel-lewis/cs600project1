package edu.odu.cs.cs600.calculator;

import java.awt.Color;
import java.util.ArrayList;

import edu.odu.cs.cs600.calculator.gui.CalculatorCharacter;
import edu.odu.cs.cs600.calculator.gui.CalculatorView;

public class CalculatorController {
	private CalculatorModel model = null;
	private CalculatorView view = null;
	
	public CalculatorController(CalculatorModel model, CalculatorView view)
	{
		this.model = model;
		this.view = view;
	}
	
	
	/**
	 * Place this CalculatorDisplay into the "on" isOn for the calculator.  Functionality
	 * is the same as what {@link #clear() clear()} performs.
	 */
	public void onState() {
		view.getDisplay().setForeground(Color.DARK_GRAY);
		model.clear();
	}  // end onState()
	
	
	
	/**
	 * Place this CalculatorDisplay into the "off" isOn for the calculator.  The
	 * phrase is emptied of all characters and the display is updated with such
	 * (presenting the user with a blank display).
	 */
	public void offState() {
		view.getDisplay().setForeground(Color.LIGHT_GRAY);
		model.update();
	}  // end offState()
}  // end class CalculatorController