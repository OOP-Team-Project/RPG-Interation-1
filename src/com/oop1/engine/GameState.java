package com.oop1.engine;

import com.oop1.entity.Entity;
import com.oop1.map.Map;

import java.util.List;

public class GameState {

    private List<Map> maps;
    private List<Entity> entities;

    public GameState(){
        //does nothing
    }

    public GameState(List<Map> newMaps, List<Entity> newEntities){
            maps = newMaps;
            entities = newEntities;
    }

    public List<Map> getMaps() {
        return maps;
    }

    public void setMaps(List<Map> maps) {
        this.maps = maps;
    }

    public Entity getAvatar() { return entities.get(0); }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
}
