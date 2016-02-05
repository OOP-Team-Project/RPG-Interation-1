package com.oop1.items;

import com.oop1.entity.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TakeableItem extends Item {

    private List<StatModifier> statModifiers = new ArrayList<StatModifier>();

    public void addStatModifier(StatModifier sm){
        statModifiers.add(sm);
    }

    @Override
    public void interact(Entity entity) {
        // TODO: implement this
    }

}
