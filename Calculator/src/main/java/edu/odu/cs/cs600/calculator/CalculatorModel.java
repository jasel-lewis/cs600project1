package edu.odu.cs.cs600.calculator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import edu.odu.cs.cs600.calculator.math.grammar.Phrase;
import edu.odu.cs.cs600.calculator.math.grammar.PhraseChangedListener;

public class CalculatorModel 
{	
	private Phrase activePhrase;
	private Phrase lastPhrase;
	private boolean errorState;
	
	private List<PhraseChangedListener> activePhraseChangedListeners = new ArrayList<PhraseChangedListener>();
	private List<PhraseChangedListener> lastPhraseChangedListeners = new ArrayList<PhraseChangedListener>();
	private List<ErrorStateChangedListener> errorStateChangedListeners = new ArrayList<ErrorStateChangedListener>();
	
	public CalculatorModel() {
		this.errorState = false;
		this.activePhrase = new Phrase();
		this.lastPhrase = new Phrase();
	}	
	
	public Phrase getActivePhrase() {
		return this.activePhrase;
	}
	
	public void setActivePhrase(Phrase phrase) {
		this.lastPhrase = this.activePhrase;
		this.activePhrase = phrase;
	} 
	
	public Phrase getLastPhrase() {
		return this.lastPhrase;
	}
	
	public void addActivePhraseChangedListener(PhraseChangedListener listener) {
		this.activePhraseChangedListeners.add(listener);
	}
	
	public void removeActivePhraseChangedListener(PhraseChangedListener listener) {
		this.activePhraseChangedListeners.remove(listener);
	}
	
	public void addLastPhraseChangedListener(PhraseChangedListener listener) {
		this.lastPhraseChangedListeners.add(listener);
	}
	
	public void removeLastPhraseChangedListener(PhraseChangedListener listener) {
		this.lastPhraseChangedListeners.remove(listener);
	}
	
	
	public void setErrorState(boolean errorState) {
		if(this.errorState != errorState) {
			this.errorState = errorState;
			this.fireErrorStateChangedEvent();
		}
	}
	
	public boolean getErrorState() {
		return this.errorState;
	}

	public void addErrorStateChangedListener(ErrorStateChangedListener listener) {
		this.errorStateChangedListeners.add(listener);
	}
	
	public void removeErrorStateChangedListener(ErrorStateChangedListener listener) {
		this.errorStateChangedListeners.remove(listener);
	}
	
	private void fireErrorStateChangedEvent() {
		if(this.errorStateChangedListeners != null) {
			for(ErrorStateChangedListener listener : this.errorStateChangedListeners)
				listener.errorStateChanged(this.getErrorState());
		}
	}
	
}