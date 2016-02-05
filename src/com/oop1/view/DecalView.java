package com.oop1.view;

import com.oop1.map.Decal;

import javax.swing.*;
import java.awt.*;

import java.awt.Color;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class DecalView extends JPanel {
    private Decal decal;

    private BufferedImage duck;  // duck is for testing functionality
    private BufferedImage skull;

    public DecalView() {

        duck = Decal.DUCK[0][0];
        skull = Decal.SKULL_AND_CROSSBONES[0][0];

    }

    public void draw(Graphics graphics) {
        // TODO: implement this

        graphics.drawImage(skull, 50, 50, null);

    }




}
