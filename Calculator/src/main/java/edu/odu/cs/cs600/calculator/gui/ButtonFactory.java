package edu.odu.cs.cs600.calculator.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import edu.odu.cs.cs600.calculator.Application;
import edu.odu.cs.cs600.calculator.Phrase;

public class ButtonFactory {
	
	public static final int MORPHEME = 9001;
	public static final int CLEAR_ENTRY = 9002;
	public static final int CLEAR_ALL = 9003;
	public static final int UNARY = 8001;
	public static final int BINARY = 8002;
	public static final int ON = 7001;
	public static final int OFF = 7002;
	
	private GridBagLayout gbLayout;
	private GridBagConstraints gbConstraints;
	private final Phrase phrase;
	
	// Move this into some kind of properties file later
	private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 26);

	public ButtonFactory(GridBagLayout gbLayout, GridBagConstraints gbConstraints, Phrase phrase) {
		this.gbLayout = gbLayout;
		this.gbConstraints = gbConstraints;
		this.phrase = phrase; 
	}
	
	
	
	/**
	 * Create a {@link javax.swing.JButton JButton} of the passed type and labeled with the
	 * passed String.  Valid types are
	 * {@link #MORPHEME MORPHEME}, {@link #CLEAR_ENTRY CLEAR_ENTRY},
	 * {@link #CLEAR_ALL CLEAR_ALL}, {@link #UNARY_OPERATOR UNARY_OPERATOR},
	 * {@link #BINARY_OPERATOR BINARY_OPERATOR}, {@link #ON ON} and
	 * {@link #OFF OFF}.
	 * @param type
	 * @param text
	 * @return
	 */
	public CalculatorButton createButton(int type, String imageFilenamePath, String fallbackText) {
		ImageIcon imgIcon = createImageIcon(imageFilenamePath);
		CalculatorButton cb;
		
		if (imgIcon == null) {
			cb = new CalculatorButton(fallbackText);
		} else {
			cb = new CalculatorButton(imgIcon);
		}
		
		cb.setFont(BUTTON_FONT);
		gbLayout.setConstraints(cb, gbConstraints);
		
		switch(type) {
			case MORPHEME:
				morphemeButton(cb, fallbackText);
				break;
			case CLEAR_ENTRY:
				clearEntryButton(cb);
				break;
			case CLEAR_ALL:
				clearAllButton(cb);
				break;
			case UNARY:
				unaryButton(cb);
				break;
			case BINARY:
				binaryButton(cb);
				break;
			case ON:
				onButton(cb);
				break;
			case OFF:
				offButton(cb);
				break;
			default:
				break;
		}
		
		return cb;
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
	 * Creates the listener for a morpheme button which calls {@link Phrase#push() push()}
	 * to add the morpheme to the phrase 
	 * @param jb
	 * @param phrase
	 */
	private void morphemeButton(CalculatorButton cb, String morpheme) {
		cb.setMorpheme(morpheme);
		
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (Application.isOn()) {
					phrase.push(((CalculatorButton)ae.getSource()).getMorpheme());
				}
			}
		});
	}  // end morphemeButton(CalculatorButton)
	
	
	
	/**
	 * Creates the listener for the Clear Entry button which calls
	 * {@link Phrase#pop() pop()} to remove the last morpheme in the phrase
	 * @param jb
	 * @param phrase
	 */
	private void clearEntryButton(CalculatorButton cb) {
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (Application.isOn()) {
					phrase.pop();
				}
			}
		});
	}  // end clearEntryButton(CalculatorButton)
	
	
	
	/**
	 * Creates the listener for the Clear (All) button which calls
	 * {@link Phrase#clear() clear()} to reset the phrase
	 * @param jb
	 */
	private void clearAllButton(CalculatorButton cb) {
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (Application.isOn()) {
					phrase.clear();
				}
			}
		});
	}  // end clearAllButton(CalculatorButton)
	
	
	
	private void unaryButton(CalculatorButton cb) {
		;
	}  // end unaryButton(CalculatorButton)
	
	
	
	private void binaryButton(CalculatorButton cb) {
		;
	}  // end binaryButton(CalculatorButton)
	
	
	
	private void onButton(CalculatorButton cb) {
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				phrase.clear();
				Application.on();
			}
		});		
	}  // end onButton(CalculatorButton)
	
	
	
	private void offButton(CalculatorButton cb) {
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (Application.isOn()) {
					phrase.offState();
					Application.off();
				}
			}
		});
	}  // end offButton(CalculatorButton)
}