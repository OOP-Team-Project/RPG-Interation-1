package com.oop1;

import com.oop1.engine.Controller;
import com.oop1.engine.Engine;
import com.oop1.engine.GameState;
import com.oop1.entity.Occupation;
import com.oop1.entity.Sneak;
import com.oop1.io.SaveManager;
import com.oop1.view.AreaView;
import com.oop1.view.CharacterCreationView;
import com.oop1.view.MainMenuView;
import com.oop1.view.StatusView;

import javax.swing.*;
import java.io.IOException;

public class RunGame implements Runnable {

    JFrame gameWindow;

    public static void main(String[] args) {
        RunGame runner = new RunGame();
        runner.run();
    }

    public void run() {
        gameWindow = new JFrame("RPG Game");
        gameWindow.setSize(800, 600);

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
    }

    public void startGame(Engine engine) {
        System.out.println("Starting game with engine " + engine);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(new AreaView(engine.getCurrentMap(), engine.getPlayer()));
        container.add(new StatusView(engine.getPlayer()));
        gameWindow.setContentPane(container);
        gameWindow.pack();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
    }

    public void startNewGame(Occupation o) throws IOException {
        System.out.println("Starting new game");
        GameState game = SaveManager.getInstance().createNewGameState(o);
        startGame(new Engine(game, this));
    }

    public void redraw() {
        gameWindow.repaint();
    }

    public void registerController(Controller controller) {
        gameWindow.getContentPane().addKeyListener(controller);
    }
}
