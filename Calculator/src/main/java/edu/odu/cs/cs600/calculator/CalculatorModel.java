package edu.odu.cs.cs600.calculator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import edu.odu.cs.cs600.calculator.math.grammar.Phrase;

public class CalculatorModel {
	
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private Phrase phrase = new Phrase();
	private boolean state = false;  // true: calculator is "on"; false: "off"
	
	public CalculatorModel() {
	}
	
	public void addStateChangeListener(PropertyChangeListener listener)
	{
		this.pcs.addPropertyChangeListener("state", listener);
	}
	
	
	
	/**
	 * Put the calculator into an "on":true or "off":false state
	 */
	public void setState(boolean state) {
		if(this.state != state)
		{
			this.pcs.firePropertyChange("state", this.state, state);
			this.state = state;
		}
	}
	
	/**
	 * Returns the current state of the calculator. "on":true and "off":false
	 * @return boolean
	 */
	public boolean getState()
	{
		return this.state;
	}
	
	
	public Phrase getPhrase() {
		return phrase;
	}
	
	
	
	public void setPhrase(Phrase phrase) {
		this.phrase = phrase;
	} 
}