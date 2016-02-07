package com.oop1.view;

import com.oop1.engine.Controller;

import com.oop1.RunGame;
import com.oop1.engine.Engine;
import com.oop1.engine.GameState;
import com.oop1.entity.*;
import com.oop1.io.SaveManager;
import com.oop1.map.Decal;
import com.oop1.map.Map;
import com.oop1.map.TerrainType;
import com.oop1.map.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class CharacterCreationView extends JPanel {

    private JLabel headerLabel;
    private JLabel statusLabel;
    private JButton okButton;    //moved here to look similar to MainMenuView
    private JButton submitButton;
    private JButton cancelButton;

    RunGame delegate;

    public CharacterCreationView(RunGame delegate){
        this.delegate = delegate;
        initializeMenu();
    }

    private void initializeMenu(){
//        JButton okButton;
//        JButton submitButton;
//        JButton cancelButton;

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);

//        statusLabel.setSize(800,600);

        headerLabel.setText("Select a class for your new character!");

        this.setLayout(new FlowLayout());

        okButton = new JButton("Smasher!");
        submitButton = new JButton("Summoner!");
        cancelButton = new JButton("Sneak!");

        okButton.setActionCommand("Smasher!");
        submitButton.setActionCommand("Summoner!");
        cancelButton.setActionCommand("Sneak!");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        this.add(this.headerLabel);

        this.add(okButton);
        this.add(submitButton);
        this.add(cancelButton);

        this.add(this.statusLabel);
    }

    private class ButtonClickListener implements ActionListener {

        private ButtonClickListener(){}

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            Occupation o;

            if (command.equals("Smasher!")) {
                o = new Smasher();
            } else if (command.equals("Summoner!")) {
                o = new Summoner();
            } else {
                o = new Sneak();
            }

            try {
                delegate.startNewGame(o);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
