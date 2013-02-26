package edu.odu.cs.cs600.calculator.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = -2691106243294969972L;
	
	private static final JLabel display = new JLabel();
	
	private JButton jb0, jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jbDecimal;
	private JButton jbOpenParen, jbCloseParen;
	private JButton jbAdd, jbSubtract, jbMultiply, jbDivide, jbEquals;
	private JButton jbNegate, jbReciprocal /*square root*/ /*ceiling*/ /*floor*/;
	private JButton jbPower, jbClearEntry, jbClearAll;

	public ButtonPanel() {
		GridBagLayout gbLayout = new GridBagLayout();
		this.setLayout(gbLayout);
		
		generateButtons(gbLayout);
	}

	
	
	private void generateButtons(GridBagLayout gbLayout) {
        GridBagConstraints gbConstraints = new GridBagConstraints();
        
        gbConstraints.fill = GridBagConstraints.BOTH;
        gbConstraints.weightx = 1.0;
		
		jb7 = (new ButtonFactory(new ButtonAction(), "7", gbLayout, gbConstraints)).getButton();
		jb8 = (new ButtonFactory(new ButtonAction(), "8", gbLayout, gbConstraints)).getButton();
		jb9 = (new ButtonFactory(new ButtonAction(), "9", gbLayout, gbConstraints)).getButton();
		jbDivide = (new ButtonFactory(new ButtonAction(), "/", gbLayout, gbConstraints)).getButton();
		gbConstraints.gridwidth = GridBagConstraints.REMAINDER;  // end the row
		jbClearEntry = (new ButtonFactory(new ButtonAction(), "CE", gbLayout, gbConstraints)).getButton();
		
		this.add(jb7);
		this.add(jb8);
		this.add(jb9);
		this.add(jbDivide);
		this.add(jbClearEntry);
		
		gbConstraints.gridwidth = 1;  // reset
		gbConstraints.weightx = 0.0;  // reset
		
		jb4 = (new ButtonFactory(new ButtonAction(), "4", gbLayout, gbConstraints)).getButton();
		jb5 = (new ButtonFactory(new ButtonAction(), "5", gbLayout, gbConstraints)).getButton();
		jb6 = (new ButtonFactory(new ButtonAction(), "6", gbLayout, gbConstraints)).getButton();
		jbMultiply = (new ButtonFactory(new ButtonAction(), "*", gbLayout, gbConstraints)).getButton();
		gbConstraints.gridwidth = GridBagConstraints.REMAINDER;  // end the row
		jbClearAll = (new ButtonFactory(new ButtonAction(), "C", gbLayout, gbConstraints)).getButton();
		
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		this.add(jbMultiply);
		this.add(jbClearAll);
		
		gbConstraints.gridwidth = 1;  // reset
		
		jb1 = (new ButtonFactory(new ButtonAction(), "1", gbLayout, gbConstraints)).getButton();
		jb2 = (new ButtonFactory(new ButtonAction(), "2", gbLayout, gbConstraints)).getButton();
		jb3 = (new ButtonFactory(new ButtonAction(), "3", gbLayout, gbConstraints)).getButton();
		jbSubtract = (new ButtonFactory(new ButtonAction(), "-", gbLayout, gbConstraints)).getButton();
		gbConstraints.gridheight = 2;  // vertically span two rows
		gbConstraints.weighty = 1.0;
		gbConstraints.gridwidth = GridBagConstraints.REMAINDER;  // end the row
		jbEquals = (new ButtonFactory(new ButtonAction(), "=", gbLayout, gbConstraints)).getButton();
		
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jbSubtract);
		this.add(jbEquals);
		
		// Reset values
		gbConstraints.gridwidth = 1;
		gbConstraints.gridheight = 1;
		gbConstraints.weighty = 0.0;
		
		jb0 = (new ButtonFactory(new ButtonAction(), "0", gbLayout, gbConstraints)).getButton();
		jbDecimal = (new ButtonFactory(new ButtonAction(), ".", gbLayout, gbConstraints)).getButton();
		jbNegate = (new ButtonFactory(new ButtonAction(), "+/-", gbLayout, gbConstraints)).getButton();
		gbConstraints.gridwidth = GridBagConstraints.REMAINDER;  // end the row
		jbAdd = (new ButtonFactory(new ButtonAction(), "+", gbLayout, gbConstraints)).getButton();
		
		this.add(jb0);
		this.add(jbDecimal);
		this.add(jbNegate);
		this.add(jbAdd);
		
		gbConstraints.gridwidth = 1;  // reset
		
		jbCloseParen = (new ButtonFactory(new ButtonAction(), ")", gbLayout, gbConstraints)).getButton();
		jbOpenParen = (new ButtonFactory(new ButtonAction(), "(", gbLayout, gbConstraints)).getButton();
		//square root
		jbReciprocal = (new ButtonFactory(new ButtonAction(), "1/x", gbLayout, gbConstraints)).getButton();
		//ceiling
		//floor
		jbPower = (new ButtonFactory(new ButtonAction(), "On", gbLayout, gbConstraints)).getButton();
	}
}  // end class ButtonPanel