package edu.odu.cs.cs600.calculator.gui;

import javax.swing.Icon;
import javax.swing.JButton;

public class CalculatorButton extends JButton {

	private static final long serialVersionUID = -7812322272853697084L;
	public static final int KEY_TYPE_NULL = 0;
	public static final int KEY_TYPE_NOT_NULL = 5674;
	
	private String fallbackText = "";
	private String morpheme = "";
	private int keyCodeType = KEY_TYPE_NOT_NULL;
	private char keyCodeValue;
	
	public CalculatorButton(String fallbackText, Icon icon, char key) {
		super(fallbackText, icon);
		
		// If we have a valid Icon, we do not want the text to show
		if (icon != null) {
			this.setText("");
		}
		
		this.fallbackText = fallbackText;
		
		if (key == 'u') {
			this.keyCodeType = KEY_TYPE_NULL;
		} else {
			this.keyCodeValue = key;
		}
	}
	
	
	
	public int getKeyType() {
		return keyCodeType;
	}  // end getKeyType()
	
	
	
	public char getKeyCodeValue() {
		return keyCodeValue;
	}  // end getKeyCodeValue()
	
	
	
	/**
	 * Return the fall-back, character representation of this CalculatorButton
	 * @return
	 */
	public String getFallbackText() {
		return(fallbackText);
	}  // end getFallbackText()
	
	
	
	/**
	 * Return the morpheme this button produces
	 * @return
	 */
	public String getMorpheme() {
		return(morpheme);
	}  // end getMorpheme()
	
	
	
	/**
	 * Set the morpheme which this button produces
	 */
	public void setMorpheme(String morpheme) {
		this.morpheme = morpheme;
	}  // end setMorpheme(String)
}  // end class CalculatorButton