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
import com.oop1.map.TerrainType;
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

    /**
     * Tells the game tick at which this character last moves
     */
    private long lastMoveTime;

    /**
     * The number of ticks between moves that this character must wait.
     */
    private long minimumTimeBetweenMoves = 6;

    private char[] keyPresses = new char[10];   //Holds last 10 chars

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

    public Tile getLocation() { return location; }

    public boolean setLocation(Tile location) {
        if(location == null)
            return false;
        if(location.getTerrainType() == null)
            return false;
        TerrainType terrain = location.getTerrainType();
        if(terrain.canEntityPass(this)) {
            this.location = location;
            return true;    //We did it!
        }
        else {
            return false;   //We couldn't do it... (SFX: "Christmas Time is Here" intro plays)
        }
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

    public void setLastMoveTime(long lastMoveTime) {
        this.lastMoveTime = lastMoveTime;
    }

    public long getLastMoveTime() {
        return lastMoveTime;
    }

    public long getMinimumTimeBetweenMoves() {
        return minimumTimeBetweenMoves;
    }

    public void setMinimumTimeBetweenMoves(long minimumTimeBetweenMoves) {
        this.minimumTimeBetweenMoves = minimumTimeBetweenMoves;
    }
}

