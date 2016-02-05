package com.oop1.map;

import com.oop1.items.Item;

public class Tile {

    private Decal decal;
    private Item item;
    private TerrainType terrainType;

    public Tile(TerrainType t){
        this.terrainType = t;
    }

    public void setItem(Item newItem){
        item = newItem;
    }

    public void setDecal(Decal newDecal){
        decal = newDecal;
    }

    public TerrainType getTerrainType(){
        return terrainType;
    }

    public boolean hasItem(){
        if(item == null)
            return false;
        else
            return true;
    }

    public void removeItem(){
        item = null;
    }

    public void addItem(Item newItem){
        item = newItem;
    }

    public String toString(){
        if(terrainType == TerrainType.MOUNTAIN)
            return "M";
        else if(terrainType == TerrainType.GRASS)
            return "G";
        else
            return "W";
    }
}
