/**
 * 
 */
package edu.odu.cs.cs600.calculator;

import javax.swing.JLabel;

/**
 *
 */
public final class Phrase {
	String phrase = "0";
	JLabel display = null;
	
	public String getPhrase() {
		return phrase;
	}  // end default constructor
	
	
	
	public void push(String string) {
		int length = phrase.length() + string.length();
		
		if (!string.equals(".")) {
			if (length <= 10) {
				if (phrase.equals("0")) {
					phrase = string;
				} else {
					phrase = phrase.concat(string);
				}
				
				updateLabel();
			}
		} else {
			// <= 9 because it's senseless to make the tenth character a decimal point
			if ((length <= 9) && (!phrase.contains("."))) {
				phrase = phrase.concat(string);
				updateLabel();
			}
		}
	}  // end push(String)
	
	
	
	public void pop() {
		int length = phrase.length();
		
		if ((length > 1)) {
			phrase = phrase.substring(0, (length - 1));
			updateLabel();
		} else {
			clear();
		}
	}  // end pop()
	
	
	
	public void clear() {
		phrase = "0";
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