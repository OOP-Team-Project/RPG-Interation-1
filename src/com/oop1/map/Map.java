package com.oop1.map;

import java.util.List;

public class Map {

    private Tile[][] tiles;
    private List<AreaEffect> areaEffects;

    public void setTiles(Tile[][] newTiles){
        tiles = newTiles;
    }

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

    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < tiles.length; ++i){
            for(int j = 0; j < tiles[i].length; ++j){
                str.append(tiles[i][j]);
            }
            str.append("\n");
        }
        return str.toString();
    }
}
