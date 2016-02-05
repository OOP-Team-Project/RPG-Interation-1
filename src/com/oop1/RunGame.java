package com.oop1;
import com.oop1.view.AreaView;
import com.oop1.view.DecalView;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class RunGame {

      //private AreaView displayArea = new AreaView();
     private Graphics2D g;

    public void draw(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AreaView displayArea = new AreaView();
                (displayArea.gameFrame).setVisible(true);
                //DecalView dv = new DecalView();
                //dv.draw(g);
            }
        });
    }

      public static void main(String[] args) {

          RunGame RG = new RunGame();
          RG.draw();

    }
}
