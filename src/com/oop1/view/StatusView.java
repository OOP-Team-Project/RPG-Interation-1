package com.oop1.view;

import com.oop1.entity.Entity;
import com.oop1.entity.Stats;

import javax.swing.*;
import java.awt.*;

/**
 * Displays the current status of the player
 */
public class StatusView extends JPanel {

    private Entity avatar;

    private NumericStatusView health;
    private NumericStatusView mana;
    private StringStatusView  occupation;

    public StatusView(Entity avatar) {
        this.avatar = avatar;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Stats s = avatar.getBaseStats();
        this.health = new NumericStatusView(s.getCurrentLife(), 0, s.getMaxLife());
        this.mana   = new NumericStatusView(s.getCurrentMana(), 0, s.getMaxMana());
        this.occupation = new StringStatusView(avatar.getOccupation().toString());

        Dimension barSize = new Dimension(200, 50);

        health.setMaximumSize(barSize);
        mana.setMaximumSize(barSize);
        health.setMinimumSize(barSize);
        mana.setMinimumSize(barSize);
        health.setPreferredSize(barSize);
        mana.setPreferredSize(barSize);

        mana.setForeground(Color.BLUE);

        add(Box.createVerticalGlue());
        add(occupation);
        add(Box.createVerticalStrut(10));
        add(health);
        add(Box.createVerticalStrut(10));
        add(mana);
        add(Box.createVerticalGlue());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        health.setCurrentValue(avatar.getBaseStats().getCurrentLife());
        health.setMaxValue(10+avatar.getBaseStats().getMaxLife());

        mana.setCurrentValue(avatar.getBaseStats().getCurrentMana());
        mana.setMaxValue(10 + avatar.getBaseStats().getMaxMana());
    }
}
