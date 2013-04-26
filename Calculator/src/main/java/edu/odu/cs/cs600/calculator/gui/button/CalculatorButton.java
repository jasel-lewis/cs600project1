package edu.odu.cs.cs600.calculator.gui.button;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ComponentInputMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ActionMapUIResource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class CalculatorButton extends JButton 
{

	private static Logger logger = LogManager.getLogger(CalculatorButton.class);
	private static final long serialVersionUID = -7812322272853697084L;
	private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 26);
	
	public CalculatorButton(String imagePath, String imageOverPath)
	{
		super();
		
		ImageIcon imgIcon = createImageIcon(imagePath);
		
		// If we have a valid Icon, we do not want the text to show
		if (imgIcon != null) {
			this.setIcon(imgIcon);
		}
		
		ImageIcon imgOverIcon = createImageIcon(imageOverPath);
		
		// If we have a valid Icon, we do not want the text to show
		if (imgOverIcon != null) {
			this.setPressedIcon(imgOverIcon);
			this.setRolloverIcon(imgOverIcon);
		}
		
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		
		setFont(BUTTON_FONT);
	}
	
	public CalculatorButton(String imagePath, String imageOverPath, int keyCode)
	{
		this(imagePath, imageOverPath);
		
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
	protected ImageIcon createImageIcon(String path)
	{
		URL imgURL = (Thread.currentThread().getContextClassLoader()).getResource(path);
		
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			logger.warn("Could not locate image resource for button icon: " + path);
			return null;
		}
	}
	
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
		
		keyMap.put(keyCode, keyCode.getKeyCode());
		
		ActionMap actionMap = new ActionMapUIResource();
		actionMap.put(keyCode.getKeyCode(), new AbstractAction() {
			private static final long serialVersionUID = 303540849078642457L;

			public void actionPerformed(ActionEvent ae) {
				logger.debug("ActionEvent: " + ae);
				((CalculatorButton)ae.getSource()).doClick();
			}
		});
		
		SwingUtilities.replaceUIActionMap(this,  actionMap);
		SwingUtilities.replaceUIInputMap(this, JComponent.WHEN_IN_FOCUSED_WINDOW, keyMap);
	}
	
	
}