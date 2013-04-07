package edu.odu.cs.cs600.calculator.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.odu.cs.cs600.calculator.gui.CalculatorCharacter;

public class Phrase {
	private List <CalculatorCharacter> phrase = new ArrayList <CalculatorCharacter> ();
	private List<ChangeListener> changeListeners = new ArrayList<ChangeListener> ();
	
	public Phrase() {
		clear();
	}
	
	
	
	public void addChangeListener(ChangeListener listener) {
		changeListeners.add(listener);
	}
	
	
	
	public void removeChangeListener(ChangeListener listener) {
		changeListeners.remove(listener);
	}
	
	
	
	private void fireChangeEvent() {
		ChangeEvent e = new ChangeEvent(this);
		
		for (ChangeListener listener : changeListeners) {
			listener.stateChanged(e);
		}
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
		ListIterator<CalculatorCharacter> it = phrase.listIterator();
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
	
	
	
	// Returns the non-HTML version of this Phrase
	public String toString() {
		return getPhrase(false);
	}
	
	
	
	/**
	 * Add a {@link CalculatorCharacter} to this CalculatorDisplay
	 * @param string
	 */
	public void push(CalculatorCharacter cc) {
		// If the calculator was just turned on or was just cleared, a zero is displayed.  This
		// is a list of characters which will allow us to keep zero as the first character in the
		// phrase.  If anything other than these characters comes in to this push() function, the
		// zero is overwritten.
		String charList = ".+*-/";
		
		// If zero is the first (or only) character in the display, get rid of it on the next button
		// action which enters a character in the display only if the character is one of those
		// listed in charList
		if ((phrase.size() == 1)  // phrase only has one character in it
				&& (phrase.get(0).equalsMorpheme('0'))  // the first (and only) character in phrase is 0
				&& (charList.indexOf(String.valueOf(cc.getMorpheme())) < 0)  // the character to add does NOT appear in charList
				) {
			phrase.clear();
		}
		
		if (phrase.size() < 10) {
			phrase.add(cc);
		}
		
		fireChangeEvent();
	}
	
	
	
	/**
	 * Remove a {@link CalculatorCharacter} from this CalculatorDisplay
	 */
	public void pop() {		
		if (phrase.size() > 1) {
			phrase.remove(phrase.size() - 1);
			fireChangeEvent();
		} else {
			clear();
		}
	}  // end pop()
	
	
	
	/**
	 * Reset this CalculatorDsiplay according to simple calculator standards (represent
	 * the number 0)
	 */
	public void clear() {
		phrase.clear();
		phrase.add(new CalculatorCharacter('0'));
		
		fireChangeEvent();
	}  // end clear()
	
	
	
	public void setPhrase(List<CalculatorCharacter> phrase) {
		this.phrase = phrase;
		fireChangeEvent();
	}
	
	
	
	// TODO : Make this static once a formal "Phrase" object is created
	public static List<CalculatorCharacter> convertToPhrase(String phrase) {
		List<CalculatorCharacter> result = new ArrayList<CalculatorCharacter>();
		
		for (int i = 0; i < phrase.length(); i++) {
			result.add(new CalculatorCharacter(phrase.charAt(i)));
		}
		
		return result;
	}
	
	
	
	public void setOffState() {
		phrase.clear();
		
		phrase.add(new CalculatorCharacter('O'));
		phrase.add(new CalculatorCharacter('f'));
		phrase.add(new CalculatorCharacter('f'));
		
		fireChangeEvent();
	}
}