package com.oop1;
import com.oop1.engine.GameState;
import com.oop1.io.SaveManager;
import com.oop1.view.AreaView;
import com.oop1.view.DecalView;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import com.oop1.engine.*;
import com.oop1.view.*;

public class RunGame implements Runnable {

    static Engine engine;   //The game engine that is running the program.
    //private JFrame mainFrame;   //This is the main Java Swing frame. It holds a whooole bunch of JPanels that comprise
                                // of the multitude of views.

    public RunGame(){   //Constructor for this class.

    }


    public static void main(String[] args) throws IOException {    //This is the main function. It all starts here, folks!

        //Initially, we have a blank gameState (one that will likely be overridden by a load or new game operation.
        GameState initialGameState = new GameState();

        SaveManager sm = new SaveManager();
        GameState game = sm.loadGame("map1.txt");
        sm.saveGame(game, "savedGame.txt");

        //Initially, we have only one view when the game boots up: a main menu view. The player can select a bunch of
        //  choices from here that will (probably) add in new views to be displayed.
        List<JPanel> initialList = new ArrayList<JPanel>();
        MainMenuView initialMenu = new MainMenuView(game);
        initialList.add(initialMenu);

        engine = new Engine(game, initialList);   //Assign gameState and views to this engine.

        Thread runner = new Thread(new RunGame(), "Main Thread");   //We then spin a thread that updates the game every so often.

        runner.start(); //And we start it!

        try{
            runner.join();  //We keep the main() function running until this thread is finished.
        } catch(Exception e){

        }

    }

    public void run() {
        //Display info about this particular thread
        while(true) {
            try {
                Thread.sleep(15);   //We update at approximately 66 Frames Per Second
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            engine.update();    //We let the engine do its thing, whatever that may be.
        }
    }

    /* -Miles: "this is not my code and it doesn't work so I'm gonna comment it out kthxbye"
    public static void main(String[] args) {
        JFrame gameFrame = new JFrame();
        gameFrame.setSize(1200, 600);
        gameFrame.setTitle("Game");
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AreaView displayArea = new AreaView();
                gameFrame.add(displayArea);
                gameFrame.setVisible(true);
            }
        });

*/

}
