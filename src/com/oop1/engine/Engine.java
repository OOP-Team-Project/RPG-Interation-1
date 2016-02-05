package com.oop1.engine;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Engine {
    private GameState state;    //This holds the map and entities (i.e., the data)

    private List<JPanel> views; //This holds the currentViews (i.e. AreaView, StatusView, etc.)
    private JFrame mainFrame;   //This is the frame that binds the universe together.

    public Engine(GameState newState, List<JPanel> newViews) {    //Constructor for the engine. I guess it will hook up Views/Maps and such?
        state = newState;

        views = newViews;

        mainFrame = new JFrame("Team TigerTiger Cat's Awesome RPG Game!");
        mainFrame.setSize(500,500);
        mainFrame.setLayout(new GridLayout(1, 1));

        for(int i = 0; i < newViews.size(); i++)
            mainFrame.add(newViews.get(i));
    }


    public void update() {
        // TODO: implement this
        //So my idea for this is to call paint on all of the views and see how that goes.
        for(int i = 0; i < views.size(); i++)
            views.get(i).repaint();

        mainFrame.setVisible(true);
    }

    public void beginGame() {
        // TODO: implement this better

        //Yeah, soooo... if I'm understanding this correctly, we "initiate" the game. That is, we link up an area
        // view with the data maintained by this current gameState.

        //AreaView

    }

    public void endGame() {
        // TODO: implement this
    }
}
