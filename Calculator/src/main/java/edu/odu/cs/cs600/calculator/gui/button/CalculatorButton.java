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

/**
 * Base class for a CalculatorButton.  This class is extended by {@link CharacterInputButton}
 * and {@link CommandButton}.
 */
public abstract class CalculatorButton extends JButton 
{

	private static Logger logger = LogManager.getLogger(CalculatorButton.class);
	private static final long serialVersionUID = -7812322272853697084L;
	private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 26);
	
	
	/**
	 * Constructor for a CalculatorButton without an attributed keyboard key
	 * @param imageFilename filename of the image for use as the {@link ImageIcon} for this CalculatorButton
	 * @param imageOverFilename filename of the image for use as the {@link ImageIcon} for this CalculatorButton when hovered over
	 * @see CalculatorButton#createImageIcon(String)
	 */
	public CalculatorButton(String imageFilename, String imageOverFilename)
	{
		super();
		
		this.setIcon(imageFilename);
		this.setPressedIcon(imageOverFilename);
		
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		
		setFont(BUTTON_FONT);
	}
	
	/**
	 * Sets the icon of the button
	 * @param imageFilename Filename of the image available on the classpath
	 */
	public void setIcon(String imageFilename) 
	{
		ImageIcon imgIcon = createImageIcon(imageFilename);
		this.setIcon(imgIcon);
	}
	
	/**
	 * Sets the icon of the button when pressed
	 * @param imageFilename Filename of the image available on the classpath
	 */
	public void setPressedIcon(String imageFilename) 
	{
		ImageIcon imgOverIcon = createImageIcon(imageFilename);
		this.setPressedIcon(imgOverIcon);
		this.setRolloverIcon(imgOverIcon);
	}
	
	
	/**
	 * Constructor for a CalculatorButton with an attributed keyboard key
	 * @param imageFilename filename of the image for use as the {@link ImageIcon} for this CalculatorButton
	 * @param imageOverFilename filename of the image for use as the {@link ImageIcon} for this CalculatorButton when hovered over
	 * @param keyCode enumerated {@link KeyEvent} key code for the keyboard key to attribute to this CalculatorButton
	 * @see CalculatorButton#createImageIcon(String)
	 */
	public CalculatorButton(String imageFilename, String imageOverFilename, int keyCode)
	{
		this(imageFilename, imageOverFilename);
		
		if (keyCode != KeyEvent.VK_UNDEFINED) {
			this.hookKeyInput(keyCode);
		}
	}
	
	
	/**
	 * Create an {@link ImageIcon} from the passed filename.  Return null if unable to
	 * locate the resource.
	 * @param imageFilename filename of the image (relative to the $project/resources/images directory)
	 * @return An {@link ImageIcon} object based on the filename passed in
	 */
	protected ImageIcon createImageIcon(String imageFilename)
	{
		URL imgURL = (Thread.currentThread().getContextClassLoader()).getResource(imageFilename);
		
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			logger.warn("Could not locate image resource for button icon: " + imageFilename);
			return null;
		}
	}
	
	
	/**
	 * Creates a {@link KeyStroke} from the passed enumeration of {@link KeyEvent}.  The
	 * KeyStroke is then passed to {@link #hookKeyInput(KeyStroke)}.
	 * @param keyCode enumerated {@link KeyEvent} key code
	 */
	protected void hookKeyInput(int keyCode)
	{
		this.hookKeyInput(KeyStroke.getKeyStroke(keyCode, 0));
	}
	
	
	/**
	 * Creates a {@link KeyStroke} from the passed character value.  The KeyStroke is then
	 * passed to {@link #hookKeyInput(KeyStroke)}.
	 * @param character
	 */
	protected void hookKeyInput(char character)
	{
		this.hookKeyInput(KeyStroke.getKeyStroke(character));
	}	
	
	
	/**
	 * Record the passed {@link KeyStroke} within an {@link InputMap} for this
	 * CalculatorButton
	 * @param keyStroke
	 */
	protected void hookKeyInput(KeyStroke keyStroke) 
	{
		InputMap keyMap = new ComponentInputMap(this);
		
		keyMap.put(keyStroke, keyStroke.getKeyCode());
		
		ActionMap actionMap = new ActionMapUIResource();
		actionMap.put(keyStroke.getKeyCode(), new AbstractAction() {
			private static final long serialVersionUID = 303540849078642457L;

			public void actionPerformed(ActionEvent ae) {
				((CalculatorButton)ae.getSource()).doClick();
			}
		});
		
		SwingUtilities.replaceUIActionMap(this, actionMap);
		SwingUtilities.replaceUIInputMap(this, JComponent.WHEN_IN_FOCUSED_WINDOW, keyMap);
	}
}