package edu.odu.cs.cs600.calculator.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.odu.cs.cs600.calculator.Phrase;

public class CalculatorPanel extends JPanel {

	private static final long serialVersionUID = -2691106243294969972L;
	
	private Phrase phrase;
	
	private JButton jb0, jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jbDecimal;
	private JButton jbOpenParen, jbCloseParen;
	private JButton jbAdd, jbSubtract, jbMultiply, jbDivide, jbEquals;
	private JButton jbNegate, jbReciprocal, jbSquareRoot, jbCeiling, jbFloor;
	private JButton jbPower, jbClearEntry, jbClearAll;

	public CalculatorPanel(Phrase phrase) {
		GridBagLayout gbLayout = new GridBagLayout();
		JLabel display = new JLabel();
		
		this.setLayout(gbLayout);
		
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
        ButtonFactory bf = new ButtonFactory(gbLayout, gbConstraints, phrase);
        
        gbConstraints.fill = GridBagConstraints.BOTH;
        gbConstraints.gridheight = 1;
        gbConstraints.gridwidth = 1;
        gbConstraints.weightx = 1.0;
        
        // Annoying, but in order to get the "=" button to span two rows on the far right, we have
        // to set the gridx and gridy for each component (this is listed as a best practice, anyway,
        // in the Swing tutorial (http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html)
        
        gbConstraints.gridx = 0; gbConstraints.gridy = 1;
		jbOpenParen = bf.createButton(ButtonFactory.MORPHEME, "(");
		this.add(jbOpenParen);
		
        gbConstraints.gridx = 1; gbConstraints.gridy = 1;
        jbCloseParen = bf.createButton(ButtonFactory.MORPHEME, ")");
        this.add(jbCloseParen);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 1;
		jbSquareRoot = bf.createButton(ButtonFactory.UNARY_OPERATOR, "<html>&radic;</html>");
		this.add(jbSquareRoot);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 1;
		jbReciprocal = bf.createButton(ButtonFactory.UNARY_OPERATOR, "<html>1/x</html>");
		this.add(jbReciprocal);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 1;
		jbPower = bf.createButton(ButtonFactory.ON, "On");
		this.add(jbPower);
		
        gbConstraints.gridx = 0; gbConstraints.gridy = 2;
		jb7 = bf.createButton(ButtonFactory.MORPHEME, "7");
		this.add(jb7);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 2;
		jb8 = bf.createButton(ButtonFactory.MORPHEME, "8");
		this.add(jb8);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 2;
		jb9 = bf.createButton(ButtonFactory.MORPHEME, "9");
		this.add(jb9);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 2;
		jbDivide = bf.createButton(ButtonFactory.BINARY_OPERATOR, "<html>&divide;</html>");
		this.add(jbDivide);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 2;
		jbClearEntry = bf.createButton(ButtonFactory.CLEAR_ENTRY, "CE");
		this.add(jbClearEntry);
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 3;
		jb4 = bf.createButton(ButtonFactory.MORPHEME, "4");
		this.add(jb4);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 3;
		jb5 = bf.createButton(ButtonFactory.MORPHEME, "5");
		this.add(jb5);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 3;
		jb6 = bf.createButton(ButtonFactory.MORPHEME, "6");
		this.add(jb6);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 3;
		jbMultiply = bf.createButton(ButtonFactory.BINARY_OPERATOR, "<html>&times;</html>");
		this.add(jbMultiply);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 3;
		jbClearAll = bf.createButton(ButtonFactory.CLEAR_ALL, "C");
		this.add(jbClearAll);
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 4;
		jb1 = bf.createButton(ButtonFactory.MORPHEME, "1");
		this.add(jb1);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 4;
		jb2 = bf.createButton(ButtonFactory.MORPHEME, "2");
		this.add(jb2);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 4;
		jb3 = bf.createButton(ButtonFactory.MORPHEME, "3");
		this.add(jb3);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 4;
		jbSubtract = bf.createButton(ButtonFactory.BINARY_OPERATOR, "<html>&minus;</html>");
		this.add(jbSubtract);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 4;
		gbConstraints.gridheight = 2;
		jbEquals = bf.createButton(ButtonFactory.UNARY_OPERATOR, "=");
		this.add(jbEquals);
		
		gbConstraints.gridheight = 1;  // reset
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 5;
		jb0 = bf.createButton(ButtonFactory.MORPHEME, "0");
		this.add(jb0);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 5;
		jbDecimal = bf.createButton(ButtonFactory.MORPHEME, ".");
		this.add(jbDecimal);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 5;
		jbNegate = bf.createButton(ButtonFactory.UNARY_OPERATOR, "<html>&plusmn;</html>");
		this.add(jbNegate);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 5;
		jbAdd = bf.createButton(ButtonFactory.BINARY_OPERATOR, "<html>+</html>");
		this.add(jbAdd);
		
		// Reset values
		gbConstraints.gridwidth = 1;
		gbConstraints.gridheight = 1;
		
		//jbCeiling = bf.createButton(new ButtonAction(), "<html>&lceil;x&rceil;</html>");
		//jbFloor = bf.createButton(new ButtonAction(), "<html>&lfloor;x&rfloor;</html>");
	}  // end GenerateButtons(GridBagLayout)
}  // end class ButtonPanel