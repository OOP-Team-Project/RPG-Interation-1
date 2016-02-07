package com.oop1.io;

import com.oop1.engine.GameState;
import com.oop1.entity.Entity;
import com.oop1.entity.Occupation;
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

    /**
     * Loads the default GameState and sets the Avatar's occupation
     * @param o  the occupation of the new Avatar
     * @return   the new GameState
     * @throws IOException  when the default state file can't be read for any reason
     */
    public GameState createNewGameState(Occupation o) throws IOException {
        GameState state = instance.loadGame("map1.txt");
        Tile t = state.getAvatar().getLocation();
        state.getEntities().clear();
        List<Entity> entityList = new ArrayList<Entity>();
        entityList.add(new Entity(o));
        entityList.get(0).setLocation(t);
        state.setEntities(entityList);
        return state;
    }

    public GameState loadGameState() throws IOException {
        GameState state = instance.loadGame("map1.txt");
        //System.out.println(state.getAvatar().getOccupation().printOccupation());
        return state;
    }
}
