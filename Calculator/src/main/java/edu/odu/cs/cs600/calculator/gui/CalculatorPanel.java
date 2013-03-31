package edu.odu.cs.cs600.calculator.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import edu.odu.cs.cs600.calculator.Application;
import edu.odu.cs.cs600.calculator.math.MathUtil;

public class CalculatorPanel extends JPanel {

	private static final long serialVersionUID = -2691106243294969972L;
	
	private CalculatorDisplay display = new CalculatorDisplay();

	public CalculatorPanel() {
		GridBagLayout gbLayout = new GridBagLayout();
		
		this.setLayout(gbLayout);
		
		constructDisplay(gbLayout);
		constructButtons(gbLayout);
	}  // end constructor CalculatorPanel()
	
	
	
	private void constructDisplay(GridBagLayout gbLayout) {
		GridBagConstraints gbConstraints = new GridBagConstraints();
		
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.gridheight = 1;
		gbConstraints.gridwidth = 5;
		gbConstraints.weightx = 1.0;
		gbConstraints.gridx = 0; gbConstraints.gridy = 0;
		
		this.add(display, gbConstraints);
	}  // end generateDisplay(GridBagLayout)

	
	
	private void constructButtons(GridBagLayout gbLayout) {
        GridBagConstraints gbConstraints = new GridBagConstraints();
        
        gbConstraints.fill = GridBagConstraints.BOTH;
        gbConstraints.gridheight = 1;
        gbConstraints.gridwidth = 1;
        gbConstraints.weightx = 1.0;
        
        // Annoying, but in order to get the "=" button to span two rows on the far right, we have
        // to set the gridx and gridy for each component (this is listed as a best practice, anyway,
        // in the Swing tutorial (http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html)
        
        gbConstraints.gridx = 0; gbConstraints.gridy = 1;
        FunctionButton obCeiling = new FunctionButton("ceiling.png", "Ceiling", KeyEvent.VK_UNDEFINED,
           		new ActionListener() {
    				public void actionPerformed(ActionEvent ae) {
    					if (Application.isOn()) {
    						;
    					}
    				}
    			});
        //gbLayout.setConstraints(obCeiling, gbConstraints);
        this.add(obCeiling, gbConstraints);
        
        gbConstraints.gridx = 1; gbConstraints.gridy = 1;
        FunctionButton obFloor = new FunctionButton("floor.png", "Floor", KeyEvent.VK_UNDEFINED,
            	new ActionListener() {
        			public void actionPerformed(ActionEvent ae) {
        				if (Application.isOn()) {
        					;
        				}
        			}
        		});
        this.add(obFloor, gbConstraints);
        
        gbConstraints.gridx = 2; gbConstraints.gridy = 1;
        FunctionButton obReciprocal = new FunctionButton("reciprocal.png", "<html>1/x</html>", KeyEvent.VK_UNDEFINED,
               	new ActionListener() {
        			public void actionPerformed(ActionEvent ae) {
        				if (Application.isOn()) {
       						;
       					}
        			}
        		});
        this.add(obReciprocal, gbConstraints);
        
        gbConstraints.gridx = 3; gbConstraints.gridy = 1;
        gbConstraints.gridwidth = 2;
        FunctionButton obOn = new FunctionButton("on.png", "On", KeyEvent.VK_UNDEFINED,
    			new ActionListener() {
        			public void actionPerformed(ActionEvent ae) {
        				if (Application.isOn()) {
        					display.clear();
        				} else {
        					Application.on();
        					display.onState();
        				}
        			}
        		});
		this.add(obOn, gbConstraints);
		
		gbConstraints.gridwidth = 1;  // reset
		
        gbConstraints.gridx = 0; gbConstraints.gridy = 2;
		this.add(new CharacterButton("parenthesis_left.png", '(', display), gbConstraints);
		
        gbConstraints.gridx = 1; gbConstraints.gridy = 2;
        this.add(new CharacterButton("parenthesis_right.png", ')', display), gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 2;
		FunctionButton obSquareRoot = new FunctionButton("square_root.png", "<html>&radic;</html>", KeyEvent.VK_UNDEFINED,
		       	new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						if (Application.isOn()) {
							;
						}
					}
				});
		this.add(obSquareRoot, gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 2;
		gbConstraints.gridwidth = 2;
		FunctionButton obOff = new FunctionButton("off.png", "Off", KeyEvent.VK_UNDEFINED,
		       	new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						if (Application.isOn()) {
							Application.off();
							display.offState();
						}
					}
				});
		this.add(obOff, gbConstraints);
		
		gbConstraints.gridwidth = 1;  // reset
		
        gbConstraints.gridx = 0; gbConstraints.gridy = 3;
		this.add(new CharacterButton("7.png", '7', display), gbConstraints);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 3;
		this.add(new CharacterButton("8.png", '8', display), gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 3;
		this.add(new CharacterButton("9.png", '9', display), gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 3;
		this.add(new OperatorButton("divide.png", "&divide;", '/', display), gbConstraints);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 3;
		FunctionButton obClearEntry = new FunctionButton("clear_entry.png", "CE", KeyEvent.VK_BACK_SPACE,
		       	new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						if (Application.isOn()) {
							display.pop();
						}
					}
				});
		this.add(obClearEntry, gbConstraints);
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 4;
		this.add(new CharacterButton("4.png", '4', display), gbConstraints);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 4;
		this.add(new CharacterButton("5.png", '5', display), gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 4;
		this.add(new CharacterButton("6.png", '6', display), gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 4;
		this.add(new OperatorButton("multiply.png", "&times;", '*', display), gbConstraints);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 4;
		FunctionButton obClearAll = new FunctionButton("clear_all.png", "C", KeyEvent.VK_UNDEFINED,
		       	new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						if (Application.isOn()) {
							display.clear();
						}
					}
				});
		this.add(obClearAll, gbConstraints);
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 5;
		this.add(new CharacterButton("1.png", '1', display), gbConstraints);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 5;
		this.add(new CharacterButton("2.png", '2', display), gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 5;
		this.add(new CharacterButton("3.png", '3', display), gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 5;
		this.add(new OperatorButton("subtract.png", "-", '-', display), gbConstraints);
		
		gbConstraints.gridx = 4; gbConstraints.gridy = 5;
		gbConstraints.gridheight = 2;
		FunctionButton obEqual = new FunctionButton("equal.png", "=", KeyEvent.VK_UNDEFINED,
		       	new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						if (Application.isOn()) {
							double result = MathUtil.evaluate(display.getPhrase(false));
						}
					}
				});
		this.add(obEqual, gbConstraints);
		
		gbConstraints.gridheight = 1;  // reset
		
		gbConstraints.gridx = 0; gbConstraints.gridy = 6;
		this.add(new CharacterButton("0.png", '0', display), gbConstraints);
		
		gbConstraints.gridx = 1; gbConstraints.gridy = 6;
		this.add(new CharacterButton("decimal.png", '.', display), gbConstraints);
		
		gbConstraints.gridx = 2; gbConstraints.gridy = 6;
		FunctionButton obNegate = new FunctionButton("negate.png", "<html>&plusmn;</html>", KeyEvent.VK_UNDEFINED,
		       	new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						if (Application.isOn()) {
							;
						}
					}
				});
		this.add(obNegate, gbConstraints);
		
		gbConstraints.gridx = 3; gbConstraints.gridy = 6;
		this.add(new OperatorButton("add.png", "+", '+', display), gbConstraints);
		
		// Reset values
		gbConstraints.gridwidth = 1;
		gbConstraints.gridheight = 1;
	}  // end GenerateButtons(GridBagLayout)
}  // end class ButtonPanel