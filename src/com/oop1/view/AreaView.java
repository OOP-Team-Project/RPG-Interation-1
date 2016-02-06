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
	private boolean shouldUpdate = true;
	//private Engine engine;
	private Map map;
    private Entity entityToFollow;
	private TileView[][] tileViews = new TileView[11][21];

	private int centerTileXIndex, centerTileYIndex = 0;

	public AreaView(Map newMap, Entity entityToFollow, Controller controller) {
		map = newMap;
        this.entityToFollow = entityToFollow;
		setLayout(new GridLayout(0, 21)); //lays the tiles from left to right

		this.addKeyListener(controller);

		//No
        setMinimumSize(new Dimension(600, 600));
        setPreferredSize(new Dimension(600, 600));

		for (int i = 0; i < tileViews.length; ++i) {
			for (int j = 0; j < tileViews[0].length; ++j) {
				tileViews[i][j] = new TileView(null);
				add(tileViews[i][j]);
			}
		}

		setFocusable(true);
		requestFocus();
	}

	private void initializeView() {
		//setLayout(new GridLayout(0, 10));

		requestFocus();

		this.removeAll();
		this.updateUI();

		//Tile playerTile = Engine.getPlayer().getLocation();
		//System.out.println(Engine.getPlayer().getBaseStats().getOccupation().printOccupation());

		centerTileXIndex = map.findXLocation(entityToFollow.getLocation());
		centerTileYIndex = map.findYLocation(entityToFollow.getLocation());

		for (int i = 0; i < tileViews.length; ++i) {
			for (int j = 0; j < tileViews[0].length; ++j) {
				tileViews[i][j] = new TileView(null);
				add(tileViews[i][j]);
			}
		}
		/*
		for(int i = centerTileXIndex - 5; i < centerTileXIndex + 5; i++){
			if(i < 0 || i >= map.getYBoundary()){
				for(int j = centerTileYIndex - 10; j <= centerTileYIndex + 10; j++){
					add(new TileView(false));
				}
			}
			else{
				for(int j = centerTileYIndex - 10; j <= centerTileYIndex + 10; j++){
					if(j < 0 || j >= map.getXBoundary()){
						add(new TileView(false));
					}
					else{
						TileView newTile = new TileView(map.getTileAtCoordinates(i, j));
						newTile.theLabel.setText((new Integer(i).toString() + " " + new Integer(j).toString()));

						add(newTile);
					}
				}
			}
		}
		*/
		isInitialized = true;
	}

		/*
	private void updateView(){
		//requestFocus();

		//this.removeAll();
		//this.updateUI();

		centerTileXIndex = map.findXLocation(entityToFollow.getLocation());
		centerTileYIndex = map.findYLocation(entityToFollow.getLocation());

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

		//shouldUpdate = false;
	}
	*/

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

	private int getCenterX() {
		return map.findXLocation(entityToFollow.getLocation());
	}
	private int getCenterY() {
		return map.findYLocation(entityToFollow.getLocation());
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int x = getCenterX();
		int y = getCenterY();

		for (int i = 0; i < tileViews.length; ++i) {
			for (int j = 0; j < tileViews[0].length; ++j) {
				int xCoordinate = x + i - tileViews.length / 2;
				int yCoordinate = y + i - tileViews[i].length / 2;
				Tile tile = map.getTileAtCoordinates(xCoordinate, yCoordinate);
				if(tile != null)
					tileViews[i][j].setTile(tile);
				System.out.println("Getting tile at coordinate " + i + ", " + j);
			}
		}
	}

}
