package edu.odu.cs.cs600.calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InvalidClassException;

import edu.odu.cs.cs600.calculator.gui.CalculatorView;
import edu.odu.cs.cs600.calculator.gui.button.CharacterInputButton;
import edu.odu.cs.cs600.calculator.gui.button.CommandButton;

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
		this.view.addCommandButtonListener(new CommandButtonActionListener());
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
	
	private class CommandButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() instanceof CommandButton)
			{
				CalculatorCommand command = ((CommandButton)e.getSource()).getCommand();
				switch(command)
				{
					// ***********************
					//   Functional Commands
					// ***********************
					case CLEAR:
						break;
					case CLEAR_ALL:
						break;
					case POWERON:
						break;
					case POWEROFF:
						break;
						
					// ***********************
					//  Mathematical Commands
					// ***********************
					case CEILING:
						break;
					case EVALUATE:
						break;
					case FLOOR:
						break;
					case NEGATE:
						break;
					case RECIPROCAL:
						break;
					case SQUAREROOT:
						break;
					default:
						break;
				};
			}
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
