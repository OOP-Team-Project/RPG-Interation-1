package com.oop1.view;

import com.oop1.map.Decal;

import javax.swing.*;
import java.awt.*;

import java.awt.Color;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class DecalView extends JPanel {
    private Decal decal;

    //private BufferedImage duck;  // duck is for testing functionality
    //private BufferedImage skull;

    public DecalView(Decal newDecal) {

        //duck = Decal.DUCK[0][0];
        //skull = Decal.SKULL_AND_CROSSBONES[0][0];
        decal = newDecal;
    }

    public void draw(Graphics graphics) {
        // TODO: implement this

        //graphics.drawImage(duck, 50, 50, null);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //duck = Decal.DUCK[0][0];
        //ImageIcon imageIcon = new ImageIcon(image);
        BufferedImage image = null;
        try
        {
            //image = ImageIO.read(new File("src/com/oop1/resources/SKULL_AND_CROSSBONES.png"));
            image = decal.getImage()[0][0];
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        //ImageIcon imageIcon = new ImageIcon(decal.getImage()[0][0]);
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon);
        add(jLabel);
        //jLabel.setIcon(imageIcon);
        //jLabel.setDisabledIcon(imageIcon);
        //g2.drawImage(decal.getImage()[0][0], 0, 0, null);

        //for(int i = 0; i < 50; i++){
        //	tiles[i].paintComponent(g);
        //}
    }


}
