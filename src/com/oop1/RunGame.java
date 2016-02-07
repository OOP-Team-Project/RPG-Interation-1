package com.oop1;

import com.oop1.engine.Controller;
import com.oop1.engine.Engine;
import com.oop1.engine.GameState;
import com.oop1.entity.Occupation;
import com.oop1.io.SaveManager;
import com.oop1.view.AreaView;
import com.oop1.view.CharacterCreationView;
import com.oop1.view.SaveMenuView;
import com.oop1.view.MainMenuView;
import com.oop1.view.StatusView;

import javax.swing.*;
import java.io.IOException;

public class RunGame implements Runnable {

    JFrame gameWindow;
    AreaView areaView;
    GameState game;

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

    public void loadGame() throws IOException {
        System.out.println("Loading game");
        game = SaveManager.getInstance().loadGame("saved.txt");
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
        game = SaveManager.getInstance().createNewGameState(o);
        startGame(new Engine(game, this));
    }

    public void stateChanged(Engine engine){
        //TODO do more stuff and or make this conditional
        areaView.didUpdate();
        areaView.requestFocus();
        gameWindow.repaint();
    }

    //opens up the main menu during game play
    public void pauseMenu() {
        System.out.print("Opening pause menu!");
        gameWindow.setContentPane(new SaveMenuView(this));
        gameWindow.pack();
    }

    //saves and resumes game
    public void saveGame() throws IOException {
        try {
            SaveManager.getInstance().saveGame(game, "saved.txt");
        } catch (IOException e1) {e1.printStackTrace();}
        game = SaveManager.getInstance().loadGame("saved.txt");
        startGame(new Engine(game, this));
    }

    //resumes gameplay without saving
    public void resumeGame() throws IOException {
        try {
            SaveManager.getInstance().saveGame(game, "temp.txt");
        } catch (IOException e1) {e1.printStackTrace();}
        game = SaveManager.getInstance().loadGame("temp.txt");
        startGame(new Engine(game, this));
    }
}
