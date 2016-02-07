package com.oop1.engine;

import com.oop1.RunGame;
import com.oop1.entity.Entity;
import com.oop1.map.Map;
import com.oop1.map.Tile;

public class Engine {

    private static final long DESIRED_GAME_TICK_LENGTH_NANOS = 1000000000L / 60L;
    private static final long DESIRED_GAME_TICK_LENGTH_MILLISECONDS = 1000L / 60L;

    private GameState state;
    private boolean isGameRunning = false;
    private GameThread gameThread;
    private Controller controller;
    private long currentTick = 0L;

    private RunGame runGame;

    private char[] keyPresses = new char[10];   //Holds last 10 chars

    public Engine(GameState state, RunGame rg) {
        this.state = state;
        this.runGame = rg;
    }

    public void update() {
        processInput(controller.getKey());
        currentTick++;
    }

    public void beginGame() {
        gameThread = new GameThread();
        isGameRunning = true;
        gameThread.start();
        currentTick = 0;
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

    public void processInput(char c) {
        Entity avatar = state.getAvatar();

        if (currentTick - avatar.getLastMoveTime() <= avatar.getMinimumTimeBetweenMoves()) {
            return;
        }

        Map map = state.getMaps().get(0);

        Tile currentTile = avatar.getLocation();    //the Avatar's current location
        Tile moveToTile = currentTile;              //the Tile the Avatar moves to
        int xLoc = map.findXLocation(currentTile);  //get X loc
        int yLoc = map.findYLocation(currentTile);  //get Y loc

        switch (c) {
            case '1':
                moveToTile = map.getTileAtCoordinates(xLoc + 1, yLoc - 1);
                break;
            case '2':
            case 's': // fall through
                moveToTile = map.getTileAtCoordinates(xLoc + 1, yLoc);
                break;
            case '3':
                moveToTile = map.getTileAtCoordinates(xLoc + 1, yLoc + 1);
                break;
            case '4':
            case 'a': // fall through
                moveToTile = map.getTileAtCoordinates(xLoc, yLoc - 1);
                break;
            case '6':
            case 'd': // fall through
                moveToTile = map.getTileAtCoordinates(xLoc, yLoc + 1);
                break;
            case '7':
                moveToTile = map.getTileAtCoordinates(xLoc - 1, yLoc - 1);
                break;
            case '8':
            case 'w': // fall through
                moveToTile = map.getTileAtCoordinates(xLoc - 1, yLoc);
                break;
            case '9':
                moveToTile = map.getTileAtCoordinates(xLoc - 1, yLoc + 1);
                break;
        }

        if (avatar.setLocation(moveToTile)) {
            runGame.stateChanged(this);
            avatar.setLastMoveTime(currentTick);
        }

    }

    public void setRunning(boolean b){
        isGameRunning = true;
    }

    public void setController(Controller c){
        controller = c;
    }

    private class GameThread extends Thread {

        public void run() {
            while(true) {
                if(isGameRunning) {
                    long startTime = System.currentTimeMillis();

                    update();
                    long endTime = System.currentTimeMillis();
                    long elapsed = endTime - startTime;

                    try {
                        if(DESIRED_GAME_TICK_LENGTH_MILLISECONDS - elapsed > 0) {
                            //sleep(DESIRED_GAME_TICK_LENGTH_MILLISECONDS - elapsed);
                            sleep(1);
                        }
                    } catch (InterruptedException e) {
                        System.err.println("The game ended unexpectedly");
                        e.printStackTrace();
                        break;
                    }
                }
            }
        }
    }
}
