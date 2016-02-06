package com.oop1.map;

import com.oop1.entity.Entity;

import java.awt.*;

public enum TerrainType {

    // TODO: make sure these are the right types

    MOUNTAIN(false),
    WATER(false),
    GRASS(true);

    private boolean isPassable;
    private Color fillColor;

    TerrainType(boolean isPassable) {
        this.isPassable = isPassable;
    }

    public boolean canEntityPass(Entity entity) {
        return isPassable;
    }

}
