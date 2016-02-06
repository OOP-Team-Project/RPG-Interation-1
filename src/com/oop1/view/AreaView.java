package com.oop1.view;

import com.oop1.entity.Entity;
import com.oop1.map.Map;
import com.oop1.map.Tile;

import javax.swing.*;
import java.awt.*;


/**
 * Displays the subset of visible tiles to the player
 */
public class AreaView extends JPanel {

    private boolean isInitialized = false; //Doing this because, for some reason, constructors aren't working right...
    private Map map;
    private Entity entityToFollow;

    private TileView[][] tileViews = new TileView[10][10];

    public AreaView(Map newMap, Entity entityToFollow) {
        map = newMap;
        this.entityToFollow = entityToFollow;
        setLayout(new GridLayout(0, 10));
        setMinimumSize(new Dimension(600, 600));
        setPreferredSize(new Dimension(600, 600));

        for (int i = 0; i < tileViews.length; ++i) {
            for (int j = 0; j < tileViews[0].length; ++j) {
                tileViews[i][j] = new TileView(null);
                add(tileViews[i][j]);
            }
        }
    }

    private int getCenterX() {
        return map.findXLocation(entityToFollow.getLocation());
    }
    private int getCenterY() {
        return map.findYLocation(entityToFollow.getLocation());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = getCenterX();
        int y = getCenterY();

        for (int i = 0; i < tileViews.length; ++i) {
            for (int j = 0; j < tileViews[0].length; ++j) {
                int xCoordinate = x + i - tileViews.length / 2;
                int yCoordinate = y + i - tileViews[i].length / 2;
                Tile tile = map.getTileAtCoordinates(xCoordinate, yCoordinate);
                tileViews[i][j].setTile(tile);
                System.out.println("Getting tile at coordinate " + i + ", " + j);
            }
        }
    }
}
