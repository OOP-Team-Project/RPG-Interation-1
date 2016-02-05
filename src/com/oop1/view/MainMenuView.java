package com.oop1.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuView extends JPanel {

    private JLabel headerLabel;
    private JLabel statusLabel;

    private boolean testVariable = false;

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

            headerLabel.setText("Control in action: Button");

            this.setLayout(new FlowLayout());

            JButton okButton = new JButton("OK");
            JButton submitButton = new JButton("Submit");
            JButton cancelButton = new JButton("Cancel");

            okButton.setActionCommand("OK");
            submitButton.setActionCommand("Submit");
            cancelButton.setActionCommand("Cancel");

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

        showEventDemo();

        //if dead, this will give you three seconds to get ready for your next life
        // paint ball, paddle, and brick configuration
        /*ball.paint(g2);
        paddle.paint(g2);
        bconfig.paint(g2);
        gameMenu.paint(g2);
        won.paint(g2);
        //if dead, paints version two of stats.
        if (dead == true && stats.checkIfGameOver() == true) {
            stats.paintV3(g2);

        }
        else if (dead) {
            stats.paintV2(g2);

        }
        else {
            stats.paint(g2);
        }
        */

    }

    private class ButtonClickListener implements ActionListener {
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


}
