/*
NW   N   NE
  \  |  /
   7 8 9
 W-4   6-E
   1 2 3
  /  |  \
SW   S   SE
*/

package com.oop1.Entity;

import com.oop1.Entity.Inventory;
import com.oop1.Entity.Occupation;
import com.oop1.Entity.Stats;
//still need tile class location for line below
import com.oop1.Map.Tile;

public abstract Entity {

  private int orientation;
  private Tile location;
  private Stats stats;
  private Inventory inventory;
  private Occupaton occupation;

  //Constructor for initial creation of entity
  public Entity(Occupation o, Tile loc) {
    occupation = o;
    stats = new Stats(o);
    inventory = new Inventory();
    orientation = 0;
    location = loc;
  }

  //Constructor for loading an existing game
  public Entity() { /*to be written */ }

  public void move(int orientation) {
    //still need a way to check if already moving
    this.orientation = orientation;
    checkMovement();
  }

  private void checkMovement() {
    Tile nextTile = location.getTile(orientation);
    if (nextTile.terrainType.canEntityPass()) {
      location = nextTile;
    }
  }



}
