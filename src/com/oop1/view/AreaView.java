//package com.oop1.view;
//
//import com.oop1.engine.Controller;
//import com.oop1.engine.Engine;
//import com.oop1.entity.Entity;
//import com.oop1.map.Map;
//import com.oop1.map.TerrainType;
//import com.oop1.map.Tile;
//
//import java.awt.*;
//
//import javax.swing.JPanel;
//
//
///**
// * Displays the subset of visible tiles to the player
// */
//public class AreaView extends JPanel {
//	//Game map -- array of Tiles
//	Tile[] testAreaView = new Tile[200];
//	Tile newTile;
//
//	private boolean isInitialized = false; //Doing this because, for some reason, constructors aren't working right...
//	private Map map;
//	private Entity entityToFollow;
//	private Controller controller;
//	//private TileView[] tileViews = new TileView[];
//
//	private int centerTileXIndex, centerTileYIndex = 0;
//
//	public AreaView(Map newMap, Entity entityToFollow, Controller newController) {
//		map = newMap;
//		this.entityToFollow = entityToFollow;
//		setLayout(new GridLayout(0, 21)); //lays the tiles from left to right
//		setMinimumSize(new Dimension(600, 524));
//		setPreferredSize(new Dimension(1100, 524));
//		controller = newController;
//		this.addKeyListener(controller);
//		this.setFocusable(true);
//
//	}
//
//
//	private void initializeView() {
//		//setLayout(new GridLayout(0, 10));
//
//		centerTileXIndex = map.findXLocation(entityToFollow.getLocation());
//		centerTileYIndex = map.findYLocation(entityToFollow.getLocation());
//
//		for(int i = centerTileXIndex - 5; i < centerTileXIndex + 5; i++){
//			if(i < 0 || i >= map.getYBoundary()){
//				for(int j = centerTileYIndex - 10; j <= centerTileYIndex + 10; j++){
//					add(new TileView(false));
//				}
//			}
//			else{
//				for(int j = centerTileYIndex - 10; j <= centerTileYIndex + 10; j++){
//					if(j < 0 || j >= map.getXBoundary()){
//						add(new TileView(false));
//					}
//					else{
//						TileView newTile = new TileView(map.getTileAtCoordinates(i,j));
//						//newTile.setText((new Integer(i).toString() + " " + new Integer(j).toString()));
//						//add(new TileView(map.getTileAtCoordinates(i, j)));
//						add(newTile);
//					}
//				}
//			}
//		}
//
//		TileView nextTile;
//		/*
//		for(int i = 1; i < 10; i++){
//			for(int j = 1; j < 5; j++) {
//				//Check the player position??
//				//Calculate which coordinates we need to display
//				int xIndex = playerTile.getXLocation();
//				int yIndex = playerTile.getYLocation();
//				if(xIndex > 0 && xIndex < map)
//				add(new TileView(map.getTileAtCoordinates(, 1)));//tiles[i] = new TileView();
//			}
//		}
//		*/
//		/*
//		nextTile = new TileView(map.getTileAtCoordinates(centerTileXIndex, centerTileYIndex));
//		add(nextTile);
//		nextTile.setLocation(60*10, 60*5);
//		*/
//
//		/*Tile[] testAreaView = new Tile[200];
//		for (int i = 0; i < 200; i++) {
//			Tile newTile;
//			if (i % 5 == 0) {
//				newTile = new Tile(TerrainType.MOUNTAIN);
//				testAreaView[i] = newTile;
//			} else if (i % 8 == 0) {
//				newTile = new Tile(TerrainType.WATER);
//				testAreaView[i] = newTile;
//			} else {
//				newTile = new Tile(TerrainType.GRASS);
//				testAreaView[i] = newTile;
//			}
//		}
//		setLayout(new GridLayout(0, 20)); //lays the tiles from left to right
//		for (int i = 0; i < 200; i++) {
//			add(new TileView(testAreaView[i]));
//		}
//		*/
//		isInitialized = true;
//	}
//
//	public void setCenterTileXIndex(int x){
//		centerTileXIndex = x;
//	}
//
//	public void setCenterTileYIndex(int y){
//		centerTileYIndex = y;
//	}
//
//	private int getCenterX() {
//		return map.findXLocation(entityToFollow.getLocation());
//	}
//	private int getCenterY() {
//		return map.findYLocation(entityToFollow.getLocation());
//	}
//
//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Graphics2D g2 = (Graphics2D)g;
//
//		requestFocus();
//
//		if(!isInitialized)
//			initializeView();
//
//		int x = getCenterX();
//		int y = getCenterY();
//
//		int k = 0;
//
//		for(int i = x - 5; i < x + 5; i++){
//			if(i < 0 || i > map.getYBoundary()){
//				for(int j = y - 10; j <= y + 10; j++){
//					((TileView) getComponents()[k++]).setTile(new Tile(TerrainType.BLANK));
//				}
//			}
//			else{
//				for(int j = y - 10; j <= y + 10; j++){
//					if(j < 0 || j > map.getXBoundary()){
//						((TileView) getComponents()[k++]).setTile(new Tile(TerrainType.BLANK));//add(new TileView(false));
//					}
//					else{
//						((TileView) getComponents()[k++]).setTile(map.getTileAtCoordinates(i,j));
//						//newTile.setText((new Integer(i).toString() + " " + new Integer(j).toString()));
//						//add(new TileView(map.getTileAtCoordinates(i, j)));
//						//add(newTile);
//						((TileView) getComponents()[k++]).setTile(map.getTileAtCoordinates(i,j));
//					}
//				}
//			}
//		}
//	}
//
///*
//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//
//		int x = getCenterX();
//		int y = getCenterY();
//
//		for (int i = 0; i < tileViews.length; ++i) {
//			for (int j = 0; j < tileViews[0].length; ++j) {
//				int xCoordinate = x + i - tileViews.length / 2;
//				int yCoordinate = y + i - tileViews[i].length / 2;
//				Tile tile = map.getTileAtCoordinates(xCoordinate, yCoordinate);
//				tileViews[i][j].setTile(tile);
//				System.out.println("Getting tile at coordinate " + i + ", " + j);
//			}
//		}
//	}
//*/
//}

