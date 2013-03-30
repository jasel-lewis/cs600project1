package edu.odu.cs.cs600.calculator.gui;

import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class CalculatorButton extends JButton {

	private static final long serialVersionUID = -7812322272853697084L;
	
	// Move this into some kind of properties file later
	private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 26);
	
	private String fallbackText = "";
	
	public CalculatorButton(String imageFilenamePath, String fallbackText) {
		super(fallbackText);
		
		ImageIcon imgIcon = createImageIcon(imageFilenamePath);
		
		// If we have a valid Icon, we do not want the text to show
		if (imgIcon != null) {
			this.setIcon(imgIcon);
			this.setText("");
		}
		
		this.fallbackText = fallbackText;
		
		setFont(BUTTON_FONT);
	}  // end constructor CalculatorButton(String, String)
	
	
	
	/**
	 * Create an ImageIcon from the passed path and filename.  Return null if unable to
	 * locate the resource.
	 * @param path
	 * @return
	 */
	protected ImageIcon createImageIcon(String path) {
		URL imgURL = (Thread.currentThread().getContextClassLoader()).getResource(path);
		
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Could not locate image resource for button icon: " + path);
			return null;
		}
	}  // end createImageIcon(String)
	
	
	
	/**
	 * Return the fall-back, character representation of this CalculatorButton
	 * @return
	 */
	public String getFallbackText() {
		return fallbackText;
	}  // end getFallbackText()
}  // end class CalculatorButton