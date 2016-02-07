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
	private EntityView entityView;
	public JLabel theLabel;

	private String tileTerrain;

	public TileView(boolean thing){	//Used to do blank tils.
		tileTerrain = "Blank";

		theLabel = new JLabel("!!!");
		add(theLabel);
	}

	public void setTile(Tile newTile){
		theTile = newTile;
	}

	private void drawIconsOnTiles(){
		if(theTile.hasItem()){
			setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			setMaximumSize(new Dimension(60,60));
			setPreferredSize(new Dimension(60,60));
			add(new ItemView(theTile.getItem()));
			add(Box.createVerticalGlue());
		}

		if(theTile.hasDecal()){
			setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			setMaximumSize(new Dimension(60,60));
			setPreferredSize(new Dimension(60,60));
			add(new DecalView(theTile.getDecal()));
			add(Box.createVerticalGlue());
		}
	}

	public TileView(Tile newTile){
		theTile = newTile;
		drawIconsOnTiles();
	}

	public TileView(Tile newTile, String occupation){
		theTile = newTile;
		drawIconsOnTiles();

		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setMaximumSize(new Dimension(60,60));
		setPreferredSize(new Dimension(60,60));
		add(new EntityView(occupation));
		add(Box.createVerticalGlue());
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
		Graphics2D g2 = (Graphics2D) g;
		//based off tileTerrain set color
		switch (theTile.getTerrainType()) {
			case MOUNTAIN:
				g2.setColor(Color.gray);
				break;
			case GRASS:
				g2.setColor(Color.green);
				break;
			case WATER:
				g2.setColor(Color.blue);
				break;
		}

		this.setBorder(BorderFactory.createLineBorder(Color.black));
		g2.fillRect(0, 0, 60, 60);
	}
}