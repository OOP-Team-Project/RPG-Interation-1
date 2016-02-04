package com.oop1.view;

import com.oop1.entity.Entity;

import javax.swing.*;

/**
 * Displays the current status of the player
 */
public class StatusView extends JPanel {

    private Entity avatar;

    public StatusView(Entity avatar) {
        this.avatar = avatar;
    }
}
