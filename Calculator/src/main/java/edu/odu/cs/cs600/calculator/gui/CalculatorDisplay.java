package edu.odu.cs.cs600.calculator.gui;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JLabel;

public class CalculatorDisplay extends JLabel {
	private static final long serialVersionUID = 495748020793031026L;
	private static final ArrayList <CalculatorCharacter> OFF = new ArrayList <CalculatorCharacter> ();
	
	private ArrayList <CalculatorCharacter> dcList = new ArrayList <CalculatorCharacter> ();
	
	
	public CalculatorDisplay() {
		super();
		
		OFF.add(new CalculatorCharacter('O'));
		OFF.add(new CalculatorCharacter('f'));
		OFF.add(new CalculatorCharacter('f'));
	}
	
	
	
	/**
	 * Returns the phrase for this CalculatorDisplay object.  If true is passed, the phrase
	 * is wrapped in HTML tags and ISO codes are used for any {@link CalculatorCharacters}
	 * which have them.  If false is passed, the returned phrase is a {@link java.lang.String}
	 * of the single-character representation for each {@link CalculatorClass} (for use in
	 * parsing when passed to a mathematical method).
	 * @param display
	 * @return
	 */
	public String getPhrase(boolean display) {
		ListIterator<CalculatorCharacter> it = dcList.listIterator();
		CalculatorCharacter cc;
		String phrase = "";
		
		if (display) {
			phrase = phrase.concat("<html>");
		}
		
		while (it.hasNext()) {
			cc = it.next();
			
			if (cc.requiresISORepresentation() && display) {
				phrase = phrase.concat(cc.getISORepresentation());
			} else {
				phrase = phrase.concat(String.valueOf(cc.getMorpheme()));
			}
		}
		
		if (display) {
			phrase = phrase.concat("</html>");
		}
		
		return phrase;
	}  // end default constructor
	
	
	
	/**
	 * Add a {@link CalculatorCharacter} to this CalculatorDisplay
	 * @param string
	 */
	public void push(CalculatorCharacter cc) {
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
	 * Update the display to reflect the current state
	 */
	public void update() {
		setText(getPhrase(true));
	}  // end updateLabel()



	/**
	 * Place this CalculatorDisplay into the "on" state for the calculator.  Functionality
	 * is the same as what {@link #clear() clear()} performs.
	 */
	public void onState() {
		clear();
	}  // end onState()
	
	
	
	/**
	 * Place this CalculatorDisplay into the "off" state for the calculator.  The
	 * phrase is emptied of all characters and the display is updated with such
	 * (presenting the user with a blank display).
	 */
	public void offState() {
		dcList = (ArrayList<CalculatorCharacter>) OFF.clone();
		update();
	}  // end offState()
}  // end class CalculatorDisplay