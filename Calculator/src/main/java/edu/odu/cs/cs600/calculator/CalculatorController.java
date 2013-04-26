package edu.odu.cs.cs600.calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.odu.cs.cs600.calculator.gui.CalculatorView;
import edu.odu.cs.cs600.calculator.gui.button.CharacterInputButton;
import edu.odu.cs.cs600.calculator.gui.button.CommandButton;
import edu.odu.cs.cs600.calculator.math.MathUtil;
import edu.odu.cs.cs600.calculator.math.grammar.Lexer;
import edu.odu.cs.cs600.calculator.math.grammar.SimpleCalculatorParser;

public class CalculatorController 
{
	private static Logger logger = LogManager.getLogger(CalculatorController.class);
	
	private CalculatorModel model = null;
	private CalculatorView view = null;
	private SimpleCalculatorParser parser = null;
	
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
			view.setDisplay(model.getPhrase().toString(true));
		}
	}
	
	
	
	private class CharacterInputButtonActionListener implements ActionListener
	{
		// TODO : Check flag to see if the input needs to be cleared before adding the input to the phrase
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof CharacterInputButton)
			{
				CharacterInputButton button = (CharacterInputButton)e.getSource();
				model.getPhrase().push(button.getCalclatorCharacter());
				
				logger.debug("Character button pressed: " + button.getCalclatorCharacter());
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
				
				logger.debug("Command button pressed: " + command);
				
				switch(command)
				{
					// ***********************
					// Functional Commands
					// ***********************
					case CLEAR:
						model.getPhrase().pop();
						break;
					case CLEAR_ALL:
						model.getPhrase().clearErrorState();
						break;
	
					// ***********************
					// Mathematical Commands
					// ***********************
					// TODO: (Jared) Create a display to show the last expression executed...
					case CEILING:
					{
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getPhrase()));
							// TODO: Might want to evaluate the returned double somewhere in here
							// to ensure it's chopped at 10 characters.  For instance, if the
							// double returned is 3.666666666666666667, we want to represent it
							// as the 10-character string: 3.66666667.  This described
							// functionality seems as if it'd belong to the display, however,
							// there will most likely need to be some number introspection which
							// would place the logic here within the controller.
							// On the flip side - what if we did 125^125?  We would have to
							// convert to scientific notation and display.
							model.getPhrase().setPhrase(MathUtil.ceiling(parser.parseExpression().getValue()));
						} catch(Exception ex) {
							model.getPhrase().setErrorState();
						}
	
						break;
					}
					case EVALUATE:
					{
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getPhrase()));
							// TODO: Possibly evaluate character length (see above TODO)
							model.getPhrase().setPhrase(parser.parseExpression().getValue());
						} catch (Exception ex) {
							model.getPhrase().setErrorState();
						}
						
						break;
					}
					case FLOOR:
					{
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getPhrase()));
							// TODO: Possibly evaluate character length (see above TODO)
							model.getPhrase().setPhrase(MathUtil.floor(parser.parseExpression().getValue()));
						} catch (Exception ex) {
							model.getPhrase().setErrorState();
						}
						
						break;
					}
					case NEGATE:
					{
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getPhrase()));
							// TODO: Possibly evaluate character length (see above TODO)
							model.getPhrase().setPhrase(MathUtil.negate(parser.parseExpression().getValue()));
						} catch (Exception ex) {
							model.getPhrase().setErrorState();
						}
						
						break;
					}
					case RECIPROCAL:
					{
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getPhrase()));
							// TODO: Possibly evaluate character length (see above TODO)
							model.getPhrase().setPhrase(MathUtil.reciprocate(parser.parseExpression().getValue()));
						} catch (Exception ex) {
							model.getPhrase().setErrorState();
						}
						
						break;
					}
					case SQUAREROOT:
					{
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getPhrase()));
							// TODO: Possibly evaluate character length (see above TODO)
							model.getPhrase().setPhrase(MathUtil.squareRoot(parser.parseExpression().getValue()));
						} catch (Exception ex) {
							model.getPhrase().setErrorState();
						}
						
						break;
					}
					case SQUARE:
					{
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getPhrase()));
							// TODO: Possibly evaluate character length (see above TODO)
							model.getPhrase().setPhrase(MathUtil.exponentiate(parser.parseExpression().getValue(), 2.0));
						} catch (Exception ex) {
							model.getPhrase().setErrorState();
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
