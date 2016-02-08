package com.oop1.map;

import com.oop1.entity.Entity;

import java.awt.image.BufferedImage;

public enum TerrainType {

    // TODO: make sure these are the right types

    MOUNTAIN(false),
    WATER(false),
    GRASS(true),
    BLANK(false);

    private Decal decal;        // used for load method
    private BufferedImage[][] currentTerrain;

    public BufferedImage[][] mMOUNTAIN = decal.load("resources/MOUNTAINS.png", 60, 60);
    public BufferedImage[][] mWATER = decal.load("resources/WATER.png", 60, 60);
    public BufferedImage[][] mGRASS = decal.load("resources/GRASS.png", 60, 60);



    private boolean isPassable;

    TerrainType(boolean isPassable) {
        this.isPassable = isPassable;
    }

    public boolean canEntityPass(Entity entity) {
        return isPassable;
    }

    public static TerrainType fromChar(char c) {
        switch (c) {
            case '_': return GRASS;
            case '~': return WATER;
            case '^': return MOUNTAIN;
            default: return BLANK;
        }
    }

    public BufferedImage[][] getTerrainImage(Tile tile){

        String terrainType = tile.toString();
        if (tile != null) {
            if (terrainType.equals("^")) {
                currentTerrain = mMOUNTAIN;
            } else if (terrainType.equals("~")) {
                currentTerrain = mWATER;
            } else if (terrainType.equals("_")) {
                currentTerrain = mGRASS;
            }
        }

        return currentTerrain;
    }
}
