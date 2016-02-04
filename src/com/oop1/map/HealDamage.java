/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

package com.oop1.map;


public class HealDamage extends AreaEffect {

    private int damageHealed;

    public HealDamage() {
        this.damageHealed = 10;
    }

    //public HealDamage(Tile[] tiles){
    public HealDamage(int[] tiles) {
        this.affectedTiles = tiles;
        this.damageHealed = 10;
    }

    //public HealDamage(Tile[] tiles, int damageAmount){
    public HealDamage(int[] tiles, int damageAmount) {
        this.affectedTiles = tiles;
        this.damageHealed = damageAmount;
    }

    //public void affectEntity(Entity entity){
    public void affectEntity() {
      /*
      int currentHealth = entity.getCurrentLife();
      entity.setCurrentHealth(currentHealth-damageHealed);
      */

        return;
    }

    public String toString() {
        String retString;
        retString = "This HealDamage heals " + damageHealed + " damage and affects tiles: \n";

        //for(Tile tile : affectedTiles){
        for (int tile : affectedTiles) {
            retString += tile + "\n";
        }

        return retString;
    }


    //Little bit of test code
    public static void main(String args[]) {
        AreaEffect x = new HealDamage();

        int[] yTiles = new int[]{1, 2, 3};
        AreaEffect y = new HealDamage(yTiles);
        System.out.println(y);
    }
}
