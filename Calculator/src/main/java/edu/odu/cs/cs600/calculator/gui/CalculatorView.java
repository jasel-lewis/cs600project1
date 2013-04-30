package edu.odu.cs.cs600.calculator.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

import edu.odu.cs.cs600.calculator.CalculatorCharacter;
import edu.odu.cs.cs600.calculator.CalculatorCommand;
import edu.odu.cs.cs600.calculator.gui.button.CharacterInputButton;
import edu.odu.cs.cs600.calculator.gui.button.CommandButton;

/**
 * This class is the View of the MVC framework employed for this project
 */
public class CalculatorView extends JFrame {
	
	private static final long serialVersionUID = -2851779459457181013L;
	
	private List<ChangeListener> displayChangeListener = new ArrayList<ChangeListener> ();
	
	private ImagePanel panel;
	private JLabel activeDisplay;
	private JLabel historyDisplay;
	private CommandButton powerToggleButton;
	
	private List<ActionListener> characterInputButtonActionListeners = new ArrayList<ActionListener>();
	private ActionListener characterInputButtonActionListener = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			for(ActionListener listener : characterInputButtonActionListeners)
				listener.actionPerformed(e);
		}
	};
	
	private List<ActionListener> commandButtonActionListeners = new ArrayList<ActionListener>();
	private ActionListener commandButtonActionListener = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			for(ActionListener listener : commandButtonActionListeners)
				listener.actionPerformed(e);
		}
	};
	
	
	/**
	 * Constructor
	 */
	public CalculatorView() 
	{
		super("World's Cheapest Calculator");
			
		initComponents();
	}
	
	
	/**
	 * Initialize the components of this CalculatorView (panel, labels, buttons and specific
	 * parameters)
	 */
	private void initComponents() 
	{
		// Initialize the main panel
		URL imgURL = (Thread.currentThread().getContextClassLoader()).getResource("background.png");
		Image image = (new ImageIcon(imgURL)).getImage();
		panel = new ImagePanel(image);
		
		initDisplay();
		initButtons();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setResizable(false);
		this.setSize(374, 562);
		this.setBackground(new Color(0,0,0));
	}
	
	
	/**
	 * Create, initialize and add the displays, current (non-historical) and historical, to
	 * the view.  Both displays are underlying {@link JLabel}s.
	 */
	private void initDisplay() 
	{	
		activeDisplay = new JLabel();
		activeDisplay.setFont(new Font("Courier New", Font.BOLD, 42));
		activeDisplay.setVerticalAlignment(SwingConstants.CENTER);
        activeDisplay.setBounds(28, 68, 312, 32);
        panel.add(activeDisplay);
        
        historyDisplay = new JLabel();
        historyDisplay.setFont(new Font("Courier New", Font.PLAIN, 22));
        historyDisplay.setBounds(28, 26, 312, 25);
        panel.add(historyDisplay);
	}
	
	
	/**
	 * Create, initialize and add {@link CommandButton}s and {@link CharacterInputButton}s
	 * to the view
	 */
	private void initButtons() 
	{
		// ROW 1
		
		powerToggleButton = new CommandButton("buttonPowerOn.png", "buttonPowerOnOver.png", CalculatorCommand.POWERTOGGLE);
		powerToggleButton.setBounds(25, 118, 56, 56);
		powerToggleButton.addActionListener(commandButtonActionListener);
		panel.add(powerToggleButton);
		
		CommandButton squareRootButton = new CommandButton("buttonSquareRoot.png", "buttonSquareRootOver.png", CalculatorCommand.SQUAREROOT);
		squareRootButton.setBounds(91, 118, 56, 56);
		squareRootButton.addActionListener(commandButtonActionListener);
		panel.add(squareRootButton);
		
		CommandButton squaredButton = new CommandButton("buttonSquared.png", "buttonSquaredOver.png", CalculatorCommand.SQUARE);
		squaredButton.setBounds(156, 118, 56, 56);
		squaredButton.addActionListener(commandButtonActionListener);
		panel.add(squaredButton);
		
		CharacterInputButton exponentiateButton = new CharacterInputButton("buttonExponent.png", "buttonExponentOver.png", new CalculatorCharacter('^'));
		exponentiateButton.setBounds(221, 118, 56, 56);
		exponentiateButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(exponentiateButton);
		
		CommandButton clearEntryButton = new CommandButton("buttonClearEntry.png", "buttonClearEntryOver.png", CalculatorCommand.CLEAR, KeyEvent.VK_BACK_SPACE);
		clearEntryButton.setBounds(286, 118, 56, 56);
		clearEntryButton.addActionListener(commandButtonActionListener);
		panel.add(clearEntryButton);
		
		// ROW 2
		
		CommandButton factorialButton = new CommandButton("buttonFactorial.png", "buttonFactorialOver.png", CalculatorCommand.FACTORIAL);
		factorialButton.setBounds(25, 184, 56, 56);
		factorialButton.addActionListener(commandButtonActionListener);
		panel.add(factorialButton);
		
		CommandButton reciprocalButton = new CommandButton("buttonReciprocal.png", "buttonReciprocalOver.png", CalculatorCommand.RECIPROCAL);
		reciprocalButton.setBounds(91, 184, 56, 56);
		reciprocalButton.addActionListener(commandButtonActionListener);
		panel.add(reciprocalButton);
		
		CommandButton ceilingButton = new CommandButton("buttonCeiling.png", "buttonCeilingOver.png", CalculatorCommand.CEILING);
		ceilingButton.setBounds(156, 184, 56, 56);
		ceilingButton.addActionListener(commandButtonActionListener);
		panel.add(ceilingButton);
		  
		CommandButton floorButton = new CommandButton("buttonFloor.png", "buttonFloorOver.png", CalculatorCommand.FLOOR);
		floorButton.setBounds(221, 184, 56, 56);
		floorButton.addActionListener(commandButtonActionListener);
		panel.add(floorButton);
		
		CommandButton clearAllButton = new CommandButton("buttonClear.png", "buttonClearOver.png", CalculatorCommand.CLEAR_ALL);
		clearAllButton.setBounds(286, 184, 56, 56);
		clearAllButton.addActionListener(commandButtonActionListener);
		panel.add(clearAllButton);
		
		// ROW 3
		
		CharacterInputButton sevenButton = new CharacterInputButton("button7.png", "button7over.png", new CalculatorCharacter('7'));
		sevenButton.setBounds(25, 250, 56, 56);
		sevenButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(sevenButton);

		CharacterInputButton eightButton = new CharacterInputButton("button8.png", "button8over.png", new CalculatorCharacter('8'));
		eightButton.setBounds(91, 250, 56, 56);
		eightButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(eightButton);
		
		CharacterInputButton nineButton = new CharacterInputButton("button9.png", "button9over.png", new CalculatorCharacter('9'));
		nineButton.setBounds(156, 250, 56, 56);
		nineButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(nineButton);
		
		CharacterInputButton divideButton = new CharacterInputButton("buttonDivide.png", "buttonDivideOver.png", new CalculatorCharacter('/', "&divide;"));
		divideButton.setBounds(221, 250, 56, 56);
		divideButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(divideButton);

		CharacterInputButton leftParenthesisButton = new CharacterInputButton("buttonParenLeft.png", "buttonParenLeftOver.png", new CalculatorCharacter('('));
		leftParenthesisButton.setBounds(286, 250, 56, 56);
		leftParenthesisButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(leftParenthesisButton);
		
		// ROW 4
		
		CharacterInputButton fourButton = new CharacterInputButton("button4.png", "button4over.png", new CalculatorCharacter('4'));
		fourButton.setBounds(25, 316, 56, 56);
		fourButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(fourButton);

		CharacterInputButton fiveButton = new CharacterInputButton("button5.png", "button5over.png", new CalculatorCharacter('5'));
		fiveButton.setBounds(91, 316, 56, 56);
		fiveButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(fiveButton);
		
		CharacterInputButton sixButton = new CharacterInputButton("button6.png", "button6over.png", new CalculatorCharacter('6'));
		sixButton.setBounds(156, 316, 56, 56);
		sixButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(sixButton);
		
		CharacterInputButton multiplyButton = new CharacterInputButton("buttonMultiply.png", "buttonMultiplyOver.png", new CalculatorCharacter('*', "&times;"));
		multiplyButton.setBounds(221, 316, 56, 56);
		multiplyButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(multiplyButton);

		CharacterInputButton rightParenthesisButton = new CharacterInputButton("buttonParenRight.png", "buttonParenRightOver.png", new CalculatorCharacter(')'));
		rightParenthesisButton.setBounds(286, 316, 56, 56);
		rightParenthesisButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(rightParenthesisButton);
		
		// ROW 5
		
		CharacterInputButton oneButton = new CharacterInputButton("button1.png", "button1over.png", new CalculatorCharacter('1'));
		oneButton.setBounds(25, 382, 56, 56);
		oneButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(oneButton);
		
		CharacterInputButton twoButton = new CharacterInputButton("button2.png", "button2over.png", new CalculatorCharacter('2'));
		twoButton.setBounds(91, 382, 56, 56);
		twoButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(twoButton);

		CharacterInputButton threeButton = new CharacterInputButton("button3.png", "button3over.png", new CalculatorCharacter('3'));
		threeButton.setBounds(156, 382, 56, 56);
		threeButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(threeButton);
		
		CharacterInputButton subtractButton = new CharacterInputButton("buttonSubtract.png", "buttonSubtractOver.png", new CalculatorCharacter('-'));
		subtractButton.setBounds(221, 382, 56, 56);
		subtractButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(subtractButton);

		CommandButton equalsButton = new CommandButton("buttonEqual.png", "buttonEqualOver.png", CalculatorCommand.EVALUATE, KeyEvent.VK_ENTER);
		equalsButton.setBounds(286, 382, 56, 122);
		equalsButton.addActionListener(commandButtonActionListener);
		panel.add(equalsButton);
		
		// ROW 6
		
		CharacterInputButton zeroButton = new CharacterInputButton("button0.png", "button0over.png", new CalculatorCharacter('0'));
		zeroButton.setBounds(25, 448, 56, 56);
		zeroButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(zeroButton);
		
		CharacterInputButton decimalButton = new CharacterInputButton("buttonDecimal.png", "buttonDecimalOver.png", new CalculatorCharacter('.'));
		decimalButton.setBounds(91, 448, 56, 56);
		decimalButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(decimalButton);
		
		CommandButton negateButton = new CommandButton("buttonNegate.png", "buttonNegateOver.png", CalculatorCommand.NEGATE);
		negateButton.setBounds(156, 448, 56, 56);
		negateButton.addActionListener(commandButtonActionListener);
		panel.add(negateButton);
		
		CharacterInputButton addButton = new CharacterInputButton("buttonAdd.png", "buttonAddOver.png", new CalculatorCharacter('+'));
		addButton.setBounds(221, 448, 56, 56);
		addButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(addButton);
	}  
	
	/**
	 * Sets the images used for the power button.
	 * @param imageFilename Path to an image to use for the button
	 * @param imageOverFilename Path to an image to use for the button when hovered or pressed
	 */
	public void setPowerToggleButtonImages(String imageFilename, String imageOverFilename) {
		this.powerToggleButton.setIcon(imageFilename);
		this.powerToggleButton.setPressedIcon(imageOverFilename);
	}
	
	
	/**
	 * Show the passed {@link String} in the current (non-historical) display
	 * @param string
	 */
	public void setActiveDisplayText(String string) {
		activeDisplay.setText(string);
	}
	
	/**
	 * Sets the visibility of the active display
	 * @param boolean The visibility of the active display
	 */
	public void setActiveDisplayVisible(boolean visible) {
		activeDisplay.setVisible(visible);
	}
	
	/**
	 * Show the passed {@link String} in the historical display
	 * @param string
	 */
	public void setHistoryDisplayText(String string) {
		historyDisplay.setText(string);
	}
	
	/**
	 * Sets the visibility of the historical display
	 * @param boolean The visibility of the historical display
	 */
	public void setHistoryDisplayVisible(boolean visible) {
		historyDisplay.setVisible(visible);
	}
	
	/**
	 * Apply the passed {@link ActionListener} to the list of {@link CharacterInputButton}
	 * listeners for this CalculatorView
	 * @param listener
	 */
	public void addCharacterInputButtonListener(ActionListener listener) {
		this.characterInputButtonActionListeners.add(listener);
	}
	
	
	/**
	 * Apply the passed {@link ActionListener} to the list of {@link CommandButton}
	 * listeners for this CalculatorView
	 * @param listener
	 */
	public void addCommandButtonListener(ActionListener listener) {
		this.commandButtonActionListeners.add(listener);
	}
	
	
	/**
	 * Apply the passed {@link ChangeListener} to the list of display listeners
	 * for this CalculatorView
	 * @param listener
	 */
	public void addPhraseChangeListener(ChangeListener listener) {
		this.displayChangeListener.add(listener);
	}
}  