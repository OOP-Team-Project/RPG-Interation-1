package com.oop1.view;

import com.oop1.engine.Engine;
import com.oop1.entity.Entity;
import com.oop1.entity.Smasher;
import com.oop1.entity.Sneak;
import com.oop1.entity.Summoner;
import com.oop1.map.Decal;
import com.oop1.map.Map;
import com.oop1.map.TerrainType;
import com.oop1.map.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CharacterCreationView extends JPanel {

    private JLabel headerLabel;
    private JLabel statusLabel;

    private JButton okButton;
    private JButton submitButton;
    private JButton cancelButton;

    private boolean testVariable = false;
    private boolean shouldHide = false;

    private void MainMenuView(){
        this.setLayout(new FlowLayout());
    }

    private void initializeMenu(){
        if(testVariable == false){

            headerLabel = new JLabel("",JLabel.CENTER );
            statusLabel = new JLabel("",JLabel.CENTER);

            statusLabel.setSize(350,100);

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

            testVariable = true;
        }


        //this.add(headerLabel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        if(testVariable == false)
            initializeMenu();
        if(shouldHide == true){
            this.remove(headerLabel);
            this.remove(okButton);
            this.remove(submitButton);
            this.remove(cancelButton);
            this.remove(statusLabel);
        }

        //g.drawRect(0, 0, 120, 120);

    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            Map defaultMap = Map.generateMap(); //Maybe try just plain old "= new Map()"?
            Tile[][] defaultTiles = new Tile[50][50];

            for(int i = 0; i < 50; i++){
                for(int j = 0; j < 50; j++){
                    defaultTiles[i][j] = new Tile(TerrainType.GRASS);
                    defaultTiles[i][j].setDecal(new Decal());
                }
            }
            defaultMap.setTiles(defaultTiles);

            Entity newEntity;

            if( command.equals( "Smasher!" ))  {
                newEntity = new Entity(new Smasher(), defaultMap.getTileAtCoordinates(25, 25));
            }
            else if( command.equals( "Summoner!" ) )  {
                newEntity = new Entity(new Summoner(), defaultMap.getTileAtCoordinates(25, 25));
            }
            else  {
                newEntity = new Entity(new Sneak(), defaultMap.getTileAtCoordinates(25, 25));
            }
            //--    -   -   -   -   -   -   -   -
            ArrayList<JPanel> defaultViews = new ArrayList<JPanel>();

            defaultViews.add(new AreaView(defaultMap));
            //defaultViews.add(new EntityView(newEntity)); //I'm guessing that, actually, the AreaView() will have these, right?
            //--    -   -   -   -   -   -   -   -


            //--    -   -   -   -   -   -   -   -
            ArrayList<Entity> defaultEntities = new ArrayList<Entity>();
            defaultEntities.add(newEntity);
            //--    -   -   -   -   -   -   -   -

            //--    -   -   -   -   -   -   -   -
            ArrayList<Map> defaultMaps = new ArrayList<Map>();
            defaultMaps.add(defaultMap);
            //--    -   -   -   -   -   -   -   -

            Engine.beginGame(defaultViews, defaultMaps, defaultEntities);

            shouldHide = true;
        }
    }

}
