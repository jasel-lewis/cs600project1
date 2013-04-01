package edu.odu.cs.cs600.calculator.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CalculatorView extends JFrame {
	private static final long serialVersionUID = -2851779459457181013L;
	
	private JPanel panel = new JPanel();
	private JLabel display = new JLabel();
	private FunctionButton equalsButton = null;
	
	public CalculatorView() {
		super("Calculator");
		
		// Set defaults
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initComponents();
		this.setContentPane(panel);
		this.setResizable(false);
		this.pack();
	}
	
	
	
	private void initComponents() {
		GridBagLayout gbLayout = new GridBagLayout();
		GridBagConstraints gbConstraints = new GridBagConstraints();
		
		this.setLayout(gbLayout);
		
		panel.add(constructDisplay(gbLayout, gbConstraints));
		constructButtons(gbLayout, gbConstraints);
	}
	
	
	
	private JLabel constructDisplay(GridBagLayout gbLayout, GridBagConstraints gbConstraints) {
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.gridheight = 1;
		gbConstraints.gridwidth = 5;
		gbConstraints.weightx = 1.0;
		gbConstraints.gridx = 0; gbConstraints.gridy = 0;
		
		display.setFont(new Font("Courier New", Font.BOLD, 36));
		display.setForeground(Color.DARK_GRAY);
        display.setHorizontalAlignment(JLabel.RIGHT);
        
        gbLayout.setConstraints(display, gbConstraints);
		
		return display;
	}  // end generateDisplay(GridBagLayout)
	
	
	
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
        //gbLayout.setConstraints(obCeiling, gbConstraints);
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
		panel.add(new CharacterButton("parenthesis_left.png", '('), gbConstraints);
		
        gbConstraints.gridx = 1; gbConstraints.gridy = 2;
        panel.add(new CharacterButton("parenthesis_right.png", ')'), gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 2;
		FunctionButton obSquareRoot = new FunctionButton("square_root.png", "<html>&radic;</html>", KeyEvent.VK_UNDEFINED);
		panel.add(obSquareRoot, gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 2;
		gbConstraints.gridwidth = 2;
		FunctionButton obOff = new FunctionButton("off.png", "Off", KeyEvent.VK_UNDEFINED);
		panel.add(obOff, gbConstraints);
		
		gbConstraints.gridwidth = 1;  // reset
		
        gbConstraints.gridx = 0; gbConstraints.gridy = 3;
		panel.add(new CharacterButton("7.png", '7'), gbConstraints);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 3;
		panel.add(new CharacterButton("8.png", '8'), gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 3;
		panel.add(new CharacterButton("9.png", '9'), gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 3;
		panel.add(new OperatorButton("divide.png", "&divide;", '/'), gbConstraints);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 3;
		FunctionButton obClearEntry = new FunctionButton("clear_entry.png", "CE", KeyEvent.VK_BACK_SPACE);
		panel.add(obClearEntry, gbConstraints);
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 4;
		panel.add(new CharacterButton("4.png", '4'), gbConstraints);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 4;
		panel.add(new CharacterButton("5.png", '5'), gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 4;
		panel.add(new CharacterButton("6.png", '6'), gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 4;
		panel.add(new OperatorButton("multiply.png", "&times;", '*'), gbConstraints);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 4;
		FunctionButton obClearAll = new FunctionButton("clear_all.png", "C", KeyEvent.VK_UNDEFINED);
		panel.add(obClearAll, gbConstraints);
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 5;
		panel.add(new CharacterButton("1.png", '1'), gbConstraints);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 5;
		panel.add(new CharacterButton("2.png", '2'), gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 5;
		panel.add(new CharacterButton("3.png", '3'), gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 5;
		panel.add(new OperatorButton("subtract.png", "-", '-'), gbConstraints);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 5;
		gbConstraints.gridheight = 2;
		this.equalsButton = new FunctionButton("equal.png", "=", KeyEvent.VK_UNDEFINED);
		panel.add(this.equalsButton, gbConstraints);
		
		gbConstraints.gridheight = 1;  // reset
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 6;
		panel.add(new CharacterButton("0.png", '0'), gbConstraints);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 6;
		panel.add(new CharacterButton("decimal.png", '.'), gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 6;
		FunctionButton obNegate = new FunctionButton("negate.png", "<html>&plusmn;</html>", KeyEvent.VK_UNDEFINED);
		panel.add(obNegate, gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 6;
		panel.add(new OperatorButton("add.png", "+", '+'), gbConstraints);
		
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
	
	
	
	public void addEvaluateButtonClickListener(ActionListener listener)
	{
		this.equalsButton.addActionListener(listener);
	}
}  // end class CalculatorView
