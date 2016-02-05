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
}
