package edu.odu.cs.cs600.calculator;

import javax.swing.JLabel;

/**
 * The Phrase class is the underlying string of characters which is parsed and evaluated
 * whenever a mathematical function button is clicked.  Characters, or morphemes, are
 * added to the Phrase as morpheme related buttons are clicked and according to specific
 * logic.
 */
public final class Phrase {
	String phrase = "0";
	JLabel display = null;
	
	/**
	 * Obtain the String representation of this Phrase
	 * @return
	 */
	public String getPhrase() {
		return phrase;
	}  // end default constructor
	
	
	
	/**
	 * Add a morpheme to this Phrase
	 * @param string
	 */
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
	
	
	
	/**
	 * Remove a morpheme from this Phrase
	 */
	public void pop() {
		int length = phrase.length();
		
		if ((length > 1)) {
			phrase = phrase.substring(0, (length - 1));
			updateLabel();
		} else {
			clear();
		}
	}  // end pop()
	
	
	
	/**
	 * Reset this Phrase according to simple calculator standards (represent the
	 * number 0)
	 */
	public void clear() {
		phrase = "0";
		updateLabel();
	}  // end clear()
	
	
	
	/**
	 * Assign the passed {@link swing.javax.JLabel JLabel} to display
	 * @param display
	 */
	public void setDisplay(JLabel display) {
		this.display = display;
	}  // end setDisplay(JLabel)
	
	
	
	/**
	 * Update the display of the calculator to reflect the current state of this
	 * Phrase
	 */
	public void updateLabel() {
		if (display != null) {
			display.setText(phrase);
		}
	}  // end updateLabel()



	/**
	 * Place this Phrase into the "on" state for the calculator.  Functionality
	 * is the same as what {@link #clear() clear()} performs.
	 */
	public void onState() {
		clear();
	}  // end onState()
	
	
	
	/**
	 * Place this Phrase into the "off" state for the calculator.  The Phrase
	 * is emptied of all characters and the display is updated with such
	 * (presenting the user with a blank display).
	 */
	public void offState() {
		phrase = "";
		updateLabel();
	}  // end offState()
}  // end class Phrase