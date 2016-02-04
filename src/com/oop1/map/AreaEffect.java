/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

package com.oop1.map;
import java.util.*;



public abstract class AreaEffect {

    Set<Tile> affectedTiles = new HashSet<Tile>();

    public abstract void affectEntity(Entity entity);

    public boolean canAffectEntity(Entity entity){
      if(affectedTiles.contains(entity.getLocation()))
         return true;
      else
         return false;
    }

    public Set<Tile> getAffectedTiles(){
        return affectedTiles;
    }

    public void setAffectedTiles(Set<Tile> newTiles){
        affectedTiles = newTiles;
    }
}
