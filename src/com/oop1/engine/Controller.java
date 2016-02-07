package com.oop1.engine;
import com.oop1.entity.Entity;
import com.oop1.entity.Smasher;
import com.oop1.map.TerrainType;
import com.oop1.map.Tile;
import com.oop1.map.Map;

import java.awt.event.*;

public class Controller implements KeyListener {

    private Entity avatar;
    private Map map;

    public Controller(Engine engine) {
        avatar = engine.getPlayer(); //avatar
        map = engine.getCurrentMap();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char pressed = e.getKeyChar();
        Tile currentTile = avatar.getLocation();    //the Avatar's current location
        Tile moveToTile = currentTile;              //the Tile the Avatar moves to
        int xLoc = map.findXLocation(currentTile);  //get X loc
        int yLoc = map.findYLocation(currentTile);  //get Y loc
        if (pressed == '1') {
            moveToTile = map.getTileAtCoordinates(xLoc - 1, yLoc - 1);
        } else if (pressed == '2') {
            moveToTile = map.getTileAtCoordinates(xLoc, yLoc - 1);
        } else if (pressed == '3') {
            moveToTile = map.getTileAtCoordinates(xLoc + 1, yLoc - 1);
        } else if (pressed == '4') {
            moveToTile = map.getTileAtCoordinates(xLoc - 1, yLoc);
        } else if (pressed == '6') {
            moveToTile = map.getTileAtCoordinates(xLoc + 1, yLoc);
        } else if (pressed == '7') {
            moveToTile = map.getTileAtCoordinates(xLoc - 1, yLoc + 1);
        } else if (pressed == '8') {
            moveToTile = map.getTileAtCoordinates(xLoc, yLoc + 1);
        } else if (pressed == '9') {
            moveToTile = map.getTileAtCoordinates(xLoc + 1, yLoc + 1);
        } else {
            //a key was pressed that the controller does not recognize
        }
        if (pressed == 's') System.out.print("here!");
        else avatar.setLocation(moveToTile); //this will check if the Avatar can move to the tile
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}