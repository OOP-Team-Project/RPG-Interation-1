/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

package com.oop1.map;

import com.oop1.entity.Entity;

import java.util.Set;

public class LevelUp extends AreaEffect {

    public LevelUp() {
    }

    public LevelUp(Set<Tile> tiles){
        this.affectedTiles = tiles;
    }

    public void affectEntity(Entity entity){
      entity.getBaseStats().immediatelyGainLevel();
      return;
    }

    public String getEffectName(){
        return "levelUp";
    }

    public int getDamageAmount(){
        return 0;
    }
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("This LevelUp affects tiles: ");
        str.append(affectedTiles);

        return str.toString();
    }
}
