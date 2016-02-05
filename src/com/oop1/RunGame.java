package com.oop1;
import com.oop1.view.AreaView;
import com.oop1.view.DecalView;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class RunGame {


    public static void main(String[] args) {
        JFrame gameFrame = new JFrame();
        gameFrame.setSize(1200, 600);
        gameFrame.setTitle("Game");
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
