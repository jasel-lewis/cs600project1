package edu.odu.cs.cs600.calculator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.odu.cs.cs600.calculator.math.grammar.Phrase;
import edu.odu.cs.cs600.calculator.math.grammar.PhraseChangedListener;

public class CalculatorModel 
{	
	private static Logger logger = LogManager.getLogger(CalculatorModel.class);
	
	private Phrase activePhrase;
	private Phrase lastPhrase;
	private boolean errorState;
	
	private List<PhraseChangedListener> activePhraseChangedListeners = new ArrayList<PhraseChangedListener>();
	private List<PhraseChangedListener> lastPhraseChangedListeners = new ArrayList<PhraseChangedListener>();
	private List<ErrorStateChangedListener> errorStateChangedListeners = new ArrayList<ErrorStateChangedListener>();
	
	public CalculatorModel() {
		this.errorState = false;
		this.setActivePhrase(new Phrase());
		this.setLastPhrase(new Phrase());
	}	
	
	public void setActivePhrase(Phrase phrase) {
		phrase.clearChangeListeners();
		this.activePhrase = phrase;
		this.activePhrase.addChangeListener(new PhraseChangedListener(){
			@Override
			public void phraseChanged(Phrase phrase) {
				for(PhraseChangedListener listener : activePhraseChangedListeners)
					listener.phraseChanged(phrase);
			}
		});
		for(PhraseChangedListener listener : activePhraseChangedListeners)
			listener.phraseChanged(phrase);
	} 
	
	public Phrase getActivePhrase() {
		return this.activePhrase;
	}
	
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