package com.oop1.view;

import com.oop1.entity.*;
import com.oop1.map.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class EntityView extends JPanel {

    public EntityView(String occupation){
        Image image = null;
        if (occupation.equals("SMASHER")) {
            image = new ImageIcon("src/com/oop1/resources/SMASHER.png").getImage();
        }
        else if (occupation.equals("SNEAK")) {
            image = new ImageIcon("src/com/oop1/resources/SNEAK.png").getImage();
        }
        else {
            image = new ImageIcon("src/com/oop1/resources/SUMMONER.png").getImage();
        }
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel();
        jLabel.setMaximumSize(new Dimension(60,60));
        jLabel.setPreferredSize(new Dimension(60,60));
        add(jLabel);
        add(Box.createVerticalGlue());
        jLabel.setIcon(imageIcon);
        setBackground(Color.green);
    }
}

