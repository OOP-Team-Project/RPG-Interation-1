package com.oop1.engine;

import com.oop1.entity.Entity;
import com.oop1.entity.Occupation;
import com.oop1.map.Map;
import com.oop1.map.Tile;

import java.util.ArrayList;

public class Engine {
    private GameState state;

    public GameState getGameState() { return state; }

    public void update() {
        // TODO: implement this

    }

    public void beginGame(Occupation avatarOccupation) {
        // TODO: implement this
        state = new GameState(
                new Entity(avatarOccupation, new Tile()),
                new ArrayList<Map>(),
                new ArrayList<Entity>()
        );
    }

    public void endGame() {
        // TODO: implement this
    }
}
