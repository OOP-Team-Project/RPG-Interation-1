package com.oop1.entity;

import com.oop1.items.StatModifier;
import com.oop1.items.TakeableItem;

import java.util.*;

public class Inventory {

    private List<TakeableItem> items;
    private Set<TakeableItem> equipment;

    public Inventory() {
        /**
         * The items list is initialized to size 20
         */
        items = new ArrayList<TakeableItem>();
        equipment = new HashSet<TakeableItem>();
    }

    /**
     * Get all the items in this inventory
     *
     * @return an unmodifiable collection of the items in the inventory.
     * modifications to the inventory should be performed
     * via the other methods on this class.
     */
    public List<TakeableItem> getAllItems() {
        return Collections.unmodifiableList(items);
    }

    /**
     * Get all the equipped items
     *
     * @return an unmodifiable collection of the items in the inventory.
     * modifications to the inventory should be performed
     * via the other methods on this class.
     */

    public Collection<TakeableItem> getEquippedItems() {
        return Collections.unmodifiableCollection(equipment);
    }

    public void equipItem(TakeableItem item) {
        if (items.contains(item)) {
            if (item.isEquippable()) {
                equipment.add(item);
            }
        }
    }

    public void unequipItem(TakeableItem item) {
        if (equipment.contains(item)) {
            equipment.remove(item);
        }
    }

    public void dropItem(TakeableItem item) {
        if (items.contains(item)) {
            items.remove(item);
        }
    }

    public void moveItem(TakeableItem item, int toIndex) {
        if (items.contains(item)) {
            if (toIndex < 0) {
                items.remove(item);
                items.add(0, item);
            } else if (toIndex >= items.size()) {
                items.remove(item);
                items.add(items.size(), item);
            } else {
                items.remove(item);
                items.add(toIndex, item);
            }
        }
    }

    public void addItem(TakeableItem item){
        items.add(item);
    }

    public String printForSave(){
        StringBuilder str = new StringBuilder();
        for (TakeableItem item : items) {
            str.append(item.getName());
            str.append(";");

            if (item.isEquippable()) {
                str.append("E");
            }
            if (equipment.contains(item)) {
                str.append("E");
            }

            StatModifier modifier = item.getStatModifiers().get(0);
            str.append(modifier.getStrengthModifier());
            str.append(";");
            str.append(modifier.getAgilityModifier());
            str.append(";");
            str.append(modifier.getIntellectModifier());
            str.append(";");
            str.append(modifier.getHardinessModifier());
            str.append(";");
            str.append(modifier.getMovementModifier());
            str.append(";");
            str.append(modifier.getLivesLeftModifier());
            str.append("%\n");
        }
        return str.toString();
    }

//    public static void main(String[] args) {
//        Inventory inv = new Inventory();
//        System.out.println(inv.toString());
//        inv.addItem(new TakeableItem());
//        inv.addItem(new TakeableItem());
//        System.out.println(inv.toString());
//        TakeableItem item1 = new TakeableItem();
//        inv.addItem(item1);
//        System.out.println(inv.toString());
//        inv.equipItem(item1);
//        System.out.println(inv.toString());
//        inv.unequipItem(item1);
//        inv.moveItem(item1, 0);
//        System.out.println(inv.toString());
//        inv.dropItem(item1);
//        System.out.println(inv.toString());
//    }
}