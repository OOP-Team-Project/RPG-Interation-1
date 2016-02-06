package com.oop1.view;

import javax.swing.*;
import java.awt.*;

public class StringStatusView extends JPanel {

    private JLabel label = new JLabel();

    public StringStatusView(String text, int width) {
        label.setText(text);
        label.setHorizontalAlignment(JLabel.LEFT);
        setBackground(new Color(0,0,0,0));
        setMaximumSize(new Dimension(width, getFont().getSize()*2));
        setForeground(StatusView.STATUS_VIEW_TEXT_COLOR);

        setLayout(new BorderLayout());
        add(label);
    }

    public void setText(String text) {
        label.setText(text);
    }

    public void setForeground(Color color) {
        super.setForeground(color);
        if (label != null) {
            label.setForeground(color);
        }
    }

}
