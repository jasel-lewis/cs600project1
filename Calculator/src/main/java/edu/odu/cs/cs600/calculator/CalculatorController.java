package edu.odu.cs.cs600.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.odu.cs.cs600.calculator.gui.CalculatorView;
import edu.odu.cs.cs600.calculator.gui.button.CharacterInputButton;
import edu.odu.cs.cs600.calculator.gui.button.CommandButton;
import edu.odu.cs.cs600.calculator.math.MathUtil;
import edu.odu.cs.cs600.calculator.math.grammar.Lexer;
import edu.odu.cs.cs600.calculator.math.grammar.Phrase;
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
		this.model.addErrorStateChangedListener(new ModelErrorStateChangedListener());
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
		this.model.getActivePhrase().addChangeListener(new PhraseChangeListener());
	}
	
	
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
	
	private class PhraseChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			view.setActiveDisplayText(model.getActivePhrase().toString(true));
		}
	}
	
	
	
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
						model.setErrorState(false);
						break;
	
					// ***********************
					// Mathematical Commands
					// ***********************
					// TODO: (Jared) Create a display to show the last expression executed...
					case CEILING:
					{
						if(model.getErrorState()) break;
						
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getActivePhrase()));
							// TODO: Might want to evaluate the returned double somewhere in here
							// to ensure it's chopped at 10 characters.  For instance, if the
							// double returned is 3.666666666666666667, we want to represent it
							// as the 10-character string: 3.66666667.  This described
							// functionality seems as if it'd belong to the display, however,
							// there will most likely need to be some number introspection which
							// would place the logic here within the controller.
							// On the flip side - what if we did 125^125?  We would have to
							// convert to scientific notation and display.
							//model.getActivePhrase().setPhrase(MathUtil.ceiling(parser.parseExpression().getValue()));
							double result = MathUtil.ceiling(parser.parseExpression().getValue());
							model.setActivePhrase(Phrase.convertToPhrase(result));
						} catch(Exception ex) {
							model.setErrorState(true);
						}
	
						break;
					}
					case EVALUATE:
					{
						if(model.getErrorState()) break;
						
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getActivePhrase()));
							// TODO: Possibly evaluate character length (see above TODO)
							double result = parser.parseExpression().getValue();
							model.setActivePhrase(Phrase.convertToPhrase(result));
						} catch (Exception ex) {
							model.setErrorState(true);
						}
						
						break;
					}
					case FLOOR:
					{
						if(model.getErrorState()) break;
						
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getActivePhrase()));
							// TODO: Possibly evaluate character length (see above TODO)
							double result = MathUtil.floor(parser.parseExpression().getValue());
							model.setActivePhrase(Phrase.convertToPhrase(result));
						} catch (Exception ex) {
							model.setErrorState(true);
						}
						
						break;
					}
					case NEGATE:
					{
						if(model.getErrorState()) break;
						
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getActivePhrase()));
							// TODO: Possibly evaluate character length (see above TODO)
							double result = MathUtil.negate(parser.parseExpression().getValue());
							model.setActivePhrase(Phrase.convertToPhrase(result));
							
						} catch (Exception ex) {
							model.setErrorState(true);
						}
						
						break;
					}
					case RECIPROCAL:
					{
						if(model.getErrorState()) break;
						
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getActivePhrase()));
							// TODO: Possibly evaluate character length (see above TODO)
							double result = MathUtil.reciprocate(parser.parseExpression().getValue());
							model.setActivePhrase(Phrase.convertToPhrase(result));
						} catch (Exception ex) {
							model.setErrorState(true);
						}
						
						break;
					}
					case SQUAREROOT:
					{
						if(model.getErrorState()) break;
						
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getActivePhrase()));
							// TODO: Possibly evaluate character length (see above TODO)
							double result = MathUtil.squareRoot(parser.parseExpression().getValue());
							model.setActivePhrase(Phrase.convertToPhrase(result));
						} catch (Exception ex) {
							model.setErrorState(true);
						}
						
						break;
					}
					case SQUARE:
					{
						if(model.getErrorState()) break;
						
						try {
							parser = new SimpleCalculatorParser(new Lexer(model.getActivePhrase()));
							// TODO: Possibly evaluate character length (see above TODO)
							double result = MathUtil.exponentiate(parser.parseExpression().getValue(), 2.0);
							model.setActivePhrase(Phrase.convertToPhrase(result));
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
