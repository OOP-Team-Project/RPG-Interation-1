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
    private char keyPressed;

    public Controller(){
    }

    @Override
    public void keyPressed(KeyEvent e){
        keyPressed = e.getKeyChar();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed = '\0';
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public char getKey(){
        return keyPressed;
    }
}
