package com.oop1.items;

import com.oop1.entity.Entity;

public class Obstacle extends Item {
    @Override
    public void interact(Entity entity) {
        // Do nothing; the entity just can't pass
    }

    public String toString(){
        return "obstacle";
    }
}
