package com.oop1.view;

import com.oop1.map.Decal;
import com.oop1.map.Tile;

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

		if(theTile.hasItem()){
			//add(new ItemView(theTile.getItem()));
			int i = 0;
		}

		if(theTile.hasDecal()){
			add(new DecalView());
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
		setLayout(new GridLayout(0, 1));

		//g.drawRect(0, 0, 60, 60);
		if(theTile != null)
			tileTerrain = theTile.toString();
		if (tileTerrain == "M") {
			g.setColor(Color.gray);
		} else if (tileTerrain == "G") {
			g.setColor(Color.green);
		} else if (tileTerrain == "W"){
			g.setColor(Color.blue);
		} else{
			g.setColor(Color.black);
		}


		this.setBorder(BorderFactory.createLineBorder(Color.black));
		g.fillRect(0, 0, 60, 60);
	}
	
}