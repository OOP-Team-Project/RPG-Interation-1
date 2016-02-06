package com.oop1.view;

import com.oop1.items.Item;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by MyMac on 2/5/16.
 */
public class ItemView extends JPanel{

    private Item item;

    public ItemView (Item item) {
        this.item = item;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        Image image = null;
        if(item.toString().equals("oneShot"))
            image = new ImageIcon("src/com/oop1/resources/ONE_SHOT.png").getImage();
        else if(item.toString().equals("obstacle"))
            image = new ImageIcon("src/com/oop1/resources/OBSTACLE.png").getImage();
        else if(item.toString().equals("interactive"))
            image = new ImageIcon("src/com/oop1/resources/INTERACTIVE.png").getImage();
        else if(item.toString().equals("takeableItem"))
            image = new ImageIcon("src/com/oop1/resources/TAKEABLE.png").getImage();
        //image = new ImageIcon("src/com/oop1/resources/GRASS.png").getImage();
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
