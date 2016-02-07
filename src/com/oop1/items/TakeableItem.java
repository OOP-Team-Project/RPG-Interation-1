package com.oop1.items;

import com.oop1.entity.Entity;
import com.oop1.map.Tile;
import com.oop1.view.InventoryView;

import javax.swing.*;
import java.util.ArrayList;

public class TakeableItem extends Item {

    private ArrayList<StatModifier> statModifiers = new ArrayList<StatModifier>();
    private boolean equippable = false;
    private Tile loc;
    private String name;

    public TakeableItem() {

    }

    public TakeableItem(Tile tile) {
        loc = tile;
    }

    public void addStatModifier(StatModifier sm){
        statModifiers.add(sm);
    }

    @Override
    public void interact(Entity entity) {
        entity.addToInventory(this);
        loc.removeItem();
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

    public String getName() {
        if (name == null) { return "Unnamed Item"; }
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }
}
