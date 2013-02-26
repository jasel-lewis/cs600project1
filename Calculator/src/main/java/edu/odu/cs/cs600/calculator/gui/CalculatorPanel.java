package edu.odu.cs.cs600.calculator.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorPanel extends JPanel {

	private static final long serialVersionUID = -2691106243294969972L;
	
	private static final JLabel display = new JLabel();
	
	private JButton jb0, jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jbDecimal;
	private JButton jbOpenParen, jbCloseParen;
	private JButton jbAdd, jbSubtract, jbMultiply, jbDivide, jbEquals;
	private JButton jbNegate, jbReciprocal, jbSquareRoot, jbCeiling, jbFloor;
	private JButton jbPower, jbClearEntry, jbClearAll;

	public CalculatorPanel() {
		GridBagLayout gbLayout = new GridBagLayout();
		this.setLayout(gbLayout);
		
		generateButtons(gbLayout);
	}

	
	
	private void generateButtons(GridBagLayout gbLayout) {
        GridBagConstraints gbConstraints = new GridBagConstraints();
        
        gbConstraints.fill = GridBagConstraints.BOTH;
        gbConstraints.weightx = 1.0;
        gbConstraints.gridwidth = 1;
        
        // Annoying, but in order to get the "=" button to span two rows on the far right, we have
        // to set the gridx and gridy for each component (this is listed as a best practice, anyway,
        // in the Swing tutorial (http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html)
		
        gbConstraints.gridx = 0; gbConstraints.gridy = 0;
		jb7 = (new ButtonFactory(new ButtonAction(), "7", gbLayout, gbConstraints)).getButton();
		this.add(jb7);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 0;
		jb8 = (new ButtonFactory(new ButtonAction(), "8", gbLayout, gbConstraints)).getButton();
		this.add(jb8);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 0;
		jb9 = (new ButtonFactory(new ButtonAction(), "9", gbLayout, gbConstraints)).getButton();
		this.add(jb9);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 0;
		jbDivide = (new ButtonFactory(new ButtonAction(), "<html>&divide;</html>", gbLayout, gbConstraints)).getButton();
		this.add(jbDivide);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 0;
		jbClearEntry = (new ButtonFactory(new ButtonAction(), "CE", gbLayout, gbConstraints)).getButton();
		this.add(jbClearEntry);
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 1;
		jb4 = (new ButtonFactory(new ButtonAction(), "4", gbLayout, gbConstraints)).getButton();
		this.add(jb4);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 1;
		jb5 = (new ButtonFactory(new ButtonAction(), "5", gbLayout, gbConstraints)).getButton();
		this.add(jb5);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 1;
		jb6 = (new ButtonFactory(new ButtonAction(), "6", gbLayout, gbConstraints)).getButton();
		this.add(jb6);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 1;
		jbMultiply = (new ButtonFactory(new ButtonAction(), "<html>&times;</html>", gbLayout, gbConstraints)).getButton();
		this.add(jbMultiply);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 1;
		jbClearAll = (new ButtonFactory(new ButtonAction(), "C", gbLayout, gbConstraints)).getButton();
		this.add(jbClearAll);
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 2;
		jb1 = (new ButtonFactory(new ButtonAction(), "1", gbLayout, gbConstraints)).getButton();
		this.add(jb1);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 2;
		jb2 = (new ButtonFactory(new ButtonAction(), "2", gbLayout, gbConstraints)).getButton();
		this.add(jb2);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 2;
		jb3 = (new ButtonFactory(new ButtonAction(), "3", gbLayout, gbConstraints)).getButton();
		this.add(jb3);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 2;
		jbSubtract = (new ButtonFactory(new ButtonAction(), "<html>&minus;</html>", gbLayout, gbConstraints)).getButton();
		this.add(jbSubtract);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 2;
		gbConstraints.gridheight = 2;
		jbEquals = (new ButtonFactory(new ButtonAction(), "=", gbLayout, gbConstraints)).getButton();
		this.add(jbEquals);
		
		gbConstraints.gridheight = 1;  // reset
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 3;
		jb0 = (new ButtonFactory(new ButtonAction(), "0", gbLayout, gbConstraints)).getButton();
		this.add(jb0);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 3;
		jbDecimal = (new ButtonFactory(new ButtonAction(), ".", gbLayout, gbConstraints)).getButton();
		this.add(jbDecimal);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 3;
		jbNegate = (new ButtonFactory(new ButtonAction(), "<html>&plusmn;</html>", gbLayout, gbConstraints)).getButton();
		this.add(jbNegate);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 3;
		jbAdd = (new ButtonFactory(new ButtonAction(), "<html>+</html>", gbLayout, gbConstraints)).getButton();
		this.add(jbAdd);
		
		// Reset values
		gbConstraints.gridwidth = 1;
		gbConstraints.gridheight = 1;
		
		jbCloseParen = (new ButtonFactory(new ButtonAction(), ")", gbLayout, gbConstraints)).getButton();
		jbOpenParen = (new ButtonFactory(new ButtonAction(), "(", gbLayout, gbConstraints)).getButton();
		jbSquareRoot = (new ButtonFactory(new ButtonAction(), "<html>&radic;</html>", gbLayout, gbConstraints)).getButton();
		jbReciprocal = (new ButtonFactory(new ButtonAction(), "<html><sup>1</sup>/<sub>x</sub></html>", gbLayout, gbConstraints)).getButton();
		jbCeiling = (new ButtonFactory(new ButtonAction(), "<html>&lceil;x&rceil;</html>", gbLayout, gbConstraints)).getButton();
		jbFloor = (new ButtonFactory(new ButtonAction(), "<html>&lfloor;x&rfloor;</html>", gbLayout, gbConstraints)).getButton();
		jbPower = (new ButtonFactory(new ButtonAction(), "On", gbLayout, gbConstraints)).getButton();
	}
}  // end class ButtonPanel