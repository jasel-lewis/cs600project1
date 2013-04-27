package edu.odu.cs.cs600.calculator.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private Image img;
	
	// TODO - Jared Javadoc this (I don't want to mislead by giving generic comments)
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