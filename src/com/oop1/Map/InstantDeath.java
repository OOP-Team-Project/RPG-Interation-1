/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

public class InstantDeath extends AreaEffects{

   public InstantDeath(){}

   //public InstantDeath(Tile[] tiles){
   public InstantDeath(int[] tiles){
      this.affectedTiles = tiles;
   }

   //public void affectEntity(Entity entity){
   public void affectEntity(){
      /*
      entity.setCurrentLife(0);
      */

      return;
   }

   public String toString(){
      String retString;
      retString = "This Instant Death affects tiles: \n";

      //for(Tile tile : affectedTiles){
      for(int tile : affectedTiles){
         retString += tile + "\n";
      }

      return retString;
   }


   //Little bit of test code
   public static void main(String args[]){
      AreaEffects x = new InstantDeath();

      int[] yTiles = new int[]{1, 2, 3};
      AreaEffects y = new InstantDeath(yTiles);
      System.out.println(y);
   }
}
