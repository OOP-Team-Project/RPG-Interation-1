package com.oop1.io;

import com.oop1.engine.GameState;
import com.oop1.map.Map;
import com.oop1.map.TerrainType;
import com.oop1.map.Tile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

    // This will open file "saveName" and pull out all the data.
    // It will then call deserialize on it to get it into a game state
    // It will then return that game state
    public GameState loadGame(String saveName) throws IOException {
        StringBuilder loadedGameData = new StringBuilder();
        Scanner s = null;
        s = new Scanner(new BufferedReader(new FileReader(saveName)));
        while(s.hasNextLine()){
            loadedGameData.append(s.nextLine());
        }
        if(s != null)
            s.close();

        return Serializer.deserialize(loadedGameData.toString());
    }

    public void saveGame(GameState state, String saveName) {

    }

    public List<String> getAllSaveNames() {
        // TODO: implement this
        return Collections.emptyList();
    }
}
