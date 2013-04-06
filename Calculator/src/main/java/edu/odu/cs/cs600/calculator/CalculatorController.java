package edu.odu.cs.cs600.calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import edu.odu.cs.cs600.calculator.gui.CalculatorView;
import edu.odu.cs.cs600.calculator.gui.button.CharacterInputButton;

public class CalculatorController {
	private CalculatorModel model = null;
	private CalculatorView view = null;
	
	public CalculatorController(CalculatorModel model, CalculatorView view)
	{
		this.model = model;
		this.view = view;
		
		this.initModelListeners();
		this.initViewListeners();		
	}
	
	/**
	 * Initializes listeners on properties of the model
	 */
	private void initModelListeners()
	{
		this.model.addStateChangeListener(new StateChangeListener());
		this.model.addPhraseChangeListener(new PhraseChangeListener());
	}
	
	/**
	 * Initializes listeners on properties of the view
	 */
	private void initViewListeners()
	{
		this.view.addCharacterInputButtonListener(new CharacterInputButtonActionListener());
		this.view.addMathematicalFunctionButtonListener(new MathematicalFunctionButtonActionListener());
	}
	
	private class CharacterInputButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof CharacterInputButton)
			{
				CharacterInputButton button = (CharacterInputButton)e.getSource();
				model.push(button.getCalclatorCharacter());
			}
		}
	}
	
	private class MathematicalFunctionButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	/**
	 * When the state of the calculator is turned on, the display is lit up
	 * and the display is zeroed out.  When turned off, the display is grayed out.
	 */
	private class StateChangeListener implements PropertyChangeListener
	{
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			boolean state = (Boolean)evt.getNewValue();
			if(state)
			{
				view.getDisplay().setForeground(Color.DARK_GRAY);
				model.clear();
			}
			else
			{
				view.getDisplay().setForeground(Color.LIGHT_GRAY);
				model.update();
			}
		}
	}
	
	
	
	/**
	 * When the state of the calculator is turned on, the display is lit up
	 * and the display is zeroed out.  When turned off, the display is grayed out.
	 */
	private class PhraseChangeListener implements PropertyChangeListener
	{
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			String phrase = (String)evt.getNewValue();
			view.updateDisplay(phrase);
		}
	}
}  // end class CalculatorController
