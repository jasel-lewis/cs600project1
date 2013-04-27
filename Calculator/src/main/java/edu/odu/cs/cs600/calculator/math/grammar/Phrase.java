package edu.odu.cs.cs600.calculator.math.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.odu.cs.cs600.calculator.CalculatorCharacter;

public class Phrase {
	private static final String CHARS_ALLOWING_ZERO = ".+*-/^";
	
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
	 * Returns a {@link String} representation of this Phrase.  If true is passed, the String
	 * is wrapped in HTML tags and ISO codes are used for any {@link CalculatorCharacter}s
	 * which have them.  If false is passed, the returned String contains solely
	 * single-character representations for each CalculatorCharacter (for use in parsing when
	 * passed to a mathematical method).
	 * @param htmlEncode
	 * @return
	 */
	public String toString(boolean htmlEncode) {
		ListIterator<CalculatorCharacter> it = phrase.listIterator();
		CalculatorCharacter cc;
		String stringPhrase = "";
		
		if (htmlEncode) {
			stringPhrase = stringPhrase.concat("<html>");
		}
		
		while (it.hasNext()) {
			cc = it.next();
			
			if (cc.requiresISORepresentation() && htmlEncode) {
				stringPhrase = stringPhrase.concat(cc.getISORepresentation());
			} else {
				stringPhrase = stringPhrase.concat(String.valueOf(cc.getMorpheme()));
			}
		}
		
		if (htmlEncode) {
			stringPhrase = stringPhrase.concat("</html>");
		}
		
		return stringPhrase;
	}
	
	
	@Override
	public String toString() {
		return toString(false);
	}
	
	/**
	 * Add a {@link CalculatorCharacter} to this Phrase
	 * @param string
	 */
	public void push(CalculatorCharacter cc) {
		// If the calculator was just turned on or was just cleared, a zero is displayed.  Zero is
		// a valid first number to only the +, -, *, / and ^ functions.  If any other characters
		// are passed to this method, the zero is overwritten.
		if ((phrase.size() == 1)  // phrase only has one character in it
				&& (phrase.get(0).equalsMorpheme('0'))  // the first (and only) character in phrase is 0
				&& (CHARS_ALLOWING_ZERO.indexOf(String.valueOf(cc.getMorpheme())) < 0)  // the character to add does NOT appear in the special list
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
	} 
	
	
	/**
	 * Resets the phrase to an empty phrase.  An empty phrase is represented by a single 0
	 */
	public void clear() {
		phrase.clear();
		phrase.add(new CalculatorCharacter('0'));
		
		fireChangeEvent();
	}	
	
	
	
	public static Phrase convertToPhrase(String phrase) {
		List<CalculatorCharacter> charList = generateCharacterList(phrase);
		Phrase p = new Phrase();
		for(CalculatorCharacter cc : charList)
			p.push(cc);
		return p;
	}
	
	public static Phrase convertToPhrase(double value) {
		return Phrase.convertToPhrase(Double.toString(value));
	}
	
	private static List<CalculatorCharacter> generateCharacterList(String stringPhrase) {
		List<CalculatorCharacter> result = new ArrayList<CalculatorCharacter>();
		
		for (int i = 0; i < stringPhrase.length(); i++) {
			result.add(new CalculatorCharacter(stringPhrase.charAt(i)));
		}
		
		return result;
	}
	
}