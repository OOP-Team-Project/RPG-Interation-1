package com.oop1.view;

import com.oop1.entity.Entity;

import java.awt.*;

/**
 * Displays the current status of the player
 */
public class StatusView extends View {

    private Entity avatar;

    public StatusView(Entity avatar) {
        this.avatar = avatar;
    }

    @Override
    public void draw(Graphics g) {
        // TODO: implement
    }
}
