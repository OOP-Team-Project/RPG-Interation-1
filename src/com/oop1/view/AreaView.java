package com.oop1.view;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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


	public JFrame gameFrame = new JFrame();
	String[] areaEffect = {"grass", "water", "mountains"}; //using list of areaEffect for testing purposes


	public AreaView() {
		setLayout(new GridLayout(0, 10)); //lays the tiles from left to right

		//gameFrame.add(displayArea); //adds a new AreaView to the frame
		gameFrame.setSize(1200, 600);
		gameFrame.setTitle("Game");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    
}

