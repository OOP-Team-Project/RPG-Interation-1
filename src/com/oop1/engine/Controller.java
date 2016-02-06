package com.oop1.engine;
import com.oop1.entity.Entity;
import com.oop1.entity.Smasher;
import com.oop1.map.TerrainType;
import com.oop1.map.Tile;

import java.awt.event.*;

public class Controller implements KeyListener {
    //Entity avatar = new Entity(new Smasher(), new Tile(TerrainType.GRASS)); //avatar
    Entity avatar = Engine.getPlayer();

    @Override
    public void keyPressed(KeyEvent e) {
        char pressed = e.getKeyChar();
        Tile currentTile = avatar.getLocation();;
        Tile moveToTile;
        if(pressed == '1') {

            moveToTile =
        }
        else if(pressed == '2') {

        }
        else if(pressed == '3') {

        }
        else if(pressed == '4') {

        }
        else if(pressed == '5') {

        }
        else if(pressed == '6') {

        }
        else if(pressed == '7') {

        }
        else if(pressed == '8') {

        }
        else if(pressed == '9') {

        }
        else {

        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
