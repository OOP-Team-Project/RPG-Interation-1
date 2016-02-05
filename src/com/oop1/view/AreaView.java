package com.oop1.view;


import javax.swing.JPanel;
import java.awt.*;
import com.oop1.map.Map;
import com.oop1.map.Tile;
import com.oop1.map.TerrainType;


/**
 * Displays the subset of visible tiles to the player
 */
public class AreaView extends JPanel {
	//Game map -- array of Tiles
	Tile[] testAreaView = new Tile[200];
	Tile newTile;

	public void setTestArea() {
		for (int i = 0; i < 200; i++) {
			if (i % 5 == 0) {
				newTile = new Tile(TerrainType.MOUNTAIN);
				testAreaView[i] = newTile;
			} else if (i % 8 == 0) {
				newTile = new Tile(TerrainType.WATER);
				testAreaView[i] = newTile;
			} else {
				newTile = new Tile(TerrainType.GRASS);
				testAreaView[i] = newTile;
			}
		}
	}



	public AreaView() {
		setTestArea();
		setLayout(new GridLayout(0, 20)); //lays the tiles from left to right
		for (int i = 0; i < 200; i++) {
			add(new TileView(testAreaView[i]));
		}
	}


    
}

