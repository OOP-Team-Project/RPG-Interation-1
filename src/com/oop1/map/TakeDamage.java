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
        StringBuilder str = new StringBuilder();
        str.append("This TakeDamage deals ");
        str.append(damageTaken);
        str.append(" damage and affects tiles: ");
        str.append(affectedTiles);

        return str;
    }
}
