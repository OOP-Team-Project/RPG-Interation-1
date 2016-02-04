/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

package com.oop1.map;

import com.oop1.entity.Entity;

import java.util.Set;

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
      int currentHealth = entity.getBaseStats().getCurrentLife();
      entity.getBaseStats().healDamage(damageHealed);
      return;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("This HealDamage heals ");
        str.append(damageHealed);
        str.append(" damage and affects tiles: ");
        str.append(affectedTiles);

        return str.toString();
    }

}
