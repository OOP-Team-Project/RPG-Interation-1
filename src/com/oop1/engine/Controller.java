package com.oop1.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class Controller implements KeyListener {

    private Set<Character> pressedKeys;

    private char keyPressed;

    public Controller(){
        pressedKeys = new HashSet<Character>();
    }

    @Override
    public void keyPressed(KeyEvent e){
        pressedKeys.add(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public char getKey(){
        return keyPressed;
    }

    public Set<Character> getPressedKeys() {
        return pressedKeys;
    }
}
