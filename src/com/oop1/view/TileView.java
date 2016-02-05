package com.oop1.view;

import javax.swing.JPanel;
import java.awt.Graphics;

public class TileView extends JPanel {
	
	//method to draw a tile called by drawAreaView in AreaView class

	public void drawTile() { //pass Tile tile to this method
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(0, 0, 120, 120);
	}
	
}