package com.oop1.items;

import com.oop1.entity.Entity;
import com.oop1.map.Tile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TakeableItem extends Item {

    private ArrayList<StatModifier> statModifiers = new ArrayList<StatModifier>();
    private boolean equippable = false;
    private Tile loc;

    public TakeableItem(){}

    public TakeableItem(Tile tile) {
        loc = tile;
    }

    public void addStatModifier(StatModifier sm){
        statModifiers.add(sm);
    }

    @Override
    public void interact(Entity entity) {
        // TODO: implement this
        //must still remove item from the tile
        loc.removeItem();
        entity.addToInventory(this);
    }

    public void setEquippable(boolean b) {
        equippable = b;
    }

    public boolean isEquippable() {
        return equippable;
    }

    public ArrayList<StatModifier> getStatModifiers() {
        return statModifiers;
    }

    public String toString(){
        return "takeableItem";
    }
}
