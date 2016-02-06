package com.oop1.engine;


import com.oop1.entity.Entity;
import com.oop1.map.Map;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class Engine {
    private static GameState state;    //This holds the map and entities (i.e., the data)

    private static List<JPanel> views; //This holds the currentViews (i.e. AreaView, StatusView, etc.)
    private static JFrame mainFrame;   //This is the frame that binds the universe together.

    public Engine(GameState newState, List<JPanel> newViews) {    //Constructor for the engine. I guess it will hook up Views/Maps and such?
        state = newState;
        views = newViews;

        mainFrame = new JFrame("Team TigerTiger Cat's Awesome RPG Game!");
        mainFrame.setSize(1200, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        //mainFrame.setLayout(new GridLayout(1, 1));

        for(int i = 0; i < newViews.size(); i++) {
            mainFrame.add(newViews.get(i));
            mainFrame.setComponentZOrder(newViews.get(i), 0);
        }
    }


    public void update() {  //Called by RunGame every frame.

        //So my idea for this is to call paint on all of the views and see how that goes.
        for(int i = 0; i < views.size(); i++)
            views.get(i).repaint();

        //For debugging:
        if(views.size() > 2){
            int i = 0;
        }

        mainFrame.setVisible(true);
    }

    public static void beginGame(List<JPanel> viewsToAdd, List<Map> mapsToAdd, List<Entity> entitiesToAdd) {
                                        //Static because it needs to be called by views. If we don't want this, we can find
                                        // find some other way to link Engine and views (make all views a subclass of
                                        // a "View" class that includes a reference to an engine would be a good way, I think)
        // TODO: implement this better
        for(int i = 0; i < viewsToAdd.size(); i++){
            views.add(viewsToAdd.get(i));   //We add in any views that the game should start with (AreaView, etc)
            mainFrame.add(viewsToAdd.get(i));   //And assign them to the main frame (otherwise they won't get drawn!)
            mainFrame.setComponentZOrder(viewsToAdd.get(i), 0);
        }
        state.setMaps(mapsToAdd);       //We add in the maps that comprise this game.
        state.setEntities(entitiesToAdd);   //We add in the entities that are in the game.

    }

    public void endGame() {
        // TODO: implement this
    }


    public static Entity getPlayer(){
        return state.getEntities().get(0);
    }


    public static void addView(JPanel newView){
        views.add(newView);
        mainFrame.add(newView);
        mainFrame.setComponentZOrder(newView, 0);
    }

    public static void removeView(JPanel viewToRemove){
        views.remove(viewToRemove);
        mainFrame.remove(viewToRemove);
    }


    public static Map getCurrentMap(){
        return state.getMaps().get(0);  //Hacky, hacky thing!!!
    }

}
