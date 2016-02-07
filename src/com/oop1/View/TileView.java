package com.oop1.view;

import java.awt.*;

import com.oop1.map.Decal;
import com.oop1.map.TerrainType;
import com.oop1.map.Tile;
import com.oop1.view.DecalView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileView extends JPanel {

	private Tile theTile;	//This is the tile that this view is responsible for viewing
	private DecalView decalView;
	public JLabel theLabel;

	private String tileTerrain;

	public TileView(Tile newTile){
		theTile = newTile;
		if(newTile == null){
			return;
		}
		if(theTile.hasItem()){
			//add(new ItemView(theTile.getItem()));
			int i = 0;
		}

		if(theTile.hasDecal()){
			add(new DecalView(theTile.getDecal()));
		}

		theLabel = new JLabel("!!!");
		add(theLabel);
	}

	public TileView(boolean thing){	//Used to do blank tils.
		tileTerrain = "Blank";

		theLabel = new JLabel("!!!");
		add(theLabel);
	}

	public void setTile(Tile newTile){
		theTile = newTile;
	}

	public void drawTile() { //pass Tile tile to this method

	}

	public void addLabel(JLabel newLabel){
		//theLabel = newLabel;
		//add(theLabel);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//based off tileTerrain set color
		switch (theTile.getTerrainType()) {
			case MOUNTAIN:
				g.setColor(Color.gray);
				break;
			case GRASS:
				g.setColor(Color.green);
				break;
			case WATER:
				g.setColor(Color.blue);
				break;
		}

		this.setBorder(BorderFactory.createLineBorder(Color.black));
		g.fillRect(0, 0, 60, 60);
	}
	
}