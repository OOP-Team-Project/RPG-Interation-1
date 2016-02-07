package com.oop1.view;

import com.oop1.RunGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveMenuView extends JPanel {

    private JButton saveGame;
    private JButton resumeGame;

    RunGame delegate;

    public SaveMenuView(RunGame delegate) {
        this.delegate = delegate;
        setLayout(new FlowLayout());
        createMenu();
    }

    private void createMenu() {

        setSize(800,600);

        setLayout(new FlowLayout());

        saveGame = new JButton("Save Game");
        saveGame.setActionCommand("Save Game");
        saveGame.addActionListener(new ButtonClickListener());

        resumeGame = new JButton("Resume Game");
        resumeGame.setActionCommand("Resume Game");
        resumeGame.addActionListener(new ButtonClickListener());

        add(saveGame);
        add(resumeGame);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if( command.equals( "Save Game" ))  {
//                try {
//                    delegate.saveGame();
//                } catch (IOException exception) {}
            }
            else if( command.equals( "Resume Game" ) )  {
//                try {
//                    delegate.resumeGame();
//                }catch(IOException exception){}
            }
        }
    }
}
