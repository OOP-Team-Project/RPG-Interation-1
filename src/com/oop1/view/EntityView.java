package com.oop1.view;

import com.oop1.entity.*;

import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.awt.Graphics;
import java.io.*;

public class EntityView extends JPanel {

    private Entity entity;
    private BufferedImage characterImage;



    public EntityView(Entity entity) {
        this.entity = entity;
        Occupation occupation = new Smasher();
        try {
            // if(entity.getOccupation() == occupation) {
            characterImage = ImageIO.read(new File("SMASHER.png"));
            //  }
            occupation = new Sneak();
            if(entity.getOccupation() == occupation) {
                characterImage = ImageIO.read(new File("/src/com/oop1/resources/SNEAK.png"));
            }
            occupation = new Summoner();
            if(entity.getOccupation() == occupation) {
                characterImage = ImageIO.read(new File("/src/com/oop1/resources/SUMMONER.png"));
            }
        } catch (IOException ex) {
            // handle exception...
            System.out.println("Couldn't load entity image");
        }
        ImageIcon imageIcon = new ImageIcon(characterImage);
        JLabel label = new JLabel();
        add(label);
        label.setIcon(imageIcon);
    }



}