package com.oop1.view;

import com.oop1.engine.Controller;
import com.oop1.engine.Engine;
import com.oop1.entity.Entity;
import com.oop1.map.Map;
import com.oop1.map.TerrainType;
import com.oop1.map.Tile;

import javax.swing.*;
import java.awt.*;


/**
 * Displays the subset of visible tiles to the player
 */
public class AreaView extends JPanel {

	private boolean isInitialized = false; //Doing this because, for some reason, constructors aren't working right...
	private Map map;
	private Entity entityToFollow;

	private TileView[][] tileViews = new TileView[11][21];

	public AreaView(Map newMap, Entity entityToFollow, Controller newController) {
		map = newMap;
        this.entityToFollow = entityToFollow;
		setLayout(new GridLayout(0, 21)); //lays the tiles from left to right
        setMinimumSize(new Dimension(600, 524));
        setPreferredSize(new Dimension(1100, 524));
		addKeyListener(newController);

		for (int i = 0; i < tileViews.length; ++i) {
			for (int j = 0; j < tileViews[0].length; ++j) {
				tileViews[i][j] = new TileView(null);
				add(tileViews[i][j]);
			}
		}

		setFocusable(true);
		requestFocus();
	}

	private int getCenterX() {
		return entityToFollow.getLocation().getXLoc();//map.findXLocation(entityToFollow.getLocation());
	}
	private int getCenterY() {
		return entityToFollow.getLocation().getYLoc();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Graphics2D g2 = (Graphics2D)  g;

		if(!hasFocus())
			requestFocus();

		int x = getCenterX();
		int y = getCenterY();
		for (int i = 0; i < tileViews.length; ++i) {
			for (int j = 0; j < tileViews[0].length; ++j) {

				int xCoordinate = x + i - tileViews.length / 2;
				int yCoordinate = y + j - tileViews[i].length / 2;
				Tile tile = map.getTileAtCoordinates(xCoordinate, yCoordinate);
				if(tile != null)
					tileViews[i][j].setTile(tile);
				else
					tileViews[i][j].setTile(new Tile(TerrainType.BLANK));
				//System.out.println("Getting tile at coordinate " + i + ", " + j);
			}
		}
	}
}
