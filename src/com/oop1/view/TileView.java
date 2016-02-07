package com.oop1.view;

import com.oop1.entity.Entity;
import com.oop1.map.Decal;
import com.oop1.map.TerrainType;
import com.oop1.map.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TileView extends JPanel {

	private Tile theTile;	//This is the tile that this view is responsible for viewing
	private DecalView decalView;
	private ItemView itemView;
	private EntityView entityView;
	private Decal decal;
	private BufferedImage currentTerrain;
	private JLabel backgroundTexture;

	public BufferedImage[][] mMOUNTAIN = decal.load("../resources/MOUNTAINS.png", 60, 60);
	public BufferedImage[][] mWATER = decal.load("../resources/WATER.png", 60, 60);
	public BufferedImage[][] mGRASS = decal.load("../resources/GRASS.png", 60, 60);


	public void setTile(Tile newTile){
		if (decalView != null) {
			remove(decalView);
		}
		if (itemView != null) {
			remove(itemView);
		}
		if(backgroundTexture != null) {
			remove(backgroundTexture);
		}
		theTile = newTile;
		drawIconsOnTiles();
	}

	private void drawIconsOnTiles(){
		if (theTile == null)
			return;

		int zPosition = 0;	//For making sure the background is drawn last

		switch (theTile.getTerrainType()) {
			case WATER: setBackground(Color.BLUE); break;
			case GRASS: setBackground(Color.GREEN); break;
			case MOUNTAIN: setBackground(Color.GRAY); break;
		}

		// Displays the terrain types on the tiles
		switch (theTile.getTerrainType()) {
			case WATER: currentTerrain = mWATER[0][0]; break;
			case GRASS: currentTerrain = mGRASS[0][0]; break;
			case MOUNTAIN: currentTerrain = mMOUNTAIN[0][0]; break;
		}

		// I think the issue is here: we might need another variable
		// type for the icon to move with the map
			ImageIcon imageIcon = new ImageIcon(currentTerrain);
			backgroundTexture.setIcon(imageIcon);// = new JLabel(imageIcon);
			backgroundTexture.setMaximumSize(new Dimension(60, 60));
			backgroundTexture.setPreferredSize(new Dimension(60, 60));
			add(backgroundTexture);
			//add(Box.createVerticalGlue());
			//jLabel.setIcon(imageIcon);
			//jLabel.setText("some text")


		if (theTile.hasItem()){
			itemView = new ItemView(theTile.getItem());
			add(itemView);
			setComponentZOrder(backgroundTexture, ++zPosition);
		}
		if (theTile.hasDecal()){
			decalView = new DecalView(new Decal(theTile.whichDecal()));
			add(decalView);
			setComponentZOrder(backgroundTexture, ++zPosition);
		}
	}

	public TileView(Tile newTile){
		setTile(newTile);
		backgroundTexture = new JLabel();
	}

	public void setEntity(Entity entity) {
		if (entityView != null) {
			remove(entityView);
			entityView = null;
		}
		if (entity != null) {
			entityView = new EntityView(entity.getOccupation().printOccupation());
			add(entityView);
			setComponentZOrder(entityView, 0);
		}
	}
}