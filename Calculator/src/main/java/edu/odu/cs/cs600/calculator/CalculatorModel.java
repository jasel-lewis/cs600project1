package edu.odu.cs.cs600.calculator;

import edu.odu.cs.cs600.calculator.math.grammar.Phrase;

public class CalculatorModel {
	
	private Phrase phrase = new Phrase();
	
	public CalculatorModel() {
	}	
	
	public Phrase getPhrase() {
		return phrase;
	}
	
	public void setPhrase(Phrase phrase) {
		this.phrase = phrase;
	} 
}