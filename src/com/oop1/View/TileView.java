package com.oop1.view;

import com.oop1.map.Decal;
import com.oop1.map.Tile;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileView extends JPanel {

	private Tile theTile;	//This is the tile that this view is responsible for viewing
	private DecalView decalView;


	public TileView(Tile newTile){
		theTile = newTile;

		if(theTile.hasItem()){
			add(new ItemView(theTile.getItem()));
		}

		if(theTile.hasDecal()){
			add(new DecalView());
		}
	}

	public void drawTile() { //pass Tile tile to this method
		
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setLayout(new GridLayout(0, 1));

		g.drawRect(0, 0, 60, 60);
	}
	
}