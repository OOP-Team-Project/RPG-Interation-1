package com.oop1.view;

import com.oop1.map.Map;

import javax.swing.JPanel;
import java.awt.*;

/**
 * Displays the subset of visible tiles to the player
 */
public class AreaView extends JPanel {

	private boolean isInitialized = false; //Doing this because, for some reason, constructors aren't working right...
	private Map map;

	public AreaView(Map newMap) {

		map = newMap;
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
			for(int j = 0; j < 25; j++) {
				//Check the player position??
				//Calculate which coordinates we need to display.


				add(new TileView(map.getTileAtCoordinates(1, 1)));//tiles[i] = new TileView();
			}
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
