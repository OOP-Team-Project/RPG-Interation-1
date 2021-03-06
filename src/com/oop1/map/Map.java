package com.oop1.map;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private Tile[][] tiles;
    private List<AreaEffect> areaEffects = new ArrayList<AreaEffect>();

    public void setTiles(Tile[][] newTiles){
        tiles = newTiles;
    }

    public Tile[][] getTiles(){
        return tiles;
    }

    public List<AreaEffect> getAreaEffects(){
        return areaEffects;
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

    public void addAreaEffect(AreaEffect effect){
        areaEffects.add(effect);
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < tiles.length; ++i){
            for(int j = 0; j < tiles[i].length; ++j){
                str.append(tiles[i][j]);
            }
            str.append("%\n");
        }
        return str.toString();
    }

    public int getXBoundary() {
        return tiles.length;
    }
    public int getYBoundary(){
        return tiles[0].length;
    }

    public int findXLocation(Tile toFind){
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if(tiles[i][j] == toFind)
                    return i;
            }
        }
        return -1;  //Couldn't find it!
    }

    public int findYLocation(Tile toFind){
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if(tiles[i][j] == toFind)
                    return j;
            }
        }
        return -1;  //Couldn't find it!
    }
}
