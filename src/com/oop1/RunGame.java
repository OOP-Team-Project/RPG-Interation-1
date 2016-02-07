package com.oop1;

import com.oop1.engine.Controller;
import com.oop1.engine.Engine;
import com.oop1.engine.GameState;
import com.oop1.entity.Occupation;
import com.oop1.io.SaveManager;
import com.oop1.view.AreaView;
import com.oop1.view.CharacterCreationView;
import com.oop1.view.MainMenuView;
import com.oop1.view.StatusView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RunGame implements Runnable {

    JFrame gameWindow;
    AreaView areaView;

    public static void main(String[] args) {
        RunGame runner = new RunGame();
        runner.run();
    }

    public void run() {
        gameWindow = new JFrame("RPG Game");
        gameWindow.setSize(1100, 524);
        gameWindow.setMinimumSize(new Dimension(1350, 574));     //this makes the window stay large
        MainMenuView menuView = new MainMenuView(this);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(menuView);
        gameWindow.setContentPane(container);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
    }

    public void createNewGame() {
        System.out.println("Opening character creation view");
        gameWindow.setContentPane(new CharacterCreationView(this));
        gameWindow.pack();
        gameWindow.setMinimumSize(new Dimension(1350, 574));     //this makes the window stay large
//        gameWindow.setPreferredSize(new Dimension(1100, 524));
    }

    public void loadGame() throws IOException {
        System.out.println("Loading game");
        GameState game = SaveManager.getInstance().loadGameState();
        startGame(new Engine(game, this));
    }

    public void startGame(Engine engine) {
        System.out.println("Starting game with engine " + engine);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        Controller newController = new Controller();
        engine.setController(newController);
        areaView = new AreaView(engine.getCurrentMap(), engine.getPlayer(), newController);
        areaView.requestFocus();
        container.add(areaView);
        container.add(new StatusView(engine.getPlayer()));
        engine.beginGame();
        gameWindow.setContentPane(container);
        gameWindow.setResizable(false);
        gameWindow.pack();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
    }

    public void startNewGame(Occupation o) throws IOException {
        System.out.println("Starting new game");
        GameState game = SaveManager.getInstance().createNewGameState(o);
        startGame(new Engine(game, this));
    }

    public void stateChanged(Engine engine){
        //TODO do more stuff and or make this conditional
        areaView.didUpdate();
        areaView.requestFocus();
        gameWindow.repaint();
    }
}
