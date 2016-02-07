package com.oop1.view;

import com.oop1.map.Decal;
import com.oop1.map.Tile;

import javax.swing.*;
import java.awt.*;

public class TileView extends JPanel {

	private Tile theTile;	//This is the tile that this view is responsible for viewing
	private DecalView decalView;
	private ItemView itemView;

	public void setTile(Tile newTile){
		if (decalView != null) {
			remove(decalView);
		}
		if (itemView != null) {
			remove(itemView);
		}
		theTile = newTile;
		drawIconsOnTiles();
	}

	private void drawIconsOnTiles(){
		if (theTile == null)
			return;

		switch (theTile.getTerrainType()) {
			case WATER: setBackground(Color.BLUE); break;
			case GRASS: setBackground(Color.GREEN); break;
			case MOUNTAIN: setBackground(Color.GRAY); break;
		}

		if (theTile.hasItem()){
			itemView = new ItemView(theTile.getItem());
			add(itemView);
		}

		if (theTile.hasDecal()){
			decalView = new DecalView(new Decal("SKULL_AND_CROSSBONES"));
			add(decalView);
		}
	}

	public TileView(Tile newTile){
		setTile(newTile);
	}
}