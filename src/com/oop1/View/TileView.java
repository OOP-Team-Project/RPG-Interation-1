package com.oop1.view;

import com.oop1.map.TerrainType;
import com.oop1.map.Tile;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Draws the Tile to the View
 */

public class TileView extends JPanel {

	String tileTerrain;
	Tile currentTile;

	public TileView(Tile currentTile) { //passed the current Tile to be drawn from AreaView
		this.currentTile = currentTile;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//based off tileTerrain set color
		tileTerrain = currentTile.toString();
		if (tileTerrain == "M") {
			g.setColor(Color.gray);
		} else if (tileTerrain == "G") {
			g.setColor(Color.green);
		} else {
			g.setColor(Color.blue);
		}
		g.fillRect(0, 0, 60, 60);
	}
	
}