package com.oop1.map;

import java.util.List;

public class Map {

    private Tile[][] tiles;
    private List<AreaEffect> areaEffects;

    public static Map generateMap() {
        return new Map();
    }

    public Tile getTileAtCoordinates(int x, int y){

        if (x >= 0 && x < tiles.length) {
            if (y >= 0 && y < tiles[x].length)
                return tiles[x][y];
        }
        return null;
    }
}
