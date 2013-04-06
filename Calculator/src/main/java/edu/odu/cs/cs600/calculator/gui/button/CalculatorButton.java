package edu.odu.cs.cs600.calculator.gui.button;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ComponentInputMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ActionMapUIResource;

import edu.odu.cs.cs600.calculator.Application;

public class CalculatorButton extends JButton {

	private static final long serialVersionUID = -7812322272853697084L;
	
	// Move this into some kind of properties file later
	private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 26);
	
	private String altText = "";
	
	public CalculatorButton(String imageFilenamePath, String altText)
	{
		super(altText);
		
		ImageIcon imgIcon = createImageIcon(imageFilenamePath);
		
		// If we have a valid Icon, we do not want the text to show
		if (imgIcon != null) {
			this.setIcon(imgIcon);
			this.setText("");
		}
		
		this.altText = altText;
		
		setFont(BUTTON_FONT);
	}
	
	public CalculatorButton(String imageFilenamePath, String altText, int keyCode)
	{
		this(imageFilenamePath, altText);
		
		if (keyCode != KeyEvent.VK_UNDEFINED) {
			this.hookKeyInput(keyCode);
		}
	}
	
	
	
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
	public String getAltText() {
		return altText;
	}  // end getFallbackText()
	
	
	protected void hookKeyInput(int keyCode)
	{
		this.hookKeyInput(KeyStroke.getKeyStroke(keyCode, 0));
	}
	
	protected void hookKeyInput(char character)
	{
		this.hookKeyInput(KeyStroke.getKeyStroke(character));
	}	
	
	protected void hookKeyInput(KeyStroke keyCode) 
	{
		InputMap keyMap = new ComponentInputMap(this);
		
		// TODO: Figure out why the fuck getAlt+Text() got put in here
		keyMap.put(keyCode, this.getAltText());
		
		ActionMap actionMap = new ActionMapUIResource();
		actionMap.put(this.getAltText(), new AbstractAction() {
			private static final long serialVersionUID = 303540849078642457L;

			public void actionPerformed(ActionEvent ae) {
				if (Application.debug) {
					System.err.println("ActionEvent: " + ae);
				}
				((CalculatorButton)ae.getSource()).doClick();
			}
		});
		
		SwingUtilities.replaceUIActionMap(this,  actionMap);
		SwingUtilities.replaceUIInputMap(this, JComponent.WHEN_IN_FOCUSED_WINDOW, keyMap);
	}  // end hookKeyInput(char)
	
	
}  // end class CalculatorButton