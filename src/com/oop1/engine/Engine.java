package com.oop1.engine;

import com.oop1.entity.Entity;
import com.oop1.map.Map;
import com.oop1.map.Tile;

public class Engine {

    private static final long DESIRED_GAME_TICK_LENGTH_NANOS = 1000000000L / 60L;

    private GameState state;
    private boolean isGameRunning = false;
    private GameThread gameThread;
    private Controller controller;

    private char[] keyPresses = new char[10];   //Holds last 10 chars

    public Engine(GameState state) {
        this.state = state;
        this.controller = new Controller(this);
    }

    public void update() {
        // TODO: implement this
        processInput(controller.getKey());
    }

    public void beginGame() {
        gameThread = new GameThread();
        isGameRunning = true;
        gameThread.start();
    }

    public void endGame() {
        // tell the game thread to stop running
        isGameRunning = false;

        // wait for the game thread to finish its last iteration
        try {
            gameThread.join();
            // possibly prepare some sort of results or something down here.
        } catch (InterruptedException e) {
            System.err.println("Failed to get result of game due to an error.");
            e.printStackTrace();
        }
    }

    public Entity getPlayer() {
        return state.getAvatar();
    }

    public Map getCurrentMap() {
        // TODO: FIX THIS HACK
        return state.getMaps().get(0);
    }

    public void processInput(char c){
        for(int i = 0; i < 9; i++){
            keyPresses[i] = keyPresses[i + 1];
        }
        keyPresses[9] = c;

        Entity avatar = state.getAvatar();
        Map map = state.getMaps().get(0);


        Tile currentTile = avatar.getLocation();    //the Avatar's current location
        Tile moveToTile = currentTile;              //the Tile the Avatar moves to
        int xLoc = map.findXLocation(currentTile);  //get X loc
        int yLoc = map.findYLocation(currentTile);  //get Y loc

        if (keyPresses[9] == '1') {
            moveToTile = map.getTileAtCoordinates(--xLoc, --yLoc);
        } else if (keyPresses[9] == '2') {
            moveToTile = map.getTileAtCoordinates(xLoc, --yLoc);
        } else if (keyPresses[9]  == '3') {
            moveToTile = map.getTileAtCoordinates(++xLoc, --yLoc);
        } else if (keyPresses[9]  == '4') {
            moveToTile = map.getTileAtCoordinates(--xLoc, yLoc);
        } else if (keyPresses[9]  == '6') {
            moveToTile = map.getTileAtCoordinates(++xLoc, yLoc);
        } else if (keyPresses[9]  == '7') {
            moveToTile = map.getTileAtCoordinates(--xLoc, ++yLoc);
        } else if (keyPresses[9]  == '8') {
            moveToTile = map.getTileAtCoordinates(xLoc, ++yLoc);
        } else if (keyPresses[9]  == '9') {
            moveToTile = map.getTileAtCoordinates(++xLoc, ++yLoc);
        } else {
            return; //a key was pressed that the controller does not recognize
        }

        avatar.setLocation(moveToTile);
    }

    private class GameThread extends Thread {

        public void run() {
            while (isGameRunning) {
                long startTime = System.nanoTime();

                update();
                long endTime = System.nanoTime();
                long elapsed = endTime - startTime;

                try {
                    sleep(DESIRED_GAME_TICK_LENGTH_NANOS - elapsed);
                } catch (InterruptedException e) {
                    System.err.println("The game ended unexpectedly");
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
