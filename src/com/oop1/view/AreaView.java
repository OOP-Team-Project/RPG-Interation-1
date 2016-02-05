package com.oop1.view;

import javax.swing.JPanel;
import java.awt.*;

/**
 * Displays the subset of visible tiles to the player
 */
public class AreaView extends JPanel {

	private boolean isInitialized = false; //Doing this because, for some reason, constructors aren't working right...

	public AreaView() {

		setLayout(new GridLayout(10, 10)); //lays the tiles from left to right

	}
	/*
	public void drawAreaView() {
		for (int i = 0; i < 50; i++) {
			add(new TileView());
		}
	}
	*/

	private void initializeView(){
		setLayout(new GridLayout(0, 10));
		for(int i = 0; i < 50; i++){
			add(new TileView());//tiles[i] = new TileView();
		}
		isInitialized = true;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		if(!isInitialized)
			initializeView();

		//for(int i = 0; i < 50; i++){
		//	tiles[i].paintComponent(g);
		//}
	}
}