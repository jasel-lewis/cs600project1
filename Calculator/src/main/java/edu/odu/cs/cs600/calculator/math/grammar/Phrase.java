package edu.odu.cs.cs600.calculator.math.grammar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.odu.cs.cs600.calculator.CalculatorCharacter;

public class Phrase 
{
	private static Logger logger = LogManager.getLogger(Phrase.class);
	private static final String CHARS_ALLOWING_ZERO = ".+*-/^";
	
	private List <CalculatorCharacter> characterList = new ArrayList <CalculatorCharacter> ();
	private List<PhraseChangedListener> phraseChangedListeners = new ArrayList<PhraseChangedListener> ();
	
	public Phrase() {
		clear();
	}
		
	public void addChangeListener(PhraseChangedListener listener) {
		phraseChangedListeners.add(listener);
	}
	
	public void removeChangeListener(PhraseChangedListener listener) {
		phraseChangedListeners.remove(listener);
	}
	
	public void clearChangeListeners() {
		phraseChangedListeners.clear();
	}
	
	private void fireChangeEvent() {
		for (PhraseChangedListener listener : phraseChangedListeners) {
			listener.phraseChanged(this);
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
		ListIterator<CalculatorCharacter> it = characterList.listIterator();
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
		if ((characterList.size() == 1)  // phrase only has one character in it
				&& (characterList.get(0).equalsMorpheme('0'))  // the first (and only) character in phrase is 0
				&& (CHARS_ALLOWING_ZERO.indexOf(String.valueOf(cc.getMorpheme())) < 0)  // the character to add does NOT appear in the special list
				) {
			characterList.clear();
		}
		
		characterList.add(cc);
		
		fireChangeEvent();
		
	}
	
	/**
	 * Remove a {@link CalculatorCharacter} from this CalculatorDisplay
	 */
	public void pop() {	
		if (characterList.size() > 1) {
			characterList.remove(characterList.size() - 1);
			fireChangeEvent();
		} else {
			clear();
		}
	} 
	
	
	/**
	 * Resets the phrase to an empty phrase.  An empty phrase is represented by a single 0
	 */
	public void clear() {
		characterList.clear();
		characterList.add(new CalculatorCharacter('0'));
		
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
		DecimalFormat df = new DecimalFormat("#.##########");
		return Phrase.convertToPhrase(df.format(value));
	}
	
	private static List<CalculatorCharacter> generateCharacterList(String stringPhrase) {
		List<CalculatorCharacter> result = new ArrayList<CalculatorCharacter>();
		
		for (int i = 0; i < stringPhrase.length(); i++) {
			result.add(new CalculatorCharacter(stringPhrase.charAt(i)));
		}
		
		return result;
	}
	
}