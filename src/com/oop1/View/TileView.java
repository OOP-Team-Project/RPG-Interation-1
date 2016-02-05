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
	
	//method to draw a tile called by drawAreaView in AreaView class

	private Tile theTile;	//This is the tile that this view is responsible for viewing
	private DecalView decalView;

	private BufferedImage duck;

	public TileView(Tile newTile){
		theTile = newTile;

		if(theTile.hasDecal()){
			add(new DecalView());
		}

		try{
			duck = ImageIO.read(new File(getClass().getResource("banana-duck.jpg").toURI()));
		} catch (Exception ex){
			int i = 0;
		}
	}

	public void drawTile() { //pass Tile tile to this method
		
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setLayout(new GridLayout(0, 10));

		//BufferedImage duck = Decal.DUCK[0][0];
		//BufferedImage duck;

		g.drawImage(duck, 0, 0, null);

		//g.drawRect(0, 0, 120, 120);
	}
	
}