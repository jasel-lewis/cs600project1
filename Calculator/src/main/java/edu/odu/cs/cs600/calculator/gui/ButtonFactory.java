package edu.odu.cs.cs600.calculator.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.odu.cs.cs600.calculator.Phrase;

public class ButtonFactory {
	
	public static final int MORPHEME = 9001;
	public static final int CLEAR_ENTRY = 9002;
	public static final int CLEAR_ALL = 9003;
	public static final int UNARY_OPERATOR = 8001;
	public static final int BINARY_OPERATOR = 8002;
	public static final int POWER = 7001;
	
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
	
	
	
	public JButton createButton(int type, String text) {
		JButton jb = new JButton(text);
		
		jb.setFont(BUTTON_FONT);
		gbLayout.setConstraints(jb, gbConstraints);
		
		switch(type) {
			case MORPHEME:
				morphemeButton(jb, phrase);
				break;
			case CLEAR_ENTRY:
				clearEntryButton(jb, phrase);
				break;
			case CLEAR_ALL:
				clearAllButton(jb);
				break;
			case UNARY_OPERATOR:
				unaryButton(jb);
				break;
			case BINARY_OPERATOR:
				binaryButton(jb);
				break;
			case POWER:
				powerButton(jb);
				break;
			default:
				break;
		}
		
		return jb;
	}
	
	
	
	private void morphemeButton(JButton jb, final Phrase phrase) {
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				phrase.push(((JButton)ae.getSource()).getText());
			}
		});
	}  // end morphemeButton(JButton)
	
	
	
	private void clearEntryButton(JButton jb, final Phrase phrase) {
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				phrase.pop();
			}
		});
	}  // end clearEntryButton(JButton)
	
	
	
	private void clearAllButton(JButton jb) {
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				phrase.clear();
			}
		});
	}  // end clearAllButton(JButton)
	
	
	
	private void unaryButton(JButton jb) {
		;
	}  // end unaryButton(JButton)
	
	
	
	private void binaryButton(JButton jb) {
		;
	}  // end binaryButton(JButton)
	
	
	
	private void powerButton(JButton jb) {
		;
	}  // end powerButton(JButton)
}