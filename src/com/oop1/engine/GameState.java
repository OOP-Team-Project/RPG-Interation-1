package com.oop1.engine;

import com.oop1.entity.Entity;
import com.oop1.map.Map;

import java.util.List;

public class GameState {

    private List<Map> map;
    private List<Entity> entities;

    public List<Map> getMap() {
        return map;
    }

    public void setMap(List<Map> map) {
        this.map = map;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
}
