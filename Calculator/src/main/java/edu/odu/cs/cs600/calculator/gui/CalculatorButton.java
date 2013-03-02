package edu.odu.cs.cs600.calculator.gui;

import javax.swing.Icon;
import javax.swing.JButton;

public class CalculatorButton extends JButton {

	private static final long serialVersionUID = -7812322272853697084L;
	private String morpheme = "";
	
	public CalculatorButton(String text) {
		super(text);
	}
	
	
	
	public CalculatorButton(Icon icon) {
		super(icon);
	}
	
	
	
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