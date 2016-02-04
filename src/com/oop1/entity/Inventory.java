package com.oop1.entity;

import com.oop1.items.Item;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Inventory {

    private List<Item> items;

    /**
     * Get all the items in this inventory
     *
     * @return an unmodifiable collection of the items in the inventory.
     * modifications to the inventory should be performed
     * via the other methods on this class.
     */
    public Collection<Item> getAllItems() {
        return Collections.unmodifiableCollection(items);
    }

    public Collection<Item> getEquippedItems() {
        // TODO: implement this
        return Collections.emptyList();
    }

    public void equipItem(Item item) {
        // TODO: implement this

    }

    public void unequipItem(Item item) {
        // TODO: implement this
    }

    public void dropItem(Item item) {
        // TODO: implement this
    }

    public void moveItem(Item item, int toIndex) {
        // TODO: implement this
    }

    public void addItem(Item item) {
        // TODO: implement this
    }
}

// public class Inventory {
//   private final int maxCol = 5;
//   private final int maxRow = 2;
//   private final int equipmentSlots = 3;
//   private final int weaponSlot = 0;
//   private final int armorSlot = 1;
//   private final int hatSlot = 2;
//
//   private Integer inventory[][];
//   private Integer equipment[];
//
//   //Constructor
//   public Inventory() {
//     instantiate();
//   }
//
//   private void instantiate() {
//     inventory = new Integer[maxRow][maxCol];
//     for (int i = 0; i < maxRow; i++) {
//       for (int j = 0; j < maxCol; j++) {
//         inventory[i][j] = null;
//       }
//     }
//     equipment = new Integer[equipmentSlots];
//     for (int i = 0; i < equipmentSlots; i++) {
//       equipment[i] = null;
//     }
//   }
//
//   public boolean addItem( Integer item ) {
//
//   }
//
//   public Integer[][] getInventory() {
//     return inventory;
//   }
//
//   public Integer[] getEquipment() {
//     return equipment;
//   }
//
//   public String toString() {
//     String result = "Inventory: \n";
//     for ( int i = 0; i < maxRow; i++ ) {
//       for ( int j = 0; j < maxCol; j++ ) {
//         if ( inventory[i][j] == null ) {
//           result += "[], ";
//
//         } else {
//           result += ( inventory[i][j].toString() + ", " );
//         }
//       }
//       result += '\n';
//     }
//     result += "\nEquipment: \n";
//     for ( int i = 0; i < equipmentSlots; i++ ) {
//       if ( equipment[i] == null ) {
//         result += "[], ";
//       } else {
//         result += ( equipment.toString() + ", " );
//       }
//     }
//     return result;
//   }
//
//   public static void main(String[] args) {
//     Inventory i = new Inventory();
//     System.out.println( i.toString() );
//   }
// }
