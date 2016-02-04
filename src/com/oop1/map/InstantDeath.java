/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

package com.oop1.map;

public class InstantDeath extends AreaEffect {

    public InstantDeath() {
    }

    public InstantDeath(Set<Tile> tiles){
        this.affectedTiles = tiles;
    }

    public void affectEntity(Entity entity){
      entity.setCurrentLife(0);
      return;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("This InstantDeath affects tiles: ");
        str.append(affectedTiles);

        return str.toString();
    }
}
