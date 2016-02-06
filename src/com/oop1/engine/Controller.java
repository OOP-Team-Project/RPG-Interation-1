package com.oop1.engine;
import com.oop1.entity.Entity;
import com.oop1.entity.Smasher;
import com.oop1.map.TerrainType;
import com.oop1.map.Tile;
import com.oop1.map.Map;
import com.oop1.view.AreaView;

import javax.swing.*;
import java.applet.Applet;
import java.awt.event.*;

public class Controller implements KeyListener {
    //Entity avatar = Engine.getPlayer(); //avatar
    //get the map
    //Map map = Engine.getCurrentMap();
    private Entity avatar;
    public static AreaView areaView;
    private Engine engine;
    private char keyPressed;

    public Controller(){
        int i = 0;
        //setFocusable(true);
        //requestFocusInWindow();
    }

    public Controller(AreaView av, Entity avatar){
        areaView = av;

        //setOpaque(false);

        //setFocusable(true);
        //requestFocus();
    }

    public Controller(Engine e){
        engine = e;
        //setFocusable(true);
        //requestFocus();
    }

    public static void setAreaView(AreaView av){
        areaView = av;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Entity avatar = engine.getPlayer(); //avatar
        //System.out.println("hehehehehe");
        /*try {
            Thread.sleep(10);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }*/
        System.out.println("Test Test Test");

        keyPressed = e.getKeyChar();

        engine.processInput(keyPressed);
        /*Tile currentTile = avatar.getLocation();    //the Avatar's current location
        Tile moveToTile = currentTile;              //the Tile the Avatar moves to
        int xLoc = map.findXLocation(currentTile);  //get X loc
        int yLoc = map.findYLocation(currentTile);  //get Y loc
        if (pressed == '1') {
            moveToTile = map.getTileAtCoordinates(--xLoc, --yLoc);
        } else if (pressed == '2') {
            moveToTile = map.getTileAtCoordinates(xLoc, --yLoc);
        } else if (pressed == '3') {
            moveToTile = map.getTileAtCoordinates(++xLoc, --yLoc);
        } else if (pressed == '4') {
            moveToTile = map.getTileAtCoordinates(--xLoc, yLoc);
        } else if (pressed == '6') {
            moveToTile = map.getTileAtCoordinates(++xLoc, yLoc);
        } else if (pressed == '7') {
            moveToTile = map.getTileAtCoordinates(--xLoc, ++yLoc);
        } else if (pressed == '8') {
            moveToTile = map.getTileAtCoordinates(xLoc, ++yLoc);
        } else if (pressed == '9') {
            moveToTile = map.getTileAtCoordinates(++xLoc, ++yLoc);
        } else {
            return; //a key was pressed that the controller does not recognize
        }

        if(xLoc < 0){
            xLoc = 0;
            return;
        }
        if(yLoc < 0){
            yLoc = 0;
            return;
        }
        if (xLoc == map.getXBoundary()) {
            xLoc -= 1;
            return;
        }
        if (yLoc == map.getYBoundary()){
            yLoc -= 1;
            return;
        }

        boolean movedSuccessfully = avatar.setLocation(moveToTile); //this will check if the Avatar can move to the tile

        if(movedSuccessfully && areaView != null){
            areaView.setCenterTileXIndex(xLoc);
            areaView.setCenterTileYIndex(yLoc);
            areaView.setShouldUpdate(true); //Tell the area view it needs to refresh.
        }
        */
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public char getKey(){
        return keyPressed;
    }
}
