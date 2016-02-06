package com.oop1.view;

import com.oop1.map.Tile;

import javax.swing.JPanel;
import java.awt.*;

public class TileView extends JPanel {

    private Tile tile;

    public TileView(Tile tile) {
        this.tile = tile;
    }

    public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Color fillColor;
        switch (tile.getTerrainType()) {
            case WATER: fillColor = Color.BLUE; break;
            case MOUNTAIN: fillColor = Color.GRAY; break;
            case GRASS: fillColor = Color.GREEN; break;
            default: fillColor = Color.RED;
        }
        g.setColor(fillColor);
        g.fillRect(0,0,getWidth(),getHeight());
	}

    public void setTile(Tile t) {
        tile = t;
    }
}