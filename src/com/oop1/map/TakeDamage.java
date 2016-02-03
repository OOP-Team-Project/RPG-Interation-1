/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

package com.oop1.map;

public class TakeDamage extends AreaEffect {

    private int damageTaken;

    public TakeDamage() {
        this.damageTaken = 10;
    }

    //public TakeDamage(Tile[] tiles){
    public TakeDamage(int[] tiles) {
        this.affectedTiles = tiles;
        this.damageTaken = 10;
    }

    //public TakeDamage(Tile[] tiles, int damageAmount){
    public TakeDamage(int[] tiles, int damageAmount) {
        this.affectedTiles = tiles;
        this.damageTaken = damageAmount;
    }

    //public void affectEntity(Entity entity){
    public void affectEntity() {
      /*
      int currentHealth = entity.getCurrentLife();
      entity.setCurrentHealth(currentHealth-damageTaken);
      */

        return;
    }

    public String toString() {
        String retString;
        retString = "This TakeDamage deals " + damageTaken + " damage and affects tiles: \n";

        //for(Tile tile : affectedTiles){
        for (int tile : affectedTiles) {
            retString += tile + "\n";
        }

        return retString;
    }


    //Little bit of test code
    public static void main(String args[]) {
        AreaEffect x = new TakeDamage();

        int[] yTiles = new int[]{1, 2, 3};
        AreaEffect y = new TakeDamage(yTiles);
        System.out.println(y);
    }
}
