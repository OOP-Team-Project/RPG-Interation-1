/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

package com.oop1.map;

public class TakeDamage extends AreaEffect {

    private int damageTaken;

    public TakeDamage() {
        this.damageTaken = 10;
    }

    public TakeDamage(Set<Tile> tiles){
        this.affectedTiles = tiles;
        this.damageTaken = 10;
    }

    public TakeDamage(Tile[] tiles, int damageAmount){
        this.affectedTiles = tiles;
        this.damageTaken = damageAmount;
    }

    public void affectEntity(Entity entity){
      int currentHealth = entity.getCurrentLife();
      entity.setCurrentHealth(currentHealth-damageTaken);

      return;
    }

    public String toString() {
        String retString;
        retString = "This TakeDamage deals " + damageTaken + " damage and affects tiles: \n";

        for(Tile tile : affectedTiles){
            retString += tile + "\n";
        }

        return retString;
    }
}
