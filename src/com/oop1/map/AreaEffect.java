/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

package com.oop1.map;

public abstract class AreaEffect {

    //Tile[] affectedTiles;
    protected int[] affectedTiles;

    //public void affectEntity(Entity entity);
    public abstract void affectEntity();

    //public boolean canAffectEntity(Entity entity){
    public boolean canAffectEntity(int location) {
      /*
      for(Tile tile : affectedTiles){
         if(tile == entity.getLocation())
            return true;
      }
      */
        for (int tile : affectedTiles) {
            if (tile == location)
                return true;
        }

        return false;
    }

    //public Tile[] getAffectedTiles(){
    public int[] getAffectedTiles() {
        return affectedTiles;
    }

    //public void setAffectedTiles(Tile[] newTiles){
    public void setAffectedTiles(int[] newTiles) {
        affectedTiles = newTiles;
    }
}
