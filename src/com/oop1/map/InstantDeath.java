/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

package com.oop1.map;

import com.oop1.entity.Entity;

import java.util.Set;

public class InstantDeath extends AreaEffect {

    public InstantDeath() {
    }

    public InstantDeath(Set<Tile> tiles){
        this.affectedTiles = tiles;
    }

    public void affectEntity(Entity entity){
      entity.getBaseStats().takeDamage(entity.getBaseStats().getCurrentLife());
      return;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("This InstantDeath affects tiles: ");
        str.append(affectedTiles);

        return str.toString();
    }
}
