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
        try {
            if (occupation.equals("SMASHER")) {
                image = ImageIO.read(new File("resources/SMASHER.png"));
            } else if (occupation.equals("SNEAK")) {
                image = ImageIO.read(new File("resources/SNEAK.png"));
            } else {
                image = ImageIO.read(new File("resources/SUMMONER.png"));
            }
        }catch(IOException e){System.out.println("Couldn't load entity image");}
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel();
        jLabel.setMaximumSize(new Dimension(60,60));
        jLabel.setPreferredSize(new Dimension(60,60));
        add(jLabel);
        add(Box.createVerticalGlue());
        jLabel.setIcon(imageIcon);
        //setBackground(Color.green);
    }
}

