package com.oop1.entity;

import com.oop1.items.Item;
import com.oop1.map.Tile;

public class Entity {

    /**
     * integer degrees telling which direction this entity is currently facing
     */
    private int orientation;

    /**
     * the tile this Entity is currently on.
     */
    private Tile location;

    /**
     * this character's base stats, i.e. stats before item modifiers
     */
    private Stats baseStats;

    private Inventory inventory;

    private Occupation occupation;

    public void useItem(Item item) {
        // TODO: implement this
    }

    /**
     * @return this entity's actual current stats, including modifications from equipped items
     */
    public Stats getModifiedStats() {
        // TODO: implement this
        return baseStats;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public Tile getLocation() {
        return location;
    }

    public void setLocation(Tile location) {
        this.location = location;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }
}
