package com.oop1.view;

import com.oop1.engine.Controller;
import com.oop1.engine.Engine;
import com.oop1.entity.Entity;
import com.oop1.map.Map;
import com.oop1.map.Tile;
import com.oop1.view.TileView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


/**
 * Displays the subset of visible tiles to the player
 */
public class AreaView extends JPanel{
	//Game map -- array of Tiles
	Tile[] testAreaView = new Tile[200];
	Tile newTile;

	private boolean isInitialized = false; //Doing this because, for some reason, constructors aren't working right...
	private boolean shouldUpdate = false;
	//private Engine engine;
	private Map map;

	private int centerTileXIndex, centerTileYIndex = 0;

	public AreaView(Map newMap) {
		super();
		map = newMap;
		setLayout(new GridLayout(0, 21)); //lays the tiles from left to right

		this.addKeyListener(new Controller(this));

		setFocusable(true);
		requestFocus();
	}

	private void initializeView(){
		//setLayout(new GridLayout(0, 10));

		requestFocus();

		this.removeAll();
		this.updateUI();

		Tile playerTile = Engine.getPlayer().getLocation();
		//System.out.println(Engine.getPlayer().getBaseStats().getOccupation().printOccupation());

		centerTileXIndex = map.findXLocation(playerTile);
		centerTileYIndex = map.findYLocation(playerTile);

		for(int i = centerTileXIndex - 5; i < centerTileXIndex + 5; i++){
			if(i < 0 || i >= map.getYBoundary()){
				for(int j = centerTileYIndex - 10; j <= centerTileYIndex + 10; j++){
					add(new TileView(false));
				}
			}
			else{
				for(int j = centerTileYIndex - 10; j <= centerTileYIndex + 10; j++){
					if(j < 0 || j >= map.getXBoundary()){
						add(new com.oop1.view.TileView(false));
					}
					else{
						TileView newTile = new TileView(map.getTileAtCoordinates(i, j));
						newTile.theLabel.setText((new Integer(i).toString() + " " + new Integer(j).toString()));
						//add(new TileView(map.getTileAtCoordinates(i, j)));
						add(newTile);
					}
				}
			}
		}

		isInitialized = true;
	}

	private void updateView(){
		//requestFocus();

		this.removeAll();
		this.updateUI();

		for(int i = centerTileXIndex - 5; i < centerTileXIndex + 5; i++){
			if(i < 0 || i >= map.getYBoundary()){
				for(int j = centerTileYIndex - 10; j <= centerTileYIndex + 10; j++){
					add(new TileView(false));
				}
			}
			else{
				for(int j = centerTileYIndex - 10; j <= centerTileYIndex + 10; j++){
					if(j < 0 || j >= map.getXBoundary()){
						add(new com.oop1.view.TileView(false));
					}
					else{
						TileView newTile = new TileView(map.getTileAtCoordinates(i, j));
						newTile.theLabel.setText((new Integer(i).toString() + " " + new Integer(j).toString()));
						//add(new TileView(map.getTileAtCoordinates(i, j)));
						add(newTile);
					}
				}
			}
		}

		shouldUpdate = false;
	}

	public void setShouldUpdate(boolean b){
		shouldUpdate = b;
	}

	public void setInitialized(boolean b){
		isInitialized = b;
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

		if(shouldUpdate){
			updateView();
		}
		//for(int i = 0; i < 50; i++){
		//	tiles[i].paintComponent(g);
		//}
	}

}
