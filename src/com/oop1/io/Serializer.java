package com.oop1.io;

import com.oop1.engine.GameState;
import com.oop1.items.*;
import com.oop1.map.Decal;
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

    private static void deserializeDecals(String decalData, Map map){
        String[] decals = decalData.split("%");
        for(String str : decals){
            Decal decal;
            String decalType = str.substring(0, str.indexOf(';'));
            int x = Integer.parseInt(str.substring(str.indexOf(';')+1, str.indexOf(',')));
            int y = Integer.parseInt(str.substring(str.indexOf(',')+1));
            System.out.println(decalType + "  " + x + ", " + y);
            if(decalType == "RED_CROSS")
                decal = Decal.RED_CROSS;
            else if(decalType == "GOLD_STAR")
                decal = Decal.GOLD_STAR;
            else
                decal = Decal.SKULL_AND_CROSSBONES;
            map.getTileAtCoordinates(x, y).setDecal(decal);
        }
    }

    private static void deserializeItems(String itemData, Map map){
        String[] items = itemData.split("%");
        for(String str : items){
            Item item;
            String itemType = str.substring(0, str.indexOf(';'));
            int x = Integer.parseInt(str.substring(str.indexOf(';')+1, str.indexOf(',')));
            int y = Integer.parseInt(str.substring(str.indexOf(',')+1));
            System.out.println(itemType + "  " + x + ", " + y);
            if(itemType == "interactive")
                item = new InteractiveItem();
            else if(itemType == "oneShot")
                item = new OneShotItem();
            else if(itemType == "takeable")
                item = new TakeableItem();
            else
                item = new Obstacle();
            map.getTileAtCoordinates(x, y).setItem(item);
        }
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
        deserializeDecals(data[2], loadedMap);
        deserializeItems(data[3], loadedMap);

        System.out.println(loadedMap);

        return new GameState();
    }
}
