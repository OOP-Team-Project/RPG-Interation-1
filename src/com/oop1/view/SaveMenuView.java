package com.oop1.view;

import com.oop1.RunGame;
import com.oop1.io.SaveManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveMenuView extends JPanel {

    //options to save and resume the game
    private JButton saveGame;
    private JButton resumeGame;
    private JButton exitGame;

    //run game instance
    RunGame delegate;

    //constructor
    public SaveMenuView(RunGame delegate) {
        this.delegate = delegate;
        setLayout(new FlowLayout());
        createMenu();
    }

    //draw menu to the screen
    private void createMenu() {

        setSize(800,600);

        setLayout(new FlowLayout());

        saveGame = new JButton("Save Game");
        saveGame.setActionCommand("Save Game");
        saveGame.addActionListener(new ButtonClickListener());

        resumeGame = new JButton("Resume Game");
        resumeGame.setActionCommand("Resume Game");
        resumeGame.addActionListener(new ButtonClickListener());

        exitGame = new JButton("Exit Game");
        exitGame.setActionCommand("Exit Game");
        exitGame.addActionListener(new ButtonClickListener());

        add(resumeGame);
        add(saveGame);
        add(exitGame);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    //handles button clicks
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if( command.equals( "Save Game" ))  { //clicked save game
                try {
                    delegate.saveGame();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            else if( command.equals( "Resume Game" ) )  { //clicked load game
                try {
                    delegate.loadGame();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            else if (command.equals( "Exit Game" )) { //clicked exit game
                System.exit(0);
            }
        }
    }
}
