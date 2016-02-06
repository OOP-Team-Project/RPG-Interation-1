package com.oop1;
import com.oop1.engine.GameState;
import com.oop1.io.SaveManager;
import com.oop1.view.AreaView;
import com.oop1.view.DecalView;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class RunGame {


    public static void main(String[] args) throws IOException {
        SaveManager sm = new SaveManager();
        GameState game = sm.loadGame("testMap.txt");
        sm.saveGame(game, "savedGame.txt");

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


    }


}
