package com.oop1.map;

import java.util.List;

public class Map {

    private Tile[][] tiles;
    private List<AreaEffect> areaEffects;

    public static Map generateMap() {
        return new Map();
    }

    public Tile getTileAtCoordinates(int x, int y) {
        try{
            return tiles[x][y];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("No tile exists at (" + x + ", " + y + "). Returning (0, 0)");
            throw e;
        }
    }
}
