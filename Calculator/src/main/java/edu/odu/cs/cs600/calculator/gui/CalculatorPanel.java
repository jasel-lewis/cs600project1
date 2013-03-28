package edu.odu.cs.cs600.calculator.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import edu.odu.cs.cs600.calculator.Phrase;

public class CalculatorPanel extends JPanel {

	private static final long serialVersionUID = -2691106243294969972L;
	
	private Phrase phrase;
	private JRootPane jRootPane;
	
	private JButton jb0, jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jbDecimal;
	private JButton jbOpenParen, jbCloseParen;
	private JButton jbAdd, jbSubtract, jbMultiply, jbDivide, jbEquals;
	private JButton jbNegate, jbReciprocal, jbSquareRoot, jbCeiling, jbFloor;
	private JButton jbOn, jbOff, jbClearEntry, jbClearAll;

	public CalculatorPanel(Phrase phrase, JRootPane jRootPane) {
		GridBagLayout gbLayout = new GridBagLayout();
		JLabel display = new JLabel();
		
		this.setLayout(gbLayout);
		
		this.jRootPane = jRootPane;
		
		this.phrase = phrase;
		phrase.setDisplay(display);
		
		generateDisplay(gbLayout, display);
		generateButtons(gbLayout);
	}  // end constructor CalculatorPanel()
	
	
	
	private void generateDisplay(GridBagLayout gbLayout, JLabel display) {
		GridBagConstraints gbConstraints = new GridBagConstraints();
		
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.gridheight = 1;
		gbConstraints.gridwidth = 5;
		gbConstraints.weightx = 1.0;
		gbConstraints.gridx = 0; gbConstraints.gridy = 0;
		
		gbLayout.setConstraints(display, gbConstraints);
		
        display.setFont(new Font("Courier New", Font.BOLD, 36));
        display.setText("0");
        display.setHorizontalAlignment(JLabel.RIGHT);
        
        this.add(display);
	}  // end generateDisplay(GridBagLayout)

	
	
