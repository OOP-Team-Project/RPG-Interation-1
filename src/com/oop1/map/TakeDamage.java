/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

package com.oop1.map;

import com.oop1.entity.Entity;

import java.util.Set;

public class TakeDamage extends AreaEffect {

    private int damageTaken;

    public TakeDamage() {
        this.damageTaken = 10;
    }

    public TakeDamage(Set<Tile> tiles){
        this.affectedTiles = tiles;
        this.damageTaken = 10;
    }

    public TakeDamage(Set<Tile> tiles, int damageAmount){
        this.affectedTiles = tiles;
        this.damageTaken = damageAmount;
    }

    public void affectEntity(Entity entity){
        entity.getBaseStats().takeDamage(damageTaken);
    }

    public String getEffectName(){
        return "takeDamage";
    }

    public int getDamageAmount(){
        return damageTaken;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("This TakeDamage deals ");
        str.append(damageTaken);
        str.append(" damage and affects tiles: ");
        str.append(affectedTiles);

        return str.toString();
    }

}
