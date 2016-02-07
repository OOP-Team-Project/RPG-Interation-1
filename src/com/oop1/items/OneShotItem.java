package com.oop1.items;

import com.oop1.entity.Entity;
import com.oop1.map.Decal;
import com.oop1.map.Tile;

public class OneShotItem extends Item {
    Tile onTile;

    // For demo purposes, leaves a red cross
    public OneShotItem(Tile onTile) {
        this.onTile = onTile;
    }
    @Override
    public void interact(Entity entity) {
        // TODO: implement this
        System.out.println("You just used a one-shot item!");
        onTile.setDecal(new Decal("RED_CROSS"));

        //delete item from tile
        onTile.removeItem();
    }

    public String toString(){
        return "oneShot";
    }

}
