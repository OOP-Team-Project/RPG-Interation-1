package com.oop1.view;

import com.oop1.entity.Entity;
import com.oop1.map.Map;

import java.awt.*;

public class AreaView extends View {

    /**
     * the map this area view will show
     */
    private Map map;

    /**
     * the entity on which to center the area view.
     */
    private Entity entityToTrack;


    public AreaView(Map map, Entity entityToTrack) {
        this.map = map;
        this.entityToTrack = entityToTrack;
    }

    public void draw(Graphics g) {
        // TODO: implement this
    }

}
