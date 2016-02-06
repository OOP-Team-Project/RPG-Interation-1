package com.oop1.engine;

import com.oop1.entity.Entity;
import com.oop1.map.Map;

public class Engine {

    private static final long DESIRED_GAME_TICK_LENGTH_NANOS = 1000000000L / 60L;

    private GameState state;
    private boolean isGameRunning = false;
    private GameThread gameThread;
    private Controller controller;

    public Engine(GameState state) {
        this.state = state;
        this.controller = new Controller(this);
    }

    public void update() {
        // TODO: implement this
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

    public static Entity getPlayer() {
        return state.getAvatar();
    }

    public Map getCurrentMap() {
        // TODO: FIX THIS HACK
        return state.getMaps().get(0);
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
