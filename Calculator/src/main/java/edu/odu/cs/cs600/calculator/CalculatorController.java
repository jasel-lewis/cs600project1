package edu.odu.cs.cs600.calculator;

import edu.odu.cs.cs600.calculator.gui.CalculatorView;

public class CalculatorController {
	
	private CalculatorModel model = null;
	private CalculatorView view = null;
	
	public CalculatorController(CalculatorModel model, CalculatorView view)
	{
		this.model = model;
		this.view = view;
		
		this.initListeners();
	}
	
	private void initListeners()
	{
		
	}
	
}