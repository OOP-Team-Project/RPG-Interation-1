package com.oop1.view;

import javax.swing.*;

import java.awt.*;

import com.oop1.engine.Engine;
import com.oop1.entity.Entity;
import com.oop1.map.Decal;
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

	public TileView(Tile newTile){
		theTile = newTile;
//		Entity avatar = Engine.getPlayer();
//
//		if(avatar.getLocation() == theTile){
//			add(new EntityView(avatar));
//		}

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
		if (theTile != null)
			tileTerrain = theTile.toString();
		if (tileTerrain.equals("^")) {
			g.setColor(Color.gray);
		} else if (tileTerrain.equals("_")) {
			g.setColor(Color.green);
		} else if (tileTerrain.equals("~")) {
			g.setColor(Color.blue);
		} else {
			g.setColor(Color.black);
		}

		this.setBorder(BorderFactory.createLineBorder(Color.black));
		g.fillRect(0, 0, 60, 60);

	}
}