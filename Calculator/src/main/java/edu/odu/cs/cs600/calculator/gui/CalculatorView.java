package edu.odu.cs.cs600.calculator.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;

import edu.odu.cs.cs600.calculator.CalculatorCharacter;
import edu.odu.cs.cs600.calculator.CalculatorCommand;
import edu.odu.cs.cs600.calculator.gui.button.CharacterInputButton;
import edu.odu.cs.cs600.calculator.gui.button.CommandButton;

public class CalculatorView extends JFrame {
	
	private static final long serialVersionUID = -2851779459457181013L;
	
	private List<ChangeListener> displayChangeListener = new ArrayList<ChangeListener> ();
	
	private ImagePanel panel;
	private JLabel display;
	
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
	
	public CalculatorView() 
	{
		super("Calculator");
		
		// Set defaults
		//this.setUndecorated(true); // Remove title bar
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initComponents();
		this.setContentPane(panel);
		this.setResizable(false);
		this.setSize(374, 562);
		this.setBackground(new Color(0,0,0));
		
		
		//this.pack();
	}
	
	private void initComponents() 
	{
		// Initialize the main panel
		URL imgURL = (Thread.currentThread().getContextClassLoader()).getResource("background.png");
		Image image = (new ImageIcon(imgURL)).getImage();
		panel = new ImagePanel(image);
				
		//GridBagLayout gbLayout = new GridBagLayout();
		//GridBagConstraints gbConstraints = new GridBagConstraints();
		
		//panel.setLayout(gbLayout);
		
		//constructDisplay(gbLayout, gbConstraints);
		//constructButtons(gbLayout, gbConstraints);
		
		initDisplay();
		initButtons();
	}
	
	private void initDisplay() 
	{
//		gbConstraints.fill = GridBagConstraints.BOTH;
//		gbConstraints.gridheight = 1;
//		gbConstraints.gridwidth = 5;
//		gbConstraints.weightx = 1.0;
//		gbConstraints.gridx = 0; gbConstraints.gridy = 0;
		
		display = new JLabel();
		display.setFont(new Font("Courier New", Font.BOLD, 42));
        display.setHorizontalAlignment(JLabel.RIGHT);
        display.setBounds(10, 70, 330, 30);
        //display.setText("123456789.123456");
        panel.add(display);
        
	}
	
	
	
