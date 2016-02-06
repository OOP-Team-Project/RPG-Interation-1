package com.oop1.view;

import com.oop1.RunGame;
import com.oop1.engine.Engine;
import com.oop1.engine.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenuView extends JPanel {

    private JLabel headerLabel;
    private JLabel statusLabel;

    private JButton newGameButton;
    private JButton loadButton;
    private JButton quitButton;

    RunGame delegate;

    public MainMenuView(RunGame delegate) {
        this.delegate = delegate;
        setLayout(new FlowLayout());
        createMenu();
    }

    private void createMenu() {
        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);

        statusLabel.setSize(800,600);

        setLayout(new FlowLayout());

        newGameButton = new JButton("New Game");
        newGameButton.setActionCommand("New Game");
        newGameButton.addActionListener(new ButtonClickListener());

        loadButton = new JButton("Load Game");
        loadButton.setActionCommand("Load Game");
        loadButton.addActionListener(new ButtonClickListener());

        quitButton = new JButton("Quit");
        quitButton.setActionCommand("Quit");
        quitButton.addActionListener(new ButtonClickListener());

        add(newGameButton);
        add(loadButton);
        add(quitButton);
        add(statusLabel);
        add(headerLabel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if( command.equals( "New Game" ))  {
                delegate.createNewGame();
            }
            else if( command.equals( "Load Game" ) )  {
                statusLabel.setText("Load Game Button clicked.");
                try {
                    delegate.loadGame();
                }catch(IOException exception){}
            }
            else  {
                System.exit(0);
            }
        }
    }
}
