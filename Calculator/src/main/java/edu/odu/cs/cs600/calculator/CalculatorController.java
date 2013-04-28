package edu.odu.cs.cs600.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.odu.cs.cs600.calculator.gui.CalculatorView;
import edu.odu.cs.cs600.calculator.gui.button.CharacterInputButton;
import edu.odu.cs.cs600.calculator.gui.button.CommandButton;
import edu.odu.cs.cs600.calculator.math.MathUtil;
import edu.odu.cs.cs600.calculator.math.grammar.Phrase;
import edu.odu.cs.cs600.calculator.math.grammar.PhraseChangedListener;
import edu.odu.cs.cs600.calculator.math.grammar.SimpleCalculatorParser;

/**
 * This class is the Controller of the MVC framework employed for this project.  The controllers purpose
 * is to respond to various UI events, manage the "logic" of what happens based on UI events, and effectively
 * "control" the data flow between the UI and the model.
 */
public class CalculatorController 
{
	private static Logger logger = LogManager.getLogger(CalculatorController.class);
	
	private CalculatorModel model = null;
	private CalculatorView view = null;
	
	/**
	 * Constructor method accepting the model and the view
	 * @param model
	 * @param view
	 */
	public CalculatorController(CalculatorModel model, CalculatorView view)
	{
		this.model = model;
		this.view = view;
		
		this.initModelListeners();
		this.initViewListeners();
		
		this.model.getActivePhrase().clear();
	}
	
	
	/**
	 * Initializes listeners on properties of the model
	 */
	private void initModelListeners()
	{
		this.model.addErrorStateChangedListener(new ModelErrorStateChangedListener());
		this.model.addActivePhraseChangedListener(new ModelActivePhraseChangeListener());
		this.model.addLastPhraseChangedListener(new ModelLastPhraseChangeListener());
	}
	
	
	/**
	 * Initializes listeners on properties of the view
	 */
	private void initViewListeners()
	{
		this.view.addCharacterInputButtonListener(new CharacterInputButtonActionListener());
		this.view.addCommandButtonListener(new CommandButtonActionListener());
	}	
	
	
	/**
	 * Class for the {@link CalculatorModel} to recognize an error state.  Class is
	 * private to the scope of {@link CalclatorController}.
	 */
	private class ModelErrorStateChangedListener implements ErrorStateChangedListener
	{
		@Override
		public void errorStateChanged(boolean errorState) {
			view.setHistoryDisplayText("");
			if(errorState) {
				view.setActiveDisplayText("Error");
			} else {
				view.setActiveDisplayText(model.getActivePhrase().toString(true));
			}
		}
	}
	
	
	/**
	 * Class for the {@link CalculatorModel} to recognize a change to the current
	 * (non-historical) {@link Phrase}.  Class is private to the scope of
	 * {@link CalculatorController}.
	 */
	private class ModelActivePhraseChangeListener implements PhraseChangedListener {
		@Override
		public void phraseChanged(Phrase phrase) {
			view.setActiveDisplayText(String.format(phrase.toString(true),"%g"));
		}
	}
	
	
	/**
	 * Class for the {@link CalculatorModel} to recognize a change to the {@link Phrase}
	 * representing the historical Phrase entries.  Class is private to the scope of
	 * {@link CalculatorController}.
	 */
	private class ModelLastPhraseChangeListener implements PhraseChangedListener {
		@Override
		public void phraseChanged(Phrase phrase) {
			if(phrase.toString(false).equals("0"))
				view.setHistoryDisplayText("");
			else
				view.setHistoryDisplayText(phrase.toString(true));
		}
	}
	
	
	/**
	 * Class for the {@link CalculatorModel} to recognize input from the press of a
	 * {@link CharacterInputButton} press.  Class is private to the scope of
	 * {@link CalculatorController}. 
	 */
	private class CharacterInputButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!model.getErrorState())
			{
				if(e.getSource() instanceof CharacterInputButton)
				{
					CharacterInputButton button = (CharacterInputButton)e.getSource();
					model.getActivePhrase().push(button.getCalclatorCharacter());
					logger.debug("Character button pressed: " + button.getCalclatorCharacter());
				}
			}
		}
	}
	
	
	/**
	 * Class for the {@link CalculatorModel} to recognize input from the press of a
	 * {@link CommandButton} press.  Class is private to the scope of
	 * {@link CalculatorController}. 
	 */
	private class CommandButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() instanceof CommandButton)
			{
				CalculatorCommand command = ((CommandButton)e.getSource()).getCommand();
				
				logger.debug("Command button pressed: " + command);
				
				switch(command)
				{
					// ***********************
					// Functional Commands
					// ***********************
					case CLEAR:
						if(model.getErrorState())
							model.setErrorState(false);
						else
							model.getActivePhrase().pop();
						break;
					case CLEAR_ALL:
						model.getActivePhrase().clear();
						model.getLastPhrase().clear();
						model.setErrorState(false);
						break;
	
					// ***********************
					// Mathematical Commands
					// ***********************
					case CEILING:
					{
						if(model.getErrorState()) break;
						
						try {
							Phrase input = model.getActivePhrase();
							double result = SimpleCalculatorParser.evaluatePhrase(input);
							result = MathUtil.ceiling(result);
							model.setActivePhrase(Phrase.convertToPhrase(result));
							model.setLastPhrase(input);
						} catch(Exception ex) {
							model.setErrorState(true);
						}
	
						break;
					}
					case EVALUATE:
					{
						if(model.getErrorState()) break;
						
						try {
							Phrase input = model.getActivePhrase();
							double result = SimpleCalculatorParser.evaluatePhrase(input);
							model.setActivePhrase(Phrase.convertToPhrase(result));
							model.setLastPhrase(input);
						} catch (Exception ex) {
							model.setErrorState(true);
						}
						
						break;
					}
					case FLOOR:
					{
						if(model.getErrorState()) break;
						
						try {
							Phrase input = model.getActivePhrase();
							double result = SimpleCalculatorParser.evaluatePhrase(input);
							result = MathUtil.floor(result);
							model.setActivePhrase(Phrase.convertToPhrase(result));
							model.setLastPhrase(input);
						} catch (Exception ex) {
							model.setErrorState(true);
						}
						
						break;
					}
					case NEGATE:
					{
						if(model.getErrorState()) break;
						
						try {
							Phrase input = model.getActivePhrase();
							double result = SimpleCalculatorParser.evaluatePhrase(input);
							result = MathUtil.negate(result);
							model.setActivePhrase(Phrase.convertToPhrase(result));
							model.setLastPhrase(input);
						} catch (Exception ex) {
							model.setErrorState(true);
						}
						
						break;
					}
					case RECIPROCAL:
					{
						if(model.getErrorState()) break;
						
						try {
							Phrase input = model.getActivePhrase();
							double result = SimpleCalculatorParser.evaluatePhrase(input);
							result = MathUtil.reciprocate(result);
							model.setActivePhrase(Phrase.convertToPhrase(result));
							model.setLastPhrase(input);
						} catch (Exception ex) {
							model.setErrorState(true);
						}
						
						break;
					}
					case SQUAREROOT:
					{
						if(model.getErrorState()) break;
						
						try {
							Phrase input = model.getActivePhrase();
							double result = SimpleCalculatorParser.evaluatePhrase(input);
							result = MathUtil.squareRoot(result);
							model.setActivePhrase(Phrase.convertToPhrase(result));
							model.setLastPhrase(input);
						} catch (Exception ex) {
							model.setErrorState(true);
						}
						
						break;
					}
					case SQUARE:
					{
						if(model.getErrorState()) break;
						
						try {
							Phrase input = model.getActivePhrase();
							double result = SimpleCalculatorParser.evaluatePhrase(input);
							result = MathUtil.exponentiate(result,2);
							model.setActivePhrase(Phrase.convertToPhrase(result));
							model.setLastPhrase(input);
						} catch (Exception ex) {
							model.setErrorState(true);
						}
						
						break;
					}
					default:
						break;
				};
			}
		}
	}	
}