	private void generateButtons(GridBagLayout gbLayout) {
        GridBagConstraints gbConstraints = new GridBagConstraints();
        ButtonFactory bf = new ButtonFactory(gbLayout, gbConstraints, phrase, jRootPane);
        
        gbConstraints.fill = GridBagConstraints.BOTH;
        gbConstraints.gridheight = 1;
        gbConstraints.gridwidth = 1;
        gbConstraints.weightx = 1.0;
        
        // Annoying, but in order to get the "=" button to span two rows on the far right, we have
        // to set the gridx and gridy for each component (this is listed as a best practice, anyway,
        // in the Swing tutorial (http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html)
        
        gbConstraints.gridx = 0; gbConstraints.gridy = 1;
        jbCeiling = bf.createButton(ButtonFactory.UNARY, "ceiling.png", "Ceiling", 'u');
        this.add(jbCeiling);
        
        gbConstraints.gridx = 1; gbConstraints.gridy = 1;
        jbFloor = bf.createButton(ButtonFactory.UNARY, "floor.png", "Floor", 'u');
        this.add(jbFloor);
        
        gbConstraints.gridx = 2; gbConstraints.gridy = 1;
        jbReciprocal = bf.createButton(ButtonFactory.UNARY, "reciprocal.png", "<html>1/x</html>", 'u');
        this.add(jbReciprocal);
        
        gbConstraints.gridx = 3; gbConstraints.gridy = 1;
        gbConstraints.gridwidth = 2;
		jbOn = bf.createButton(ButtonFactory.ON, "on.png", "On", 'u');
		this.add(jbOn);
		
		gbConstraints.gridwidth = 1;  // reset
        
        gbConstraints.gridx = 0; gbConstraints.gridy = 2;
		jbOpenParen = bf.createButton(ButtonFactory.MORPHEME, "parenthesis_left.png", "(", '(');
		this.add(jbOpenParen);
		
        gbConstraints.gridx = 1; gbConstraints.gridy = 2;
        jbCloseParen = bf.createButton(ButtonFactory.MORPHEME, "parenthesis_right.png", ")", ')');
        this.add(jbCloseParen);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 2;
		jbSquareRoot = bf.createButton(ButtonFactory.UNARY, "square_root.png", "<html>&radic;</html>", 'u');
		this.add(jbSquareRoot);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 2;
		gbConstraints.gridwidth = 2;
		jbOff = bf.createButton(ButtonFactory.OFF, "off.png", "Off", 'u');
		this.add(jbOff);
		
		gbConstraints.gridwidth = 1;  // reset
		
        gbConstraints.gridx = 0; gbConstraints.gridy = 3;
		jb7 = bf.createButton(ButtonFactory.MORPHEME, "7.png", "7", '7');
		this.add(jb7);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 3;
		jb8 = bf.createButton(ButtonFactory.MORPHEME, "8.png", "8", '8');
		this.add(jb8);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 3;
		jb9 = bf.createButton(ButtonFactory.MORPHEME, "9.png", "9", '9');
		this.add(jb9);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 3;
		jbDivide = bf.createButton(ButtonFactory.BINARY, "divide.png", "<html>&divide;</html>", '/');
		this.add(jbDivide);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 3;
		jbClearEntry = bf.createButton(ButtonFactory.CLEAR_ENTRY, "clear_entry.png", "CE", 'u');
		this.add(jbClearEntry);
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 4;
		jb4 = bf.createButton(ButtonFactory.MORPHEME, "4.png", "4", '4');
		this.add(jb4);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 4;
		jb5 = bf.createButton(ButtonFactory.MORPHEME, "5.png", "5", '5');
		this.add(jb5);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 4;
		jb6 = bf.createButton(ButtonFactory.MORPHEME, "6.png", "6", '6');
		this.add(jb6);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 4;
		jbMultiply = bf.createButton(ButtonFactory.BINARY, "multiply.png", "<html>&times;</html>", '*');
		this.add(jbMultiply);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 4;
		jbClearAll = bf.createButton(ButtonFactory.CLEAR_ALL, "clear_all.png", "C", 'u');
		this.add(jbClearAll);
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 5;
		jb1 = bf.createButton(ButtonFactory.MORPHEME, "1.png", "1", '1');
		this.add(jb1);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 5;
		jb2 = bf.createButton(ButtonFactory.MORPHEME, "2.png", "2", '2');
		this.add(jb2);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 5;
		jb3 = bf.createButton(ButtonFactory.MORPHEME, "3.png", "3", '3');
		this.add(jb3);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 5;
		jbSubtract = bf.createButton(ButtonFactory.BINARY, "subtract.png", "<html>&minus;</html>", '-');
		this.add(jbSubtract);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 5;
		gbConstraints.gridheight = 2;
		jbEquals = bf.createButton(ButtonFactory.UNARY, "equal.png", "=", 'u');
		this.add(jbEquals);
		
		gbConstraints.gridheight = 1;  // reset
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 6;
		jb0 = bf.createButton(ButtonFactory.MORPHEME, "0.png", "0", '0');
		this.add(jb0);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 6;
		jbDecimal = bf.createButton(ButtonFactory.MORPHEME, "decimal.png", ".", '.');
		this.add(jbDecimal);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 6;
		jbNegate = bf.createButton(ButtonFactory.UNARY, "negate.png", "<html>&plusmn;</html>", 'u');
		this.add(jbNegate);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 6;
		jbAdd = bf.createButton(ButtonFactory.BINARY, "add.png", "<html>+</html>", '+');
		this.add(jbAdd);
		
		// Reset values
		gbConstraints.gridwidth = 1;
		gbConstraints.gridheight = 1;
	}  // end GenerateButtons(GridBagLayout)
}  // end class ButtonPanel