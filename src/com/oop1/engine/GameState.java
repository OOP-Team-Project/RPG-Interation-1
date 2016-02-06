package com.oop1.engine;

import com.oop1.entity.Entity;
import com.oop1.map.Map;

import java.util.List;

public class GameState {

    private List<Map> map;
    private List<Entity> entities;
    private Entity avatar;

    public GameState(Entity avatar, List<Map> map, List<Entity> entities) {
        this.map = map;
        this.entities = entities;
        this.avatar = avatar;
    }

    public List<Map> getMap() {
        return map;
    }

    public void setMap(List<Map> map) {
        this.map = map;
    }

    public Entity getAvatar() { return avatar; }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
}
