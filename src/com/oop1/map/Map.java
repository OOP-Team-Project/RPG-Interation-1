package com.oop1.map;

import java.util.List;

public class Map {

    private Tile[][] tiles;
    private List<AreaEffect> areaEffects;

    public static Map generateMap() {
        return new Map();
    }

    // TODO: check bounds
    public Tile getTileAtCoordinates(int x, int y) {
        return tiles[x][y];
    }

}
