package com.oop1.view;

import com.oop1.entity.Inventory;
import com.oop1.entity.Stats;
import com.oop1.items.TakeableItem;

import javax.swing.*;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.metal.MetalScrollBarUI;
import javax.swing.plaf.synth.SynthScrollBarUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InventoryView extends JPanel {

    private Inventory inventory;

    public InventoryView(Inventory inventory) {
        this.inventory = inventory;

        final JList list = new JList();
        if(inventory != null) {
            setLayout(new BorderLayout());

            list.setListData(inventory.getAllItems().toArray());
            list.setCellRenderer(new CellRenderer());
            list.setBackground(new Color(0, 0, 0, 0));

            JScrollPane scrollPane= new JScrollPane(list);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setBackground(new Color(0,0,0,0));

            scrollPane.getVerticalScrollBar().setUI(new CustomUI.funScrollBarUI());
            add(scrollPane);
            scrollPane.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0), 3));

        list.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3){
                    int index = list.locationToIndex(e.getPoint());
                    Inventory inventory = InventoryView.this.inventory;
                    if(index >= 0) {
                        TakeableItem item = inventory.getAllItems().get(index);
                        if (inventory.getEquippedItems().contains(item)) {
                            inventory.unequipItem(item);
                        }
                        inventory.dropItem(item);
                        list.setListData(inventory.getAllItems().toArray());
                    }
                }
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    if(index >= 0) {
                        Inventory inventory = InventoryView.this.inventory;
                        TakeableItem item = inventory.getAllItems().get(index);
                        if (inventory.getEquippedItems().contains(item)) {
                            inventory.unequipItem(item);
                        } else {
                            inventory.equipItem(item);
                        }
                        list.setListData(inventory.getAllItems().toArray());
                    }
                }
            }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        }
    }

    private class CellRenderer implements ListCellRenderer<TakeableItem> {
        @Override
        public Component getListCellRendererComponent(JList<? extends TakeableItem> list, TakeableItem value, int index, boolean isSelected, boolean cellHasFocus) {
            JPanel panel = new JPanel();
            panel.setBackground(new Color(0,0,0,0));
            JLabel label = new JLabel();
            panel.add(label);
            label.setText(value.getName());
            label.setBackground(new Color(0,0,0,0));
            label.setForeground(StatusView.STATUS_VIEW_TEXT_COLOR.darker());
            if (value.isEquippable()) {
                label.setFont(new Font("default", Font.BOLD, 12));
            } else {
                label.setFont(new Font("default", Font.PLAIN, 12));
            }
            if (inventory.getEquippedItems().contains(value)) {
                label.setForeground(Color.WHITE);
            }
            return panel;
        }
    }

    private void makeStatLabels(String str){
        JLabel label = new JLabel();
        label.setText(str);
        label.setBackground(new Color(0,0,0,0));
        label.setForeground(StatusView.STATUS_VIEW_TEXT_COLOR.darker());
        label.setFont(new Font("default", Font.BOLD, 12));
        label.setForeground(Color.WHITE);
        add(label);
        setBackground(new Color(0,0,0,0));
    }


    public InventoryView(Stats stats, Stats baseStats) {
        setLayout(new GridLayout(0,1));
        makeStatLabels("  Level: " + baseStats.getCurrentLevel());
        makeStatLabels("  Experience: " + stats.getExperience());
        makeStatLabels("  Lives: " + stats.getLivesLeft());
        makeStatLabels("  Offense: " + stats.getOffensiveRating());
        makeStatLabels("  Defense: " + stats.getDefensiveRating());
        makeStatLabels("  Armor: " + stats.getArmorRating());
        makeStatLabels("  Strength: " + stats.getStrength());
        makeStatLabels("  Agility: " + stats.getAgility());
        makeStatLabels("  Intellect: " + stats.getIntellect());
        makeStatLabels("  Hardiness: " + stats.getHardiness());
        makeStatLabels("  Movement: " + stats.getMovementSpeed());
        add(Box.createHorizontalGlue());

    }
}
