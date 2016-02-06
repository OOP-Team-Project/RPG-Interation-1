package com.oop1.view;

import com.oop1.engine.Engine;
import com.oop1.map.Map;
import com.oop1.map.Tile;

import java.awt.*;

import javax.swing.JPanel;


/**
 * Displays the subset of visible tiles to the player
 */
public class AreaView extends JPanel {
	//Game map -- array of Tiles
	Tile[] testAreaView = new Tile[200];
	Tile newTile;

	private boolean isInitialized = false; //Doing this because, for some reason, constructors aren't working right...
	//private Engine engine;
	private Map map;

	private int centerTileXIndex, centerTileYIndex = 0;

	public AreaView(Map newMap) {

		map = newMap;
		setLayout(new GridLayout(0, 21)); //lays the tiles from left to right

	}


	private void initializeView(){
		//setLayout(new GridLayout(0, 10));

		Tile playerTile = Engine.getPlayer().getLocation();
		System.out.println(Engine.getPlayer().getBaseStats().getOccupation().printOccupation());

		centerTileXIndex = map.findXLocation(playerTile);
		centerTileYIndex = map.findYLocation(playerTile);

		for(int i = centerTileXIndex - 5; i < centerTileXIndex + 5; i++){
			if(i < 0 || i >= map.getYBoundary()){
				for(int j = centerTileYIndex - 10; j <= centerTileYIndex + 10; j++){
					add(new com.oop1.View.TileView(false));
				}
			}
			else{
				for(int j = centerTileYIndex - 10; j <= centerTileYIndex + 10; j++){
					if(j < 0 || j >= map.getXBoundary()){
						add(new com.oop1.View.TileView(false));
					}
					else{
						com.oop1.View.TileView newTile = new com.oop1.View.TileView(map.getTileAtCoordinates(i, j));
						newTile.theLabel.setText((new Integer(i).toString() + " " + new Integer(j).toString()));
						//add(new TileView(map.getTileAtCoordinates(i, j)));
						add(newTile);
					}
				}
			}
		}

		com.oop1.View.TileView nextTile;
		/*
		for(int i = 1; i < 10; i++){
			for(int j = 1; j < 5; j++) {
				//Check the player position??
				//Calculate which coordinates we need to display

				int xIndex = playerTile.getXLocation();
				int yIndex = playerTile.getYLocation();

				if(xIndex > 0 && xIndex < map)
				add(new TileView(map.getTileAtCoordinates(, 1)));//tiles[i] = new TileView();
			}
		}
		*/
		/*
		nextTile = new TileView(map.getTileAtCoordinates(centerTileXIndex, centerTileYIndex));
		add(nextTile);
		nextTile.setLocation(60*10, 60*5);
		*/

		/*Tile[] testAreaView = new Tile[200];

		for (int i = 0; i < 200; i++) {
			Tile newTile;

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

		setLayout(new GridLayout(0, 20)); //lays the tiles from left to right
		for (int i = 0; i < 200; i++) {
			add(new TileView(testAreaView[i]));
		}
		*/
		isInitialized = true;
	}

	public void setCenterTileXIndex(int x){
		centerTileXIndex = x;
	}

	public void setCenterTileYIndex(int y){
		centerTileYIndex = y;
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
