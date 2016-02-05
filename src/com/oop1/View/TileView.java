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

		//BufferedImage duck = Decal.DUCK[0][0];
		//BufferedImage duck;

		//g.drawImage(duck, 0, 0, null);

		g.drawRect(0, 0, 120, 120);
	}
	
}