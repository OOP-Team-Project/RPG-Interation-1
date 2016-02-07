package com.oop1.view;

import com.oop1.entity.Entity;
import com.oop1.entity.Stats;

import javax.swing.*;
import java.awt.*;

/**
 * Displays the current status of the player
 */
public class StatusView extends JPanel {

    public static final int HEALTH_MANA_BAR_WIDTH = 200;
    public static final int HEALTH_MANA_BAR_HEIGHT = 20;

    public static final int OUTER_PADDING = 10;
    public static final int INNER_PADDING = 10;

    public static final Color MANA_COLOR = Color.BLUE;
    public static final Color HEALTH_COLOR = Color.RED;

    public static final Color STATUS_VIEW_BACKGROUND_COLOR = new Color(44, 46, 48);
    public static final Color STATUS_VIEW_TEXT_COLOR = new Color(180, 180, 190);

    private Entity avatar;

    private NumericStatusView health;
    private NumericStatusView mana;
    private StringStatusView  occupation;
    private InventoryView inventory;
    private int inventorySize;
    private boolean viewingInventory = true;

    public StatusView(Entity avatar) {

        this.avatar = avatar;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(STATUS_VIEW_BACKGROUND_COLOR);
        setForeground(STATUS_VIEW_TEXT_COLOR);
        setMaximumSize(new Dimension(HEALTH_MANA_BAR_WIDTH + 2 * OUTER_PADDING, 10000));

        Stats s = avatar.getBaseStats();

        health = new NumericStatusView(s.getCurrentLife(), 0, s.getMaxLife());
        health.setActualSize(HEALTH_MANA_BAR_WIDTH, HEALTH_MANA_BAR_HEIGHT);
        health.setForeground(HEALTH_COLOR);

        mana = new NumericStatusView(s.getCurrentMana(), 0, s.getMaxMana());
        mana.setActualSize(HEALTH_MANA_BAR_WIDTH, HEALTH_MANA_BAR_HEIGHT);
        mana.setForeground(MANA_COLOR);

        inventory = new InventoryView(avatar.getInventory());
        inventorySize = avatar.getInventory().getAllItems().size();

        inventory.setBackground(STATUS_VIEW_BACKGROUND_COLOR.darker().darker());

        occupation = new StringStatusView("Occupation: " + avatar.getOccupation().toString(), HEALTH_MANA_BAR_WIDTH);

        add(Box.createVerticalStrut(OUTER_PADDING));
        add(occupation);
        add(Box.createVerticalStrut(INNER_PADDING));

        add(new StringStatusView("Health", HEALTH_MANA_BAR_WIDTH));
        add(health);
        add(Box.createVerticalStrut(INNER_PADDING));

        add(new StringStatusView("Mana", HEALTH_MANA_BAR_WIDTH));
        add(mana);
        add(Box.createVerticalStrut(INNER_PADDING));

        // the inventory will fill up the remaining space, so don't add glue after it
        add(new StringStatusView("Inventory/Stats", HEALTH_MANA_BAR_WIDTH));
        add(inventory);

        add(Box.createVerticalStrut(OUTER_PADDING));
    }

    private void repaintInventory(){
        remove(inventory);
        inventory = new InventoryView(avatar.getInventory());
        inventory.setBackground(STATUS_VIEW_BACKGROUND_COLOR.darker().darker());
        add(inventory);
        viewingInventory = true;
    }

    private void repaintStats(){
        remove(inventory);
        inventory = new InventoryView(avatar.getBaseStats());
        inventory.setBackground(STATUS_VIEW_BACKGROUND_COLOR.darker().darker());
        add(inventory);
        viewingInventory = false;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        health.setCurrentValue(avatar.getBaseStats().getCurrentLife());
        health.setMaxValue(avatar.getBaseStats().getMaxLife());

        mana.setCurrentValue(avatar.getBaseStats().getCurrentMana());
        mana.setMaxValue(avatar.getBaseStats().getMaxMana());

        if(avatar.getSwitchStatsView()){
            avatar.setSwitchStatsView(false);
            if(viewingInventory)
                repaintStats();
            else
                repaintInventory();
        }

        if(avatar.getInventory().getAllItems().size() != inventorySize) {
            if(viewingInventory)
                repaintInventory();
            else
                repaintStats();
            inventorySize = avatar.getInventory().getAllItems().size();
        }
    }
}
