package edu.odu.cs.cs600.calculator.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.odu.cs.cs600.calculator.gui.button.CharacterInputButton;
import edu.odu.cs.cs600.calculator.gui.button.FunctionButton;

public class CalculatorView extends JFrame {
	private static final long serialVersionUID = -2851779459457181013L;
	
	private JPanel panel = new JPanel();
	private JLabel display = new JLabel("0");
	
	private List<ActionListener> characterInputButtonActionListeners = new ArrayList<ActionListener>();
	private ActionListener characterInputButtonActionListener = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			for(ActionListener listener : characterInputButtonActionListeners)
				listener.actionPerformed(e);
		}
	};
	
	private List<ActionListener> functionButtonActionListeners = new ArrayList<ActionListener>();
	private ActionListener functionButtonActionListener = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			for(ActionListener listener : functionButtonActionListeners)
				listener.actionPerformed(e);
		}
	};
	
	public CalculatorView() 
	{
		super("Calculator");
		
		// Set defaults
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initComponents();
		this.setContentPane(panel);
		this.setResizable(false);
		this.pack();
	}
	
	private void initComponents() 
	{
		GridBagLayout gbLayout = new GridBagLayout();
		GridBagConstraints gbConstraints = new GridBagConstraints();
		
		panel.setLayout(gbLayout);
		
		initSharedListeners();
		constructDisplay(gbLayout, gbConstraints);
		constructButtons(gbLayout, gbConstraints);
	}
	
	private void initSharedListeners()
	{
	}
	
	private void constructDisplay(GridBagLayout gbLayout, GridBagConstraints gbConstraints) 
	{
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.gridheight = 1;
		gbConstraints.gridwidth = 5;
		gbConstraints.weightx = 1.0;
		gbConstraints.gridx = 0; gbConstraints.gridy = 0;
		
		display.setFont(new Font("Courier New", Font.BOLD, 36));
		display.setForeground(Color.DARK_GRAY);
        display.setHorizontalAlignment(JLabel.RIGHT);
        
        panel.add(display, gbConstraints);
	}
	
	
	
	private void constructButtons(GridBagLayout gbLayout, GridBagConstraints gbConstraints) {
        gbConstraints.fill = GridBagConstraints.BOTH;
        gbConstraints.gridheight = 1;
        gbConstraints.gridwidth = 1;
        gbConstraints.weightx = 1.0;
        
        // Annoying, but in order to get the "=" button to span two rows on the far right, we have
        // to set the gridx and gridy for each component (this is listed as a best practice, anyway,
        // in the Swing tutorial (http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html)
        
        gbConstraints.gridx = 0; gbConstraints.gridy = 1;
        FunctionButton obCeiling = new FunctionButton("ceiling.png", "Ceiling", KeyEvent.VK_UNDEFINED);
        panel.add(obCeiling, gbConstraints);
        
        gbConstraints.gridx = 1; gbConstraints.gridy = 1;
        FunctionButton obFloor = new FunctionButton("floor.png", "Floor", KeyEvent.VK_UNDEFINED);
        panel.add(obFloor, gbConstraints);
        
        gbConstraints.gridx = 2; gbConstraints.gridy = 1;
        FunctionButton obReciprocal = new FunctionButton("reciprocal.png", "<html>1/x</html>", KeyEvent.VK_UNDEFINED);
        panel.add(obReciprocal, gbConstraints);
        
        gbConstraints.gridx = 3; gbConstraints.gridy = 1;
        gbConstraints.gridwidth = 2;
        FunctionButton obOn = new FunctionButton("on.png", "On", KeyEvent.VK_UNDEFINED);
		panel.add(obOn, gbConstraints);
		
		gbConstraints.gridwidth = 1;  // reset
		
        gbConstraints.gridx = 0; gbConstraints.gridy = 2;
        CharacterInputButton leftParenthesisButton = new CharacterInputButton("parenthesis_left.png", new CalculatorCharacter('('));
        leftParenthesisButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(leftParenthesisButton, gbConstraints);
		
        gbConstraints.gridx = 1; gbConstraints.gridy = 2;
        CharacterInputButton rightParenthesisButton = new CharacterInputButton("parenthesis_right.png", new CalculatorCharacter(')'));
        rightParenthesisButton.addActionListener(this.characterInputButtonActionListener);
        panel.add(rightParenthesisButton, gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 2;
		FunctionButton obSquareRoot = new FunctionButton("square_root.png", "<html>&radic;</html>", KeyEvent.VK_UNDEFINED);
		panel.add(obSquareRoot, gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 2;
		gbConstraints.gridwidth = 2;
		FunctionButton obOff = new FunctionButton("off.png", "Off", KeyEvent.VK_UNDEFINED);
		panel.add(obOff, gbConstraints);
		
		gbConstraints.gridwidth = 1;  // reset
		
        gbConstraints.gridx = 0; gbConstraints.gridy = 3;
        CharacterInputButton sevenButton = new CharacterInputButton("7.png", new CalculatorCharacter('7'));
        sevenButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(sevenButton, gbConstraints);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 3;
		CharacterInputButton eightButton = new CharacterInputButton("8.png", new CalculatorCharacter('8'));
		eightButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(eightButton, gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 3;
		CharacterInputButton nineButton = new CharacterInputButton("9.png", new CalculatorCharacter('9'));
		nineButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(nineButton, gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 3;
		CharacterInputButton divideButton = new CharacterInputButton("divide.png", new CalculatorCharacter('/', "&divide;"));
		divideButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(divideButton, gbConstraints);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 3;
		FunctionButton obClearEntry = new FunctionButton("clear_entry.png", "CE", KeyEvent.VK_BACK_SPACE);
		panel.add(obClearEntry, gbConstraints);
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 4;
		CharacterInputButton fourButton = new CharacterInputButton("4.png", new CalculatorCharacter('4'));
		fourButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(fourButton, gbConstraints);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 4;
		CharacterInputButton fiveButton = new CharacterInputButton("5.png", new CalculatorCharacter('5'));
		fiveButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(fiveButton, gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 4;
		CharacterInputButton sixButton = new CharacterInputButton("6.png", new CalculatorCharacter('6'));
		sixButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(sixButton, gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 4;
		CharacterInputButton multiplyButton = new CharacterInputButton("multiply.png", new CalculatorCharacter('*'));
		multiplyButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(multiplyButton, gbConstraints);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 4;
		FunctionButton obClearAll = new FunctionButton("clear_all.png", "C", KeyEvent.VK_UNDEFINED);
		panel.add(obClearAll, gbConstraints);
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 5;
		CharacterInputButton oneButton = new CharacterInputButton("1.png", new CalculatorCharacter('1'));
		oneButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(oneButton, gbConstraints);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 5;
		CharacterInputButton twoButton = new CharacterInputButton("2.png", new CalculatorCharacter('2'));
		twoButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(twoButton, gbConstraints);

		gbConstraints.gridx = 2; gbConstraints.gridy = 5;
		CharacterInputButton threeButton = new CharacterInputButton("3.png", new CalculatorCharacter('3'));
		threeButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(threeButton, gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 5;
		CharacterInputButton subtractButton = new CharacterInputButton("subtract.png", new CalculatorCharacter('-'));
		subtractButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(subtractButton, gbConstraints);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 5;
		gbConstraints.gridheight = 2;
		FunctionButton equalsButton = new FunctionButton("equal.png", "=", KeyEvent.VK_UNDEFINED);
		panel.add(equalsButton, gbConstraints);
		
		gbConstraints.gridheight = 1;  // reset
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 6;
		CharacterInputButton zeroButton = new CharacterInputButton("0.png", new CalculatorCharacter('0'));
		zeroButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(zeroButton, gbConstraints);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 6;
		CharacterInputButton decimalButton = new CharacterInputButton("decimal.png", new CalculatorCharacter('.'));
		decimalButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(decimalButton, gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 6;
		FunctionButton obNegate = new FunctionButton("negate.png", "<html>&plusmn;</html>", KeyEvent.VK_UNDEFINED);
		panel.add(obNegate, gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 6;
		CharacterInputButton addButton = new CharacterInputButton("add.png", new CalculatorCharacter('+'));
		addButton.addActionListener(this.characterInputButtonActionListener);
		panel.add(addButton, gbConstraints);
		
		// Reset values
		gbConstraints.gridwidth = 1;
		gbConstraints.gridheight = 1;
	}  // end GenerateButtons(GridBagLayout)
	
	
	
	public JLabel getDisplay() {
		return display;
	}  // end getDisplay()
	
	
	
	public void updateDisplay(String string) {
		display.setText(string);
	}  // end updateDisplay(String)
	
	public void addCharacterInputButtonListener(ActionListener listener)
	{
		this.characterInputButtonActionListeners.add(listener);
	}
	
	public void addFunctionButtonListener(ActionListener listener)
	{
		this.functionButtonActionListeners.add(listener);
	}
	
	
	
}  
