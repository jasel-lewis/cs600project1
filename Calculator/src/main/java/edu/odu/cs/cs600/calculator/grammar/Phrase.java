package edu.odu.cs.cs600.calculator.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.odu.cs.cs600.calculator.gui.CalculatorCharacter;

public class Phrase {
	
	private List <CalculatorCharacter> dcList = new ArrayList <CalculatorCharacter> ();
	private List<ChangeListener> changeListeners = new ArrayList<ChangeListener> ();
	
	public Phrase() {
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
	//TODO: Fix this
	public void push(CalculatorCharacter cc) {
		dcList.add(cc);
		fireChangeEvent();
		
//		There's problems in this code that need to be cleaned up... Temporarily commented it all out
//		so that I could get stuff into the display so I can work on other stuff....
//
//		// List of characters which will allow us to keep zero as the first character in the phrase
//		String zeroAllowedAsFirst = ".+*-/";
//		
//		// If zero is the first (or only) character in the display, get rid of it on the next button
//		// action which enters a character in the display only if the character is one of those
//		// listed in zerAllowedAsFirst
//		if ((dcList.size() == 1) 
//				&& (zeroAllowedAsFirst.indexOf(String.valueOf(cc.getMorpheme())) < 0)
//				&& (dcList.get(0).equalsMorpheme('0'))) {
//			dcList.clear();
//		}
//		
//		if (dcList.size() < 10) {
//			dcList.add(cc);
//			update();
//		}
	}
	
	
	
	/**
	 * Remove a {@link CalculatorCharacter} from this CalculatorDisplay
	 */
	public void pop() {		
		if (dcList.size() > 1) {
			dcList.remove(dcList.size() - 1);
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
		dcList.clear();
		dcList.add(new CalculatorCharacter('0'));
		
		fireChangeEvent();
	}  // end clear()
	
	
	
	public void setPhrase(List<CalculatorCharacter> phrase) {
		dcList = phrase;
		fireChangeEvent();
	}
	
	
	
	// TODO : Make this static once a formal "Phrase" object is created
	public List<CalculatorCharacter> convertToPhrase(String phrase) {
		List<CalculatorCharacter> result = new ArrayList<CalculatorCharacter>();
		for (int i = 0; i < phrase.length(); i++) {
			result.add(new CalculatorCharacter(phrase.charAt(i)));
		}
		
		return result;
	}
	
	
	
	public void setOffState() {
		dcList.clear();
		
		dcList.add(new CalculatorCharacter('O'));
		dcList.add(new CalculatorCharacter('f'));
		dcList.add(new CalculatorCharacter('f'));
		
		fireChangeEvent();
	}
}