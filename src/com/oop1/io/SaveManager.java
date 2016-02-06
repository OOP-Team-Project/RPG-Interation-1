package com.oop1.io;

import com.oop1.engine.GameState;

import java.util.Collections;
import java.util.List;

/**
 * A singleton class to manage saves on disk.
 */
public class SaveManager {

    private static SaveManager instance;

    static {
        instance = new SaveManager();
    }

    private SaveManager() {
    }

    public static SaveManager getInstance() {
        return instance;
    }

    public GameState loadGame(String saveName) {
        // TODO: implement this
        return new GameState(null, null, null);
    }

    public void saveGame(GameState state, String saveName) {

    }

    public List<String> getAllSaveNames() {
        // TODO: implement this
        return Collections.emptyList();
    }
}
