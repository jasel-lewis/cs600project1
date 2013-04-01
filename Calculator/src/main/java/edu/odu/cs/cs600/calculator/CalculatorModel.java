package edu.odu.cs.cs600.calculator;

import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JLabel;

import edu.odu.cs.cs600.calculator.gui.CalculatorCharacter;

public class CalculatorModel {
	
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	private static final ArrayList <CalculatorCharacter> OFF = new ArrayList <CalculatorCharacter> ();
	private boolean state = true;  // true: calculator is "on"; false: "off"
	private ArrayList <CalculatorCharacter> dcList = new ArrayList <CalculatorCharacter> ();
	
	public CalculatorModel() {
		OFF.add(new CalculatorCharacter('O'));
		OFF.add(new CalculatorCharacter('f'));
		OFF.add(new CalculatorCharacter('f'));
		
		push(new CalculatorCharacter('0'));
	}
	
	public void addStateChangeListener(PropertyChangeListener listener)
	{
		this.pcs.addPropertyChangeListener("state", listener);
	}
	
	/**
	 * Put the calculator into an "on":true or "off":false state
	 */
	public void setState(boolean state) {
		if(this.state != state)
		{
			this.pcs.firePropertyChange("state", this.state, state);
			this.state = state;
		}
	
	/**
	 * Returns the current state of the calculator. "on":true and "off":false
	 * @return boolean
	 */
	public boolean getState()
	{
		return this.state;
	}
	
	
	/**
	 * Returns the phrase for this CalculatorDisplay object.  If true is passed, the phrase
	 * is wrapped in HTML tags and ISO codes are used for any {@link CalculatorCharacters}
	 * which have them.  If false is passed, the returned phrase is a {@link java.lang.String}
	 * of the single-character representation for each {@link CalculatorClass} (for use in
	 * parsing when passed to a mathematical method).
	 * @param htmlEncode
	 * @return
	 */
	public String getPhrase(boolean htmlEncode) {
		ListIterator<CalculatorCharacter> it = dcList.listIterator();
		CalculatorCharacter cc;
		String phrase = "";
		
		if (htmlEncode) {
			phrase = phrase.concat("<html>");
		}
		
		while (it.hasNext()) {
			cc = it.next();
			
			if (cc.requiresISORepresentation() && htmlEncode) {
				phrase = phrase.concat(cc.getISORepresentation());
			} else {
				phrase = phrase.concat(String.valueOf(cc.getMorpheme()));
			}
		}
		
		if (htmlEncode) {
			phrase = phrase.concat("</html>");
		}
		
		return phrase;
	}  // end default constructor
	
	
	
	/**
	 * Add a {@link CalculatorCharacter} to this CalculatorDisplay
	 * @param string
	 */
	public void push(CalculatorCharacter cc) {
		// List of characters which will allow us to keep zero as the first character in the phrase
		String zeroAllowedAsFirst = ".+*-/";
		
		// If zero is the first (or only) character in the display, get rid of it on the next button
		// action which enters a character in the display only if the character is one of those
		// listed in zerAllowedAsFirst
		if ((dcList.size() == 1) 
				&& (zeroAllowedAsFirst.indexOf(String.valueOf(cc.getMorpheme())) < 0)
				&& (dcList.get(0).equalsMorpheme('0'))) {
			dcList.clear();
		}
		
		if (dcList.size() < 10) {
			dcList.add(cc);
			update();
		}
	}  // end push(String)
	
	
	
	/**
	 * Remove a {@link CalculatorCharacter} from this CalculatorDisplay
	 */
	public void pop() {
		if (dcList.size() > 1) {
			dcList.remove(dcList.size() - 1);
			update();
		} else {
			clear();
		}
	}  // end pop()
	
	
	
	/**
	 * Reset this CalculatorDsiplay according to simple calculator standards (represent
	 * the number 0)
	 */
	public void clear() {
		dcList.clear();
		dcList.add(new CalculatorCharacter('0'));
		update();
	}  // end clear()
	
	
	
	/**
	 * Update the display to reflect the current isOn
	 */
	public void update() {
		setText(getPhrase(true));
	}  // end updateLabel()
}  // end class CalculatorModel
