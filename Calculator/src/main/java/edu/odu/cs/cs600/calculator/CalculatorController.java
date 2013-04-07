package edu.odu.cs.cs600.calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InvalidClassException;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.odu.cs.cs600.calculator.grammar.Phrase;
import edu.odu.cs.cs600.calculator.gui.CalculatorView;
import edu.odu.cs.cs600.calculator.gui.button.CharacterInputButton;
import edu.odu.cs.cs600.calculator.gui.button.CommandButton;
import edu.odu.cs.cs600.calculator.math.MathUtil;
import edu.odu.cs.cs600.calculator.math.parser.Parser;

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
		this.view.addPhraseChangeListener(new PhraseChangeListener());
	}
	
	
	
	private class PhraseChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			view.setDisplay(model.getPhrase().getPhrase(true));
		}
	}
	
	
	
	private class CharacterInputButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof CharacterInputButton)
			{
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
						break;
					case CLEAR_ALL:
						break;
					case POWERON:
						break;
					case POWEROFF:
						break;
	
					// ***********************
					// Mathematical Commands
					// ***********************
					case CEILING:
					{
						try {
							double result = Parser.evaluate(model.getPhrase().getPhrase(false));
							result = MathUtil.ceiling(result);
							model.getPhrase().setPhrase(model.getPhrase().convertToPhrase(String.valueOf(result)));
						} catch(Exception ex) {
							// TODO - do something w/ this!
							System.err.println(ex);
						}
	
						break;
					}
					case EVALUATE:
					{
						double result = Parser.evaluate(model.getPhrase().getPhrase(false));
						model.getPhrase().setPhrase(model.getPhrase().convertToPhrase(String.valueOf(result)));
						break;
					}
					case FLOOR:
					{
						try {
							double result = Parser.evaluate(model.getPhrase().getPhrase(false));
							result = MathUtil.floor(result);
							model.getPhrase().setPhrase(model.getPhrase().convertToPhrase(String.valueOf(result)));
						} catch(Exception ex) {
							// TODO - do somethign w/ this!
							System.err.println(ex);
						}
						break;
					}
					case NEGATE:
					{
						try {
							double result = Parser.evaluate(model.getPhrase().getPhrase(false));
							result = MathUtil.negate(result);
							model.getPhrase().setPhrase(model.getPhrase().convertToPhrase(String.valueOf(result)));
						} catch(Exception ex) {
							// TODO - do somethign w/ this!
							System.err.println(ex);
						}
						break;
					}
					case RECIPROCAL:
					{
						try {
							double result = Parser.evaluate(model.getPhrase().getPhrase(false));
							result = MathUtil.reciprocal(result);
							model.getPhrase().setPhrase(model.getPhrase().convertToPhrase(String.valueOf(result)));
						} catch(Exception ex) {
							// TODO - do somethign w/ this!
							System.err.println(ex);
						}
						break;
					}
					case SQUAREROOT:
					{
						try {
							double result = Parser.evaluate(model.getPhrase().getPhrase(false));
							result = MathUtil.squareRoot(result);
							model.getPhrase().setPhrase(model.getPhrase().convertToPhrase(String.valueOf(result)));
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
	
	
	
	/**
	 * When the Phrase is changed, have the view update its display
	 */
//	private class PhraseChangeListener implements PropertyChangeListener
//	{
//		@Override
//		public void propertyChange(PropertyChangeEvent evt) {
//			String phrase = (String)evt.getNewValue();
//			view.setDisplay(phrase.getPhrase(true));
//		}
//	}
} 
