package com.oop1.io;

import com.oop1.engine.GameState;
import com.oop1.map.Map;
import com.oop1.map.TerrainType;
import com.oop1.map.Tile;

public class Serializer {

    private static Map deserializeMap(String mapData){
        int numRows = 0, numCols = 0;
        char[] mapCharArray = mapData.toCharArray();
        for(char c : mapCharArray){
            if(c == '%')
                ++numRows;
        }
        numCols = mapData.indexOf("%");
        Tile[][] tiles = new Tile[numRows][numCols];
        int i = 0, j = 0;
        for(char c : mapCharArray){
            if(c == 'G')
                tiles[i][j++] = new Tile(TerrainType.GRASS);
            else if(c == 'W')
                tiles[i][j++] = new Tile(TerrainType.WATER);
            else if(c == 'M')
                tiles[i][j++] = new Tile(TerrainType.MOUNTAIN);
            else if(c == '%'){
                ++i;
                j = 0;
            }
        }
        Map mapReturn = new Map();
        mapReturn.setTiles(tiles);
        return mapReturn;
    }

    public String serialize(GameState state) {
        // TODO: implement this
        return "";
    }

    public static GameState deserialize(String loadData) {
        // TODO: implement this
        // Objects that go into the GameState
        Map loadedMap;

        // Split up the map, decals, items, area effects, entities, and inventory
        String[] data = loadData.split("!");

        // Deal with the map data
        loadedMap = deserializeMap(data[1]);




        System.out.println(loadedMap);

        return new GameState();
    }
}
