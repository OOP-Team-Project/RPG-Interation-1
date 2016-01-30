/*
 * All the code that depends on Entity or Tile is commented out to test with ints.
 */

public class LevelUp extends AreaEffects{

   public LevelUp(){}

   //public LevelUp(Tile[] tiles){
   public LevelUp(int[] tiles){
      this.affectedTiles = tiles;
   }

   //public void affectEntity(Entity entity){
   public void affectEntity(){
      /*
      int currLevel = entity.getLevel();
      entity.setLevel(currLevel);
      entity.setExperience(0);
      */

      return;
   }

   public String toString(){
      String retString;
      retString = "This Level Up affects tiles: \n";

      //for(Tile tile : affectedTiles){
      for(int tile : affectedTiles){
         retString += tile + "\n";
      }

      return retString;
   }


   //Little bit of test code
   public static void main(String args[]){
      AreaEffects x = new LevelUp();

      int[] yTiles = new int[]{1, 2, 3};
      AreaEffects y = new LevelUp(yTiles);
      System.out.println(y);
   }
}
