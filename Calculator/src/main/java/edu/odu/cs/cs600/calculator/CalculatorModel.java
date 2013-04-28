package edu.odu.cs.cs600.calculator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.odu.cs.cs600.calculator.math.grammar.Phrase;
import edu.odu.cs.cs600.calculator.math.grammar.PhraseChangedListener;

/**
 * This class is the Model of the MVC framework employed for this project
 */
public class CalculatorModel 
{	
	// TODO: Jared - logger (below) is not used - keep it?
	private static Logger logger = LogManager.getLogger(CalculatorModel.class);
	
	private Phrase activePhrase;
	private Phrase lastPhrase;
	private boolean errorState;
	
	private List<PhraseChangedListener> activePhraseChangedListeners = new ArrayList<PhraseChangedListener>();
	private List<PhraseChangedListener> lastPhraseChangedListeners = new ArrayList<PhraseChangedListener>();
	private List<ErrorStateChangedListener> errorStateChangedListeners = new ArrayList<ErrorStateChangedListener>();
	
	
	/**
	 * Constructor
	 */
	public CalculatorModel() {
		this.errorState = false;
		this.setActivePhrase(new Phrase());
		this.setLastPhrase(new Phrase());
	}	
	
	
	/**
	 * Sets/stores the phrase that is currently associated as the "Active" expression.  This may
	 * be as a result of user input, or the result of the evaluation of an expression.
	 * 
	 * @param phrase
	 */
	public void setActivePhrase(Phrase phrase) {
		phrase.clearChangeListeners();
		this.activePhrase = phrase;
		this.activePhrase.addChangeListener(new PhraseChangedListener() {
			@Override
			public void phraseChanged(Phrase phrase) {
				for(PhraseChangedListener listener : activePhraseChangedListeners)
					listener.phraseChanged(phrase);
			}
		});
		for(PhraseChangedListener listener : activePhraseChangedListeners)
			listener.phraseChanged(phrase);
	} 
	
	
	/**
	 * Returns the active {@link edu.odu.cs.cs600.calculator.math.grammar.Phrase} for this CalculatorModel
	 * @return the active {@link edu.odu.cs.cs600.calculator.math.grammar.Phrase} for this CalculatorModel
	 */
	public Phrase getActivePhrase() {
		return this.activePhrase;
	}
	
	
	/**
	 * Sets/stores the phrase that represents the last evaluated expression.
	 * @param phrase The last evaluated expression
	 */
	public void setLastPhrase(Phrase phrase) {
		phrase.clearChangeListeners();
		this.lastPhrase = phrase;
		this.lastPhrase.addChangeListener(new PhraseChangedListener(){
			@Override
			public void phraseChanged(Phrase phrase) {
				for(PhraseChangedListener listener : lastPhraseChangedListeners)
					listener.phraseChanged(phrase);
			}
		});
		for(PhraseChangedListener listener : lastPhraseChangedListeners)
			listener.phraseChanged(phrase);
	}
	
	
	/**
	 * Return the historical {@link edu.odu.cs.cs600.calculator.math.grammar.Phrase}
	 * for this CalculatorModel
	 * @return The Phrase representing the last expression executed
	 */
	public Phrase getLastPhrase() {
		return this.lastPhrase;
	}
	
	
	/**
	 * Add a listener to this CalculatorModel in order to recognize a change to
	 * the current (non-historical) {@link Phrase}
	 * @param listener
	 */
	public void addActivePhraseChangedListener(PhraseChangedListener listener) {
		this.activePhraseChangedListeners.add(listener);
	}
	
	
	/**
	 * Remove the listener which recognizes a change to the current (non-historcal)
	 * {@link Phrase} for this CalculatorModel
	 * @param listener
	 */
	public void removeActivePhraseChangedListener(PhraseChangedListener listener) {
		this.activePhraseChangedListeners.remove(listener);
	}
	
	
	/**
	 * Add a listener to this CalculatorModel in order to recognize a change to
	 * the historical {@link Phrase}
	 * @param listener
	 */
	public void addLastPhraseChangedListener(PhraseChangedListener listener) {
		this.lastPhraseChangedListeners.add(listener);
	}
	
	
	/**
	 * Remove the listener which recognizes a change to the historical {@link Phrase}
	 * for this CalculatorModel
	 * @param listener
	 */
	public void removeLastPhraseChangedListener(PhraseChangedListener listener) {
		this.lastPhraseChangedListeners.remove(listener);
	}
	
	
	/**
	 * Enter this CalculatorModel into an error state
	 * @param errorState
	 */
	public void setErrorState(boolean errorState) {
		if(this.errorState != errorState) {
			this.errorState = errorState;
			this.fireErrorStateChangedEvent();
		}
	}
	
	
	/**
	 * True if this CalculatorModel is currently entered into an error state.
	 * False if not.
	 * @return The state of the calculator (is an error present or not)
	 */
	public boolean getErrorState() {
		return this.errorState;
	}
	
	
	/**
	 * Add a listener to this CalculatorModel in order to recognize a change to
	 * the error state
	 * @param listener
	 */
	public void addErrorStateChangedListener(ErrorStateChangedListener listener) {
		this.errorStateChangedListeners.add(listener);
	}
	
	
	/**
	 * Remove the listener which recognizes a change to the error state
	 * @param listener
	 */
	public void removeErrorStateChangedListener(ErrorStateChangedListener listener) {
		this.errorStateChangedListeners.remove(listener);
	}
	
	
	/**
	 * Alert all error state listeners to a change in the error state
	 */
	private void fireErrorStateChangedEvent() {
		if(this.errorStateChangedListeners != null) {
			for(ErrorStateChangedListener listener : this.errorStateChangedListeners)
				listener.errorStateChanged(this.getErrorState());
		}
	}
}