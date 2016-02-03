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
