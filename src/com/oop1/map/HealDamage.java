/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

package com.oop1.map;


public class HealDamage extends AreaEffect {

    private int damageHealed;

    public HealDamage() {
        this.damageHealed = 10;
    }

    public HealDamage(Set<Tile> tiles){
        this.affectedTiles = tiles;
        this.damageHealed = 10;
    }

    public HealDamage(Set<Tile> tiles, int damageAmount){
        this.affectedTiles = tiles;
        this.damageHealed = damageAmount;
    }

    public void affectEntity(Entity entity){
      int currentHealth = entity.getCurrentLife();
      entity.setCurrentHealth(currentHealth-damageHealed);
      return;
    }

    public String toString() {
        String retString;
        retString = "This HealDamage heals " + damageHealed + " damage and affects tiles: \n";

        for(Tile tile : affectedTiles){
            retString += tile + "\n";
        }

        return retString;
    }
}
