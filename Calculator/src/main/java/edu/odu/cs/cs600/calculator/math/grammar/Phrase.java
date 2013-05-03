package edu.odu.cs.cs600.calculator.math.grammar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import edu.odu.cs.cs600.calculator.CalculatorCharacter;

/**
 * Class to support the internal characters representing the {@link edu.odu.cs.cs600.calculator.math.grammar.expressions.Expression} to be
 * parsed.  These characters are represented as an {@link ArrayList} of {@link CalculatorCharacter}s.
 */
public class Phrase 
{
	private static final String CHARS_ALLOWING_ZERO = ".+*-/^";
	
	private List<CalculatorCharacter> characterList = new ArrayList <CalculatorCharacter> ();
	private List<PhraseChangeListener> phraseChangeListeners = new ArrayList<PhraseChangeListener> ();
	
	
	/**
	 * Constructor
	 */
	public Phrase() {
		clear();
	}
	
	
	/**
	 * Private constructor accepting a {@list
	 * @param characterList
	 */
	private Phrase(List<CalculatorCharacter> characterList) {
		this.characterList = characterList;
	}
	
	
	/**
	 * Adds the passed {@link PhraseChangeListener} to the current list of listeners
	 * notified when this Phrase changes
	 * @param listener The {@link PhraseChangeListener} to add
	 */
	public void addChangeListener(PhraseChangeListener listener) {
		phraseChangeListeners.add(listener);
	}
	
	
	/**
	 * Remove the passed {@link PhraseChangeListener} from the current list of
	 * listeners notified when this Phrase changes
	 * @param listener
	 */
	public void removeChangeListener(PhraseChangeListener listener) {
		phraseChangeListeners.remove(listener);
	}
	
	
	/**
	 * Remove all {@link PhraseChangeListener}s attributed to this Phrase
	 */
	public void clearChangeListeners() {
		phraseChangeListeners.clear();
	}
	
	
	/**
	 * Notify all registered {@link PhraseChangeListeners} of a change to this
	 * Phrase
	 */
	private void fireChangeEvent() {
		for (PhraseChangeListener listener : phraseChangeListeners) {
			listener.phraseChanged(this);
		}
	}
	
	
	/**
	 * Returns a {@link String} representation of this Phrase.  If true is passed, the String
	 * is wrapped in HTML tags and ISO codes are used for any {@link CalculatorCharacter}s
	 * which have them.  If false is passed, the returned String contains solely
	 * single-character representations for each CalculatorCharacter (for use in parsing when
	 * passed to a mathematical method).
	 * @param htmlEncode true to wrap the returned {@link String} with HTML tags and utilize
	 * the ISO encoding of any {@link CalculatorCharacter}s which have them
	 * @return A string representation of the phrase
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
	
	
	/**
	 * Returns the non-ISO character representation of the list of
	 * {@link CalculatorCharacter}s contained by this Phrase
	 */
	@Override
	public String toString() {
		return toString(false);
	}
	
	
	/**
	 * Add a {@link CalculatorCharacter} to this Phrase. {@link #fireChangeEvent()}
	 * is called to notify the list of {@link PhraseChangeListener}s.
	 * @param cc The {@link CalculatorCharacter} to append to this Phrase
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
	 * Remove a {@link CalculatorCharacter} from this Phrase.  {@link #fireChangeEvent()}
	 * is called to notify the list of {@link PhraseChangeListener}s.
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
	 * Clears the list of {@link CalculatorCharacter}s which make up this Phrase.
	 * An empty Phrase is represented by a single '0'.  {@link #fireChangeEvent()}
	 * is called to notify the list of {@link PhraseChangeListener}s.
	 */
	public void clear() {
		characterList.clear();
		characterList.add(new CalculatorCharacter('0'));
		
		fireChangeEvent();
	}
	
	
	/**
	 * Utility function to return a new Phrase containing the list of
	 * {@link CalculatorCharacter}s representing the passed {@link String}.
	 * @param phrase The {@link String} to convert
	 * @return A new Phrase containing the converted {@link String}
	 */
	public static Phrase convertToPhrase(String phrase) {
		List<CalculatorCharacter> charList = generateCharacterList(phrase);
		Phrase p = new Phrase(charList);
		
		return p;
	}
	
	
	/**
	 * Utility function to return a new Phrase containing the list of
	 * {@link CalculatorCharacter}s representing of the passed double.
	 * @param value The double to convert
	 * @return A new Phrase containing the converted double
	 */
	public static Phrase convertToPhrase(double value) {
		DecimalFormat df = new DecimalFormat("#.##########");
		return Phrase.convertToPhrase(df.format(value));
	}
	
	
	/**
	 * Returns an {@link ArrayList} of {@link CalculatorCharacter}s representing
	 * the passed {@link String}.
	 * @param stringPhrase The {@link String} to convert into {@link CalculatorCharacter}s
	 * @return A new {@link ArrayList} of {@link CalculatorCharacter}s representing
	 * the passed {@link String}
	 */
	private static List<CalculatorCharacter> generateCharacterList(String stringPhrase) {
		List<CalculatorCharacter> result = new ArrayList<CalculatorCharacter>();
		
		for (int i = 0; i < stringPhrase.length(); i++) {
			result.add(new CalculatorCharacter(stringPhrase.charAt(i)));
		}
		
		return result;
	}
	
}