	private void initButtons() 
	{
//        CommandButton onButton = new CommandButton("on.png", "On", CalculatorCommand.POWERON);
//        onButton.addActionListener(this.commandButtonActionListener);        
//		panel.add(onButton, gbConstraints);

//		
//		
//		

		// ROW 1
		
		CommandButton ceilingButton = new CommandButton("buttonCeiling.png", "buttonCeilingOver.png", "Ceiling", CalculatorCommand.CEILING);
		ceilingButton.setBounds(25, 118, 56, 56);
		ceilingButton.addActionListener(commandButtonActionListener);
		panel.add(ceilingButton);
		  
		CommandButton floorButton = new CommandButton("buttonFloor.png", "buttonFloorOver.png", "Floor", CalculatorCommand.FLOOR);
		floorButton.setBounds(91, 118, 56, 56);
		floorButton.addActionListener(commandButtonActionListener);
		panel.add(floorButton);
		  
		CommandButton reciprocalButton = new CommandButton("buttonReciprocal.png", "buttonReciprocalOver.png", "<html>1/x</html>", CalculatorCommand.RECIPROCAL);
		reciprocalButton.setBounds(156, 118, 56, 56);
		reciprocalButton.addActionListener(commandButtonActionListener);
		panel.add(reciprocalButton);
		
		CommandButton exponentiateButton = new CommandButton("buttonExponent.png", "buttonExponentOver.png", "<html>&radic;</html>", CalculatorCommand.EXPONENTIATE);
		exponentiateButton.setBounds(221, 118, 56, 56);
		exponentiateButton.addActionListener(commandButtonActionListener);
		panel.add(exponentiateButton);
		
		CommandButton clearEntryButton = new CommandButton("buttonClearEntry.png", "buttonClearEntryOver.png", "CE", CalculatorCommand.CLEAR, KeyEvent.VK_BACK_SPACE);
		clearEntryButton.setBounds(286, 118, 56, 56);
		clearEntryButton.addActionListener(commandButtonActionListener);
		panel.add(clearEntryButton);
		
		// ROW 2
		
		CommandButton negateButton = new CommandButton("buttonNegate.png", "buttonNegateOver.png", "<html>&plusmn;</html>", CalculatorCommand.NEGATE);
		negateButton.setBounds(25, 184, 56, 56);
		negateButton.addActionListener(commandButtonActionListener);
		panel.add(negateButton);
		
		CommandButton factorialButton = new CommandButton("buttonFactorial.png", "buttonFactorialOver.png", "<html>&radic;</html>", CalculatorCommand.FACTORIAL);
		factorialButton.setBounds(91, 184, 56, 56);
		factorialButton.addActionListener(commandButtonActionListener);
		panel.add(factorialButton);
		
		CommandButton squareRootButton = new CommandButton("buttonSquareRoot.png", "buttonSquareRootOver.png", "<html>&radic;</html>", CalculatorCommand.SQUAREROOT);
		squareRootButton.setBounds(156, 184, 56, 56);
		squareRootButton.addActionListener(commandButtonActionListener);
		panel.add(squareRootButton);
		
		CommandButton squaredButton = new CommandButton("buttonSquared.png", "buttonSquaredOver.png", "<html>&radic;</html>", CalculatorCommand.SQUARED);
		squaredButton.setBounds(221, 184, 56, 56);
		squaredButton.addActionListener(commandButtonActionListener);
		panel.add(squaredButton);
		
		CommandButton clearAllButton = new CommandButton("buttonClear.png", "buttonClearOver.png", "C", CalculatorCommand.CLEAR_ALL);
		clearAllButton.setBounds(286, 184, 56, 56);
		clearAllButton.addActionListener(commandButtonActionListener);
		panel.add(clearAllButton);
		
		// ROW 3
		
		CharacterInputButton sevenButton = new CharacterInputButton("button7.png", "button7over.png", new CalculatorCharacter('4'));
		sevenButton.setBounds(25, 250, 56, 56);
		sevenButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(sevenButton);

		CharacterInputButton eightButton = new CharacterInputButton("button8.png", "button8over.png", new CalculatorCharacter('5'));
		eightButton.setBounds(91, 250, 56, 56);
		eightButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(eightButton);
		
		CharacterInputButton nineButton = new CharacterInputButton("button9.png", "button9over.png", new CalculatorCharacter('6'));
		nineButton.setBounds(156, 250, 56, 56);
		nineButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(nineButton);
		
		CharacterInputButton addButton = new CharacterInputButton("buttonAdd.png", "buttonAddOver.png", new CalculatorCharacter('+'));
		addButton.setBounds(221, 250, 56, 56);
		addButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(addButton);

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
		
		CharacterInputButton subtractButton = new CharacterInputButton("buttonSubtract.png", "buttonSubtractOver.png", new CalculatorCharacter('-'));
		subtractButton.setBounds(221, 316, 56, 56);
		subtractButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(subtractButton);

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
		
		CharacterInputButton multiplyButton = new CharacterInputButton("buttonMultiply.png", "buttonMultiplyOver.png", new CalculatorCharacter('*', "&times;"));
		multiplyButton.setBounds(221, 382, 56, 56);
		multiplyButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(multiplyButton);

		CommandButton equalsButton = new CommandButton("buttonEqual.png", "buttonEqualOver.png", "=", CalculatorCommand.EVALUATE);
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
		
		CharacterInputButton divideButton = new CharacterInputButton("buttonDivide.png", "buttonDivideOver.png", new CalculatorCharacter('/', "&divide;"));
		divideButton.setBounds(221, 448, 56, 56);
		divideButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(divideButton);
	}  
	
	
	
	public JLabel getDisplay() {
		return display;
	}  // end getDisplay()
	
	
	
	public void setDisplay(String string) {
		display.setText(string);
	}  // end setDisplay(String)
	
	public void addCharacterInputButtonListener(ActionListener listener)
	{
		this.characterInputButtonActionListeners.add(listener);
	}
	
	public void addCommandButtonListener(ActionListener listener)
	{
		this.commandButtonActionListeners.add(listener);
	}
	
	
	
	public void addPhraseChangeListener(ChangeListener listener)
	{
		this.displayChangeListener.add(listener);
	}
}  