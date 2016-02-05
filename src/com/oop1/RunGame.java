package com.oop1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.oop1.engine.*;
import com.oop1.view.*;


public class RunGame implements Runnable {

    //static Thread runner;
    static Engine engine;

    private JFrame mainFrame;

    public RunGame(){   //Constructor for this class.
        //prepareGUI();
    }

    private void prepareGUI(){
        //mainFrame = new JFrame("Team TigerTiger Cat's Awesome RPG Game!");
        //mainFrame.setSize(windowSizeX,windowSizeY);

        /*
        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);

        statusLabel.setSize(350,100);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        */

        mainFrame.setVisible(true);
    }
    /*
    private void showEventDemo(){
        headerLabel.setText("Control in action: Button");

        JButton okButton = new JButton("OK");
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        okButton.setActionCommand("OK");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);

        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if( command.equals( "OK" ))  {
                statusLabel.setText("Ok Button clicked.");
            }
            else if( command.equals( "Submit" ) )  {
                statusLabel.setText("Submit Button clicked.");
            }
            else  {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
    */

    public static void main(String[] args) {
        //Initially, we have a blank gameState (one that will likely be overridden by a load or new game operation.
        GameState initialGameState = new GameState();

        //Initially, we have only one view when the game boots up: a main menu view. The player can select a bunch of
        //  choices from here that will (probably) add in new views to be displayed.
        ArrayList<JPanel> initialList = new ArrayList<JPanel>();
        MainMenuView initialMenu = new MainMenuView();
        initialList.add(initialMenu);

        engine = new Engine(initialGameState, initialList);   //Assign gameState and views to this engine.

        Thread runner = new Thread(new RunGame(), "Main Thread");

        runner.start();

        try{
            runner.join();
        } catch(Exception e){

        }

    }

    public void run() {
        //Display info about this particular thread
        while(true) {
            try {
                Thread.sleep(15);   //We draw at run at approximately 66 Frames Per Second
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            engine.update();    //We let the engine do its thing.
        }
    }
}
