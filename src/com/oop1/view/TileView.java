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
	private JLabel backgroundTexture;
	private ImageIcon backgroundIcon;
	private JLayeredPane jLayeredPane;

	public BufferedImage[][] mMOUNTAIN = decal.load("../resources/MOUNTAINS.png", 60, 60);
	public BufferedImage[][] mWATER = decal.load("../resources/WATER.png", 60, 60);
	public BufferedImage[][] mGRASS = decal.load("../resources/GRASS.png", 60, 60);


	public void setTile(Tile newTile){
		if (decalView != null) {
			jLayeredPane.remove(decalView);
		}
		if (itemView != null) {
			jLayeredPane.remove(itemView);
		}
		if (entityView != null){
			jLayeredPane.remove(entityView);
		}
		if(backgroundTexture != null) {
			jLayeredPane.remove(backgroundTexture);
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
			default: setBackground(Color.BLACK); break;
		}


		// Displays the terrain types on the tiles
		BufferedImage currentTerrain = null;

		switch (theTile.getTerrainType()) {
			case WATER: currentTerrain = mWATER[0][0]; break;
			case GRASS: currentTerrain = mGRASS[0][0]; break;
			case MOUNTAIN: currentTerrain = mMOUNTAIN[0][0]; break;
		}

		if(currentTerrain != null) {
			backgroundIcon.setImage(currentTerrain);
			backgroundTexture.setIcon(backgroundIcon);
			backgroundTexture.setMaximumSize(new Dimension(60, 60));
			backgroundTexture.setPreferredSize(new Dimension(60, 60));
			backgroundTexture.setBounds(0,0,60,60);
			jLayeredPane.add(backgroundTexture, new Integer(zPosition++));
		}


		if (theTile.hasItem()){
			itemView = new ItemView(theTile.getItem());
			itemView.setBounds(0,0,60,60);
			jLayeredPane.add(itemView, new Integer(zPosition++));
			//setComponentZOrder(backgroundTexture, zPosition);
//
//			//Begin hackiest thing you've ever seen in your life.
//			validate();
//			repaint();
//			//remove(itemView);
//			validate();
//			repaint();
//			repaint();
//			repaint();
//			//add(itemView);
//			validate();
//			repaint();
//			repaint();
//			repaint();
//			repaint();
//			//setComponentZOrder(backgroundTexture, zPosition);
//			repaint();
//			//End Hackiest Thing you've ever seen in your life.

		}
		if (theTile.hasDecal()){
			decalView = new DecalView(new Decal(theTile.whichDecal()));
			decalView.setBounds(0,0,60,60);
			jLayeredPane.add(decalView, new Integer(zPosition++));
			//setComponentZOrder(backgroundTexture, zPosition);
		}
	}

	public TileView(Tile newTile){
		setLayout(new BorderLayout());	//Makes sure components take up the whole tile
		jLayeredPane = new JLayeredPane();
		backgroundTexture = new JLabel();
		backgroundIcon = new ImageIcon();
		setTile(newTile);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(jLayeredPane);
	}

	public void setEntity(Entity entity) {
		if (entityView != null) {
			jLayeredPane.remove(entityView);
			entityView = null;
		}
		if (entity != null) {
			entityView = new EntityView(entity.getOccupation().printOccupation());
			entityView.setBounds(0,0,60,60);
			jLayeredPane.add(entityView, jLayeredPane.getComponentCount() - 1);
			//setComponentZOrder(entityView, 0);
		}
		//repaint();
	}
}