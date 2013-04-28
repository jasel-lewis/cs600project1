package edu.odu.cs.cs600.calculator.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * A lightly modified {@link JPanel} that enables the inclusion of a background image (easily).
 */
public class ImagePanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private Image img;
	
	/**
	 * @param img The image to set as the background for the panel 
	 */
	public ImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}