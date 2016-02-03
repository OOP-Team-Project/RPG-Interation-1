package com.oop1.Entity;

// import com.oop1.Item.Item;

public class Inventory {
  private final int maxCol = 5;
  private final int maxRow = 2;
  private final int equipmentSlots = 3;
  private final int weaponSlot = 0;
  private final int armorSlot = 1;
  private final int hatSlot = 2;

  private Integer inventory[][];
  private Integer equipment[];

  //Constructor
  public Inventory() {
    instantiate();
  }

  private void instantiate() {
    inventory = new Integer[maxRow][maxCol];
    for (int i = 0; i < maxRow; i++) {
      for (int j = 0; j < maxCol; j++) {
        inventory[i][j] = null;
      }
    }
    equipment = new Integer[equipmentSlots];
    for (int i = 0; i < equipmentSlots; i++) {
      equipment[i] = null;
    }
  }

  public boolean addItem( Integer item ) {

  }

  public Integer[][] getInventory() {
    return inventory;
  }

  public Integer[] getEquipment() {
    return equipment;
  }

  public String toString() {
    String result = "Inventory: \n";
    for ( int i = 0; i < maxRow; i++ ) {
      for ( int j = 0; j < maxCol; j++ ) {
        if ( inventory[i][j] == null ) {
          result += "[], ";

        } else {
          result += ( inventory[i][j].toString() + ", " );
        }
      }
      result += '\n';
    }
    result += "\nEquipment: \n";
    for ( int i = 0; i < equipmentSlots; i++ ) {
      if ( equipment[i] == null ) {
        result += "[], ";
      } else {
        result += ( equipment.toString() + ", " );
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Inventory i = new Inventory();
    System.out.println( i.toString() );
  }
}
