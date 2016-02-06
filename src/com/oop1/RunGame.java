package com.oop1;

import com.oop1.engine.Engine;
import com.oop1.entity.Sneak;
import com.oop1.view.AreaView;
import com.oop1.view.StatusView;

import javax.swing.*;

public class RunGame {
    public static void main(String[] args) {
        JFrame gameWindow = new JFrame("RPG Game");
        gameWindow.setSize(800, 600);

        Engine engine = new Engine();
        engine.beginGame(new Sneak());

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(new AreaView());
        container.add(new StatusView(engine.getGameState().getAvatar()));
        gameWindow.setContentPane(container);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
    }
}
