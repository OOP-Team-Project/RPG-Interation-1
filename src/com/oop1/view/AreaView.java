package com.oop1.view;

import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Displays the subset of visible tiles to the player
 */
public class AreaView extends JPanel {

	public AreaView() {
		setLayout(new GridLayout(0, 20)); //lays the tiles from left to right
		for (int i = 0; i < 200; i++) {
			add(new TileView());
		}
	}

}