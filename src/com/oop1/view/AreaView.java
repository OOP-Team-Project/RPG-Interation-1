package com.oop1.view;

import com.oop1.engine.Engine;
import com.oop1.map.Map;
import com.oop1.map.Tile;

import javax.swing.JPanel;
import java.awt.*;

/**
 * Displays the subset of visible tiles to the player
 */
public class AreaView extends JPanel {

	private boolean isInitialized = false; //Doing this because, for some reason, constructors aren't working right...
	private Engine engine;
	private Map map;

	private int centerTileIndex = 0;

	public AreaView(Map newMap) {

		map = newMap;
		setLayout(new GridLayout(0, 20)); //lays the tiles from left to right

	}

	private void initializeView(){
		setLayout(new GridLayout(0, 10));

		Tile playerTile = engine.getPlayer().getLocation();

		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++) {
				//Check the player position??
				//Calculate which coordinates we need to display.

				int xIndex = playerTile.getXLocation();
				int yIndex = playerTile.getYLocation();

				if(xIndex > 0 && xIndex < map)
				add(new TileView(map.getTileAtCoordinates(, 1)));//tiles[i] = new TileView();
			}
		}
		isInitialized = true;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		if(!isInitialized)
			initializeView();

		//for(int i = 0; i < 50; i++){
		//	tiles[i].paintComponent(g);
		//}
	}
}
