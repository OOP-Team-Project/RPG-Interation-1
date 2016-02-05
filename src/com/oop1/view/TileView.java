package com.oop1.view;

import javax.swing.JPanel;
import java.awt.*;

public class TileView extends JPanel {
	
	//method to draw a tile called by drawAreaView in AreaView class

	public TileView(){

	}

	public void drawTile() { //pass Tile tile to this method
		
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		setLayout(new GridLayout(0, 10));

		g.drawRect(0, 0, 120, 120);
	}
	
}