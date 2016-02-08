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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RunGame implements Runnable, WindowListener {

    JFrame gameWindow;
    AreaView areaView;
    Engine engine;

    public static void main(String[] args) {
        RunGame runner = new RunGame();
        runner.run();
    }

    public void run() {
        gameWindow = new JFrame("RPG Game");
        gameWindow.setSize(1100, 524);
        gameWindow.setMinimumSize(new Dimension(1350, 574));     // this makes the window stay large

        openMainMenu();

        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
        gameWindow.addWindowListener(this);
    }

    public void openMainMenu() {
        MainMenuView menuView = new MainMenuView(this);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(menuView);
        gameWindow.setContentPane(container);

    }

    public void createNewGame() {
        System.out.println("Opening character creation view");
        gameWindow.setContentPane(new CharacterCreationView(this));
        gameWindow.pack();
    }

    public void loadGame() throws IOException {
        System.out.println("Loading game");


        String saveName = getSaveName("What is the name of the save you want to load?");

        GameState game = null;
        try {
            game = SaveManager.getInstance().loadGameState(saveName);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(gameWindow, "No save with that name exists.");
            return;
        } catch (IOException e) {
            // if it's another kind of IOException give a more generic message.
            JOptionPane.showMessageDialog(gameWindow, "Failed to load save for unknown reason: " + e.getMessage());
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(gameWindow, "Something went wrong reading the save. Are you sure it's a real save file?");
            return;
        }
        engine = new Engine(game, this);
        startGame(engine);
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
        gameWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        gameWindow.setVisible(true);
    }

    public void startNewGame(Occupation o) throws IOException {
        System.out.println("Starting new game");
        GameState game = SaveManager.getInstance().createNewGameState(o);
        engine = new Engine(game, this);
        startGame(engine);
    }

    public void showMessage(boolean shouldEndGame) {
        if (shouldEndGame) {
            JOptionPane.showMessageDialog(gameWindow, "You died! Game over!");
            openMainMenu();
        }
        else {
            JOptionPane.showMessageDialog(gameWindow, "You lost a life");
        }
    }

    public void stateChanged(Engine engine) {
        //TODO do more stuff and or make this conditional
        areaView.didUpdate();
        areaView.requestFocus();
        gameWindow.validate();
        gameWindow.repaint();
        //gameWindow.revalidate();
    }

    public String getSaveName(String message) {
        String name = JOptionPane.showInputDialog(message);
        // the filename should only have letters and numbers
        return name == null ? name : name.replaceAll("[^a-zA-Z0-9]", "");
    }

    private void trySave() {
        boolean shouldRetry = true;
        while (shouldRetry) {
            try {
                String saveName = getSaveName("What would you like to name the save?");
                if (saveName == null) {
                    // user clicked cancel, so abort save
                    return;
                }
                if (saveName.equals("")) {
                    JOptionPane.showMessageDialog(gameWindow, "That is not a valid save name. Must be alphanumeric and non-empty.");
                } else {
                    SaveManager.getInstance().saveGame(engine.getState(), saveName);
                    shouldRetry = false;
                }
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(gameWindow, "Something went wrong saving the game.");
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) { //this is called when user hits close window button

        if (JOptionPane.showConfirmDialog(null, "Would you like to save?", "",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            trySave();
        } else {
            // just quit, do nothing
        }
        System.exit(0);
    }

    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
}
