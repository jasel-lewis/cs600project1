package edu.odu.cs.cs600.calculator.gui;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = -2691106243294969972L;
	
	private static final JButton jb0 = (new ButtonFactory(new ButtonAction(), "0")).getButton();
	private static final JButton jb1 = (new ButtonFactory(new ButtonAction(), "1")).getButton();
	private static final JButton jb2 = (new ButtonFactory(new ButtonAction(), "2")).getButton();
	private static final JButton jb3 = (new ButtonFactory(new ButtonAction(), "3")).getButton();
	private static final JButton jb4 = (new ButtonFactory(new ButtonAction(), "4")).getButton();
	private static final JButton jb5 = (new ButtonFactory(new ButtonAction(), "5")).getButton();
	private static final JButton jb6 = (new ButtonFactory(new ButtonAction(), "6")).getButton();
	private static final JButton jb7 = (new ButtonFactory(new ButtonAction(), "7")).getButton();
	private static final JButton jb8 = (new ButtonFactory(new ButtonAction(), "8")).getButton();
	private static final JButton jb9 = (new ButtonFactory(new ButtonAction(), "9")).getButton();
	private static final JButton jbDecimal = (new ButtonFactory(new ButtonAction(), ".")).getButton();
	private static final JButton jbEquals = (new ButtonFactory(new ButtonAction(), "=")).getButton();
	private static final JButton jbPlus = (new ButtonFactory(new ButtonAction(), "+")).getButton();
	private static final JButton jbMinus = (new ButtonFactory(new ButtonAction(), "-")).getButton();
	private static final JButton jbMultiply = (new ButtonFactory(new ButtonAction(), "*")).getButton();
	private static final JButton jbDivide = (new ButtonFactory(new ButtonAction(), "/")).getButton();
	private static final JButton jbCloseParen = (new ButtonFactory(new ButtonAction(), ")")).getButton();
	private static final JButton jbOpenParen = (new ButtonFactory(new ButtonAction(), "(")).getButton();
	//square root
	private static final JButton jbReciprocal = (new ButtonFactory(new ButtonAction(), "1/x")).getButton();
	//ceiling
	//floor
	private static final JButton jbNegate = (new ButtonFactory(new ButtonAction(), "+/-")).getButton();
	private static final JButton jbClearAll = (new ButtonFactory(new ButtonAction(), "C")).getButton();
	private static final JButton jbClearEntry = (new ButtonFactory(new ButtonAction(), "CE")).getButton();
	private static final JButton jbPower = (new ButtonFactory(new ButtonAction(), "On")).getButton();

	public ButtonPanel() {
		this.setLayout(new GridLayout(0, 3));
		this.add(jb7);
		this.add(jb8);
		this.add(jb9);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb0);
		this.add(jbDecimal);
		this.add(jbEquals);
	}
}  // end class ButtonPanel