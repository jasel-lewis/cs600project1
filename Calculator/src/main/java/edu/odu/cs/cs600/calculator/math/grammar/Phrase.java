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
	
	private boolean errorState = false;
	
	
	public Phrase() {
		clear();
	}
	
	
	
	public Phrase(Phrase phrase) {
		this();
		
		this.phrase = phrase.getPhrase();
	}

	
	private Phrase(List<CalculatorCharacter> phrase) {
		this();
		
		if (!phrase.isEmpty()) {
			this.phrase = phrase;
		}
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
		if (!errorState) {
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
	}
	
	
	
	public static Phrase convertToPhrase(String phrase) {
		return new Phrase(generateCharacterList(phrase));
	}
	
	
	
	private static List<CalculatorCharacter> generateCharacterList(String stringPhrase) {
		List<CalculatorCharacter> result = new ArrayList<CalculatorCharacter>();
		
		for (int i = 0; i < stringPhrase.length(); i++) {
			result.add(new CalculatorCharacter(stringPhrase.charAt(i)));
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
	
	
	
	public void setErrorState() {
		errorState = true;
		
		clear();
		
		phrase.add(new CalculatorCharacter('E'));
		phrase.add(new CalculatorCharacter('r'));
		phrase.add(new CalculatorCharacter('r'));
		phrase.add(new CalculatorCharacter('o'));
		phrase.add(new CalculatorCharacter('r'));
		
		fireChangeEvent();
	}
	
	
	
	public void clearErrorState() {
		errorState = false;
		
		clear();
	}
	
	
	
	public List<CalculatorCharacter> getPhrase() {
		return phrase;
	}
	
	
	
	public void setPhrase(double value) {
		this.phrase = generateCharacterList(Double.toString(value));
		fireChangeEvent();
	}
}