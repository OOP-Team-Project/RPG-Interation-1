package com.oop1.map;

import com.oop1.items.Item;

public class Tile {

    private Decal decal;
    private Item item;
    private TerrainType terrainType;

    public Tile(TerrainType t){
        this.terrainType = t;
    }

    public Tile(TerrainType t, Decal d){
        this.terrainType = t;
        this.decal = d;
    }

    public Tile(TerrainType t, Item i){
        this.terrainType = t;
        this.item = i;
    }

    public Tile(TerrainType t, Item i, Decal d){
        this.terrainType = t;
        this.item = i;
        this.decal = d;
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
