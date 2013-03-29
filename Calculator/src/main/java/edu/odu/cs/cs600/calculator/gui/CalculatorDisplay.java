package edu.odu.cs.cs600.calculator.gui;

import javax.swing.JLabel;

public class CalculatorDisplay extends JLabel {
	String phrase = "0";
	
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
				
				update();
			}
		} else {
			// <= 9 because it's senseless to make the tenth character a decimal point
			if ((length <= 9) && (!phrase.contains("."))) {
				phrase = phrase.concat(string);
				update();
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
			update();
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
		update();
	}  // end clear()
	
	
	
	/**
	 * Update the display of the calculator to reflect the current state of this
	 * Phrase
	 */
	public void update() {
		setText(phrase);
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
		update();
	}  // end offState()
}
