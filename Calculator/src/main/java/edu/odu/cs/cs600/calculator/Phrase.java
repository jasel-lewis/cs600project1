/**
 * 
 */
package edu.odu.cs.cs600.calculator;

import javax.swing.JLabel;

/**
 *
 */
public final class Phrase {
	String phrase = "";
	JLabel display = null;
	
	public String getPhrase() {
		return phrase;
	}  // end default constructor
	
	
	
	public void push(String string) {
		if ((phrase.length() + string.length()) <= 10) {
			phrase.concat(string);
			updateLabel();
		}
	}  // end push(String)
	
	
	
	public void pop() {
		if ((phrase.length() > 0)) {
			phrase = phrase.substring(0, phrase.length());
		}
	}  // end pop()
	
	
	
	public void clear() {
		phrase = "";
		updateLabel();
	}  // end clear()
	
	
	
	public void setDisplay(JLabel display) {
		this.display = display;
	}  // end setDisplay(JLabel)
	
	
	
	public void updateLabel() {
		if (display != null) {
			display.setText(phrase);
		}
	}  // end updateLabel()
}  // end class Phrase