package com.oop1.items;

import com.oop1.entity.Entity;
import com.oop1.map.Tile;

public class OneShotItem extends Item {
    Tile onTile;

    public OneShotItem(Tile onTile) {
        this.onTile = onTile;
    }
    @Override
    public void interact(Entity entity) {
        // TODO: implement this
        //activates and does something

        //delete item from tile
        onTile.removeItem();

    }

    public String toString(){
        return "oneShot";
    }

}
