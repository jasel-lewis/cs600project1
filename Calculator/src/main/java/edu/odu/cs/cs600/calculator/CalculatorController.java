package edu.odu.cs.cs600.calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.odu.cs.cs600.calculator.gui.CalculatorView;
import edu.odu.cs.cs600.calculator.gui.button.CharacterInputButton;
import edu.odu.cs.cs600.calculator.gui.button.CommandButton;

public class CalculatorController 
{
	private CalculatorModel model = null;
	private CalculatorView view = null;
	
	public CalculatorController(CalculatorModel model, CalculatorView view)
	{
		this.model = model;
		this.view = view;
		
		this.initModelListeners();
		this.initViewListeners();
		this.initPhraseListeners();
	}
	
	/**
	 * Initializes listeners on properties of the model
	 */
	private void initModelListeners()
	{
		this.model.addStateChangeListener(new StateChangeListener());
	}
	
	/**
	 * Initializes listeners on properties of the view
	 */
	private void initViewListeners()
	{
		this.view.addCharacterInputButtonListener(new CharacterInputButtonActionListener());
		this.view.addCommandButtonListener(new CommandButtonActionListener());
	}
	
	
	
	private void initPhraseListeners() {
		this.model.getPhrase().addChangeListener(new PhraseChangeListener());
	}
	
	
	
	private class PhraseChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			view.setDisplay(model.getPhrase().getPhrase(true));
		}
	}
	
	
	
	private class CharacterInputButtonActionListener implements ActionListener
	{
		// TODO : Check flag to see if the input needs to be cleared before adding the input to the phrase
		// TODO : Replace System.out calls w/ Logger calls
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof CharacterInputButton)
			{
				System.out.println("Character button pressed");
				CharacterInputButton button = (CharacterInputButton)e.getSource();
				model.getPhrase().push(button.getCalclatorCharacter());
			}
		}
	}
	

	private class CommandButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Command button pressed");
			if(e.getSource() instanceof CommandButton)
			{
				CalculatorCommand command = ((CommandButton)e.getSource()).getCommand();
				switch(command)
				{
					// ***********************
					// Functional Commands
					// ***********************
					case CLEAR:
						model.getPhrase().pop();
						break;
					case CLEAR_ALL:
						model.getPhrase().clear();
						break;
	
					// ***********************
					// Mathematical Commands
					// ***********************
					// TODO : Set a flag so that when next key entry, the display is cleared
					case CEILING:
					{
						try {
//							double result = Parser.parse(model.getPhrase().getPhrase(false));
//							result = MathUtil.ceiling(result);
//							model.getPhrase().setPhrase(model.getPhrase().convertToPhrase(String.valueOf(result)));
						} catch(Exception ex) {
							// TODO - do something w/ this!
							System.err.println(ex);
						}
	
						break;
					}
					case EVALUATE:
					{
//						double result = Parser.parse(model.getPhrase().getPhrase(false));
//						model.getPhrase().setPhrase(model.getPhrase().convertToPhrase(String.valueOf(result)));
						break;
					}
					case FLOOR:
					{
						try {
//							double result = Parser.parse(model.getPhrase().getPhrase(false));
//							result = MathUtil.floor(result);
//							model.getPhrase().setPhrase(model.getPhrase().convertToPhrase(String.valueOf(result)));
						} catch(Exception ex) {
							// TODO - JS do somethign w/ this!
							System.err.println(ex);
						}
						break;
					}
					case NEGATE:
					{
						try {
//							double result = Parser.parse(model.getPhrase().getPhrase(false));
//							result = MathUtil.negate(result);
//							model.getPhrase().setPhrase(model.getPhrase().convertToPhrase(String.valueOf(result)));
						} catch(Exception ex) {
							// TODO - JS do somethign w/ this!
							System.err.println(ex);
						}
						break;
					}
					case RECIPROCAL:
					{
						try {
//							double result = Parser.parse(model.getPhrase().getPhrase(false));
//							result = MathUtil.reciprocal(result);
//							model.getPhrase().setPhrase(model.getPhrase().convertToPhrase(String.valueOf(result)));
						} catch(Exception ex) {
							// TODO - do somethign w/ this!
							System.err.println(ex);
						}
						break;
					}
					case SQUAREROOT:
					{
						try {
//							double result = Parser.parse(model.getPhrase().getPhrase(false));
//							result = MathUtil.squareRoot(result);
//							model.getPhrase().setPhrase(model.getPhrase().convertToPhrase(String.valueOf(result)));
						} catch(Exception ex) {
							// TODO - do somethign w/ this!
							System.err.println(ex);
						}
						break;
					}
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
				model.getPhrase().clear();
			}
			else
			{
				view.getDisplay().setForeground(Color.LIGHT_GRAY);
				model.getPhrase().setOffState();
			}
		}
	}
} 
