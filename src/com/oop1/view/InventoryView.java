package com.oop1.view;

import com.oop1.entity.Inventory;
import com.oop1.items.TakeableItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InventoryView extends JPanel {

    private Inventory inventory;

    public InventoryView(Inventory inventory) {
        this.inventory = inventory;

        JList list = new JList();
        list.setListData(inventory.getAllItems().toArray());
        list.setCellRenderer(new CellRenderer());
        list.setBackground(new Color(0,0,0,0));
        add(list);

        list.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    TakeableItem item = inventory.getAllItems().get(index);
                    if (inventory.getEquippedItems().contains(item)) {
                        inventory.unequipItem(item);
                    } else {
                        inventory.equipItem(item);
                    }
                    list.setListData(inventory.getAllItems().toArray());
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
}
