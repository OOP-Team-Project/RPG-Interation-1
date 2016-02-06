package com.oop1.view;

import build.tools.javazic.Main;
import com.oop1.engine.Engine;
import com.oop1.engine.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuView extends JPanel {

    private JLabel headerLabel;
    private JLabel statusLabel;

    private JButton okButton;
    private JButton submitButton;
    private JButton cancelButton;

    private boolean testVariable = false;
    private boolean shouldHide = false;

    private GameState game;

    public MainMenuView(){}

    public MainMenuView(GameState game){
        this.game = game;
    }

    private void MainMenuView(){

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);

        statusLabel.setSize(350,100);

        this.setLayout(new FlowLayout());

        //showEventDemo();
    }

    private void showEventDemo(){
        if(testVariable == false){

            headerLabel = new JLabel("",JLabel.CENTER );
            statusLabel = new JLabel("",JLabel.CENTER);

            statusLabel.setSize(350,100);

            //headerLabel.setText("Control in action: Button");

            this.setLayout(new FlowLayout());

            okButton = new JButton("New Game");
            submitButton = new JButton("Load Game");
            cancelButton = new JButton("Quit");

            okButton.setActionCommand("New Game");
            submitButton.setActionCommand("Load Game");
            cancelButton.setActionCommand("Quit");

            okButton.addActionListener(new ButtonClickListener());
            submitButton.addActionListener(new ButtonClickListener());
            cancelButton.addActionListener(new ButtonClickListener());

            this.add(okButton);
            this.add(submitButton);
            this.add(cancelButton);

            this.add(this.statusLabel);
            this.add(this.headerLabel);

            testVariable = true;
        }


        //this.add(headerLabel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        if(shouldHide == true){
            this.remove(headerLabel);
            this.remove(okButton);
            this.remove(submitButton);
            this.remove(cancelButton);
            this.remove(statusLabel);
        } else{
            showEventDemo();
        }

    }

    private void removeFromEngine(){
        Engine.removeView(this);    //Pops this view from the thing
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if( command.equals( "New Game" ))  {
                //statusLabel.setText("New Game Button clicked.");
                removeFromEngine();
                Engine.addView(new CharacterCreationView(game));
                shouldHide = true;
            }
            else if( command.equals( "Load Game" ) )  {
                statusLabel.setText("Load Game Button clicked.");
            }
            else  {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }


}
