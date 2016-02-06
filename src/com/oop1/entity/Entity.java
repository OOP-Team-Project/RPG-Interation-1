/*
NW   N   NE
  \  |  /
   7 8 9
 W-4   6-E
   1 2 3
  /  |  \
SW   S   SE
*/

package com.oop1.entity;

import com.oop1.items.TakeableItem;
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

    //Constructor for initial creation of entity
    public Entity(Occupation o) {
        occupation = o;
        baseStats = Stats.builder().occupation(o).build();
        inventory = new Inventory();
        orientation = 0;
    }
    public Entity(Occupation o, Tile loc) {
        occupation = o;
        baseStats = Stats.builder().occupation(o).build();
        inventory = new Inventory();
        orientation = 0;
        location = loc;
    }

    public Entity() {
    }

    /**
     * @return this entity's actual current stats, including modifications from equipped items
     */
    public Stats getModifiedStats() {
        // TODO: implement this
        return baseStats;
    }

    public void addToInventory(TakeableItem item) {
        inventory.addItem(item);
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

