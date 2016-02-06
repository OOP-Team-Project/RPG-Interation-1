package com.oop1.io;

import com.oop1.engine.GameState;
import com.oop1.map.Map;
import com.oop1.map.TerrainType;
import com.oop1.map.Tile;

import java.io.*;
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

    public SaveManager() {
    }

    public static SaveManager getInstance() {
        return instance;
    }

    public GameState loadGame(String saveName) throws IOException {
        StringBuilder loadedGameData = new StringBuilder();
        Scanner s = null;
        s = new Scanner(new BufferedReader(new FileReader(saveName)));
        while(s.hasNextLine()){
            loadedGameData.append(s.nextLine());
        }
        s.close();

        return Serializer.deserialize(loadedGameData.toString());
    }

    public void saveGame(GameState state, String saveName) throws IOException {
        File output = new File(saveName);
        PrintWriter printer = new PrintWriter(output);
        String saveGameData = Serializer.serialize(state);
        printer.write(saveGameData);
        printer.close();
    }

    public List<String> getAllSaveNames() {
        // TODO: implement this
        return Collections.emptyList();
    }
}
