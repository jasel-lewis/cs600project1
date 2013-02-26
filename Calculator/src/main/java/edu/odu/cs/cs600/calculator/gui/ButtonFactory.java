package edu.odu.cs.cs600.calculator.gui;

import java.awt.Font;

import javax.swing.Action;
import javax.swing.JButton;

public class ButtonFactory {
	
	JButton jb;
	
	// Move these into some kind of properties file later
	private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 26);

	public ButtonFactory(Action action, String text) {
		jb = new JButton(action);
		
		// Override whatever JButton inherits as its text from the action.text property
		jb.setText(text);
		
		jb.setFont(BUTTON_FONT);
	}

	
	/**
	 * @return
	 */
	public JButton getButton() {
		return (jb);
	}
}