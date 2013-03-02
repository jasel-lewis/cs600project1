package edu.odu.cs.cs600.calculator.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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
	public JButton createButton(int type, String imageFilenamePath, String fallbackText) {
		ImageIcon imgIcon = createImageIcon(imageFilenamePath);
		JButton jb;
		
		if (imgIcon == null) {
			jb = new JButton(fallbackText);
		} else {
			jb = new JButton(imgIcon);
		}
		
		jb.setFont(BUTTON_FONT);
		gbLayout.setConstraints(jb, gbConstraints);
		
		switch(type) {
			case MORPHEME:
				morphemeButton(jb);
				break;
			case CLEAR_ENTRY:
				clearEntryButton(jb);
				break;
			case CLEAR_ALL:
				clearAllButton(jb);
				break;
			case UNARY:
				unaryButton(jb);
				break;
			case BINARY:
				binaryButton(jb);
				break;
			case ON:
				onButton(jb);
				break;
			case OFF:
				offButton(jb);
				break;
			default:
				break;
		}
		
		return jb;
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
	private void morphemeButton(JButton jb) {
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (Application.isOn()) {
					phrase.push(((JButton)ae.getSource()).getText());
				}
			}
		});
	}  // end morphemeButton(JButton)
	
	
	
	/**
	 * Creates the listener for the Clear Entry button which calls
	 * {@link Phrase#pop() pop()} to remove the last morpheme in the phrase
	 * @param jb
	 * @param phrase
	 */
	private void clearEntryButton(JButton jb) {
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (Application.isOn()) {
					phrase.pop();
				}
			}
		});
	}  // end clearEntryButton(JButton)
	
	
	
	/**
	 * Creates the listener for the Clear (All) button which calls
	 * {@link Phrase#clear() clear()} to reset the phrase
	 * @param jb
	 */
	private void clearAllButton(JButton jb) {
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (Application.isOn()) {
					phrase.clear();
				}
			}
		});
	}  // end clearAllButton(JButton)
	
	
	
	private void unaryButton(JButton jb) {
		;
	}  // end unaryButton(JButton)
	
	
	
	private void binaryButton(JButton jb) {
		;
	}  // end binaryButton(JButton)
	
	
	
	private void onButton(JButton jb) {
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				phrase.clear();
				Application.on();
			}
		});		
	}  // end onButton(JButton)
	
	
	
	private void offButton(JButton jb) {
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (Application.isOn()) {
					phrase.offState();
					Application.off();
				}
			}
		});
	}
}