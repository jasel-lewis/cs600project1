package edu.odu.cs.cs600.calculator;

import java.util.ArrayList;
import java.util.List;

import edu.odu.cs.cs600.calculator.math.grammar.Phrase;
import edu.odu.cs.cs600.calculator.math.grammar.PhraseChangeListener;

/**
 * This class is the Model of the MVC framework employed for this project
 */
public class CalculatorModel 
{		
	private Phrase activePhrase;
	private Phrase lastPhrase;
	private boolean errorState;
	private boolean powerState;
	
	private List<PhraseChangeListener> activePhraseChangedListeners = new ArrayList<PhraseChangeListener>();
	private List<PhraseChangeListener> lastPhraseChangedListeners = new ArrayList<PhraseChangeListener>();
	private List<ErrorStateChangedListener> errorStateChangedListeners = new ArrayList<ErrorStateChangedListener>();
	private List<PowerStateChangedListener> powerStateChangedListeners = new ArrayList<PowerStateChangedListener>();
	
	/**
	 * Constructor
	 */
	public CalculatorModel() {
		this.setPowerState(true);
		this.setErrorState(false);
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
		this.activePhrase.addChangeListener(new PhraseChangeListener() {
			@Override
			public void phraseChanged(Phrase phrase) {
				for(PhraseChangeListener listener : activePhraseChangedListeners)
					listener.phraseChanged(phrase);
			}
		});
		for(PhraseChangeListener listener : activePhraseChangedListeners)
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
		this.lastPhrase.addChangeListener(new PhraseChangeListener(){
			@Override
			public void phraseChanged(Phrase phrase) {
				for(PhraseChangeListener listener : lastPhraseChangedListeners)
					listener.phraseChanged(phrase);
			}
		});
		for(PhraseChangeListener listener : lastPhraseChangedListeners)
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
	public void addActivePhraseChangedListener(PhraseChangeListener listener) {
		this.activePhraseChangedListeners.add(listener);
	}
	
	
	/**
	 * Remove the listener which recognizes a change to the current (non-historcal)
	 * {@link Phrase} for this CalculatorModel
	 * @param listener
	 */
	public void removeActivePhraseChangedListener(PhraseChangeListener listener) {
		this.activePhraseChangedListeners.remove(listener);
	}
	
	
	/**
	 * Add a listener to this CalculatorModel in order to recognize a change to
	 * the historical {@link Phrase}
	 * @param listener
	 */
	public void addLastPhraseChangedListener(PhraseChangeListener listener) {
		this.lastPhraseChangedListeners.add(listener);
	}
	
	
	/**
	 * Remove the listener which recognizes a change to the historical {@link Phrase}
	 * for this CalculatorModel
	 * @param listener
	 */
	public void removeLastPhraseChangedListener(PhraseChangeListener listener) {
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
	
	/**
	 * Sets whether or not the calculator is turned on (true) or off (false)
	 * @param on on (true) or off (false)
	 */
	public void setPowerState(boolean on) {
		if(on != this.powerState) {
			this.powerState = on;
			this.firePowerStateChangedEvent();
		}
		
	}
	
	/**
	 * Returns the power state of the calculator.
	 * @return boolean The power state of the calculator (true) on / (false) off
	 */
	public boolean getPowerState() {
		return this.powerState;
	}
	
	/**
	 * Add a listener to this CalculatorModel in order to recognize a change to
	 * the state of the power
	 * @param listener
	 */
	public void addPowerStateChangedListener(PowerStateChangedListener listener) {
		this.powerStateChangedListeners.add(listener);
	}
	
	
	/**
	 * Remove the listener which recognizes a change to the state of the power
	 * of the calculator
	 * @param listener
	 */
	public void removePowerStateChangedListener(PowerStateChangedListener listener) {
		this.powerStateChangedListeners.remove(listener);
	}
	
	/**
	 * Alert all listeners that the power state of the calculator has changed
	 */
	private void firePowerStateChangedEvent() {
		if(this.powerStateChangedListeners != null) {
			for(PowerStateChangedListener listener : this.powerStateChangedListeners)
				listener.powerStateChanged(this.getPowerState());
		}
	}
}
