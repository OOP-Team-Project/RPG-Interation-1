package com.oop1.view;

import com.oop1.items.Item;
import com.oop1.resources.Resources;

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
    //private Image image = null;

    public ItemView (Item item) {

        this.item = item;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        Image image = null;
        try {
            if (item.toString().equals("oneShot"))
                image = ImageIO.read(new File("resources/ONE_SHOT.png"));
            else if (item.toString().equals("obstacle"))
                image = ImageIO.read(new File("resources/OBSTACLE.png"));
            else if (item.toString().equals("interactive"))
                image = ImageIO.read(new File("resources/INTERACTIVE.png"));
            else if (item.toString().equals("takeableItem"))
                image = ImageIO.read(new File("resources/TAKEABLE.png"));
        }catch(IOException e){System.out.println("Can't load item picture");}
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
