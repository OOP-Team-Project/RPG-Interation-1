package com.oop1.items;

import com.oop1.entity.Entity;
import com.oop1.map.AreaEffect;

import java.util.Iterator;

// For demo purposes, will add a new item to inventory
public class InteractiveItem extends Item {
    @Override
    public void interact(Entity entity) {
        // TODO: implement
        System.out.println("You just used an interactive item!");

        TakeableItem item = new TakeableItem();
        item.setName("Interactive");
        entity.getInventory().addItem(item);
    }

    public String toString(){
        return "interactive";
    }
}
