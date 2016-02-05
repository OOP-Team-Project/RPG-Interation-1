package com.oop1;
import com.oop1.view.AreaView;

import javax.swing.*;
import java.util.Scanner;

public class RunGame {

      //private AreaView displayArea = new AreaView();

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    AreaView displayArea = new AreaView();
                    (displayArea.gameFrame).setVisible(true);
                }
            });
    }
}
