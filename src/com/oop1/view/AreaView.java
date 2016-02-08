package com.oop1.view;

import com.oop1.engine.Controller;
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
	private boolean alreadyInFunction = false;

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
				tileViews[i][j].setOpaque(true);
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

	public void didUpdate() {
		if(alreadyInFunction)
			return;

		alreadyInFunction = true;
		int x = getCenterX();
		int y = getCenterY()-1; //this puts character in center of map but very dirty
								//why not for xs as well?
		for (int i = 0; i < tileViews.length; ++i) {
			for (int j = 0; j < tileViews[0].length; ++j) {
				int xCoordinate = x + i - tileViews.length / 2;
				int yCoordinate = y + j - tileViews[i].length / 2;
				Tile tile = map.getTileAtCoordinates(xCoordinate, yCoordinate);

				if (tile != null)
					tileViews[i][j].setTile(tile);
				else
					tileViews[i][j].setTile(new Tile(TerrainType.BLANK));

				if (entityToFollow.getLocation().equals(tile)) {
					tileViews[i][j].setEntity(entityToFollow);
				} else {
					tileViews[i][j].setEntity(null);
				}
				repaint();
			}
		}
		alreadyInFunction = false;
		//repaint();
	}
}
