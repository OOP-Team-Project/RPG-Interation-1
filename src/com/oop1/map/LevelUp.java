/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

package com.oop1.map;

public class LevelUp extends AreaEffect {

    public LevelUp() {
    }

    public LevelUp(Set<Tile> tiles){
        this.affectedTiles = tiles;
    }

    public void affectEntity(Entity entity){
      int currLevel = entity.getLevel();
      entity.setLevel(currLevel);
      entity.setExperience(0);

      return;
    }

    public String toString() {
        String retString;
        retString = "This Level Up affects tiles: \n";

        for(Tile tile : affectedTiles){
            retString += tile + "\n";
        }

        return retString;
    }
}
