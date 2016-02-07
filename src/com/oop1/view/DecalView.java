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
        decal = newDecal;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        BufferedImage image = null;
        image = decal.getImage()[0][0];
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
