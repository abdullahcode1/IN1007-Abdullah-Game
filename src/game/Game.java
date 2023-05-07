package game;

import game.worlds.FirstWorld;
import game.worlds.MainWorld;
import game.worlds.SecondWorld;
import game.worlds.ThirdWorld;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Your main game entry point
 */
public class Game {

private Levels world;
    private static GameView view;

    private static Levels levels;

    /**
     * Initialise a new Game.
     */

    public Game() {
        MainWorld mainWorld = new MainWorld();

        levels = new Levels();

        view = new GameView(mainWorld, 1000, 563, mainWorld.getBackground());
        levels.loadLevel(view, 0);

        GiveFocus focusChecker = new GiveFocus(view);
        view.addMouseListener(focusChecker);

        final JFrame frame = new JFrame("Phase Switch");
        frame.add(view);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.setResizable(false);

        frame.pack();

        frame.setVisible(true);


        view.requestFocus();
    }

    /**
     * Run the game.
     */
    public static void main(String[] args) {
        new Game();
    }

    public static GameView getView() {
        return view;
    }

    public static void resetStudent() {
        ArrayList<Point> collectedPoints = Game.getLevels().currentStudent.getCollectedFlippers();
        collectedPoints.stream().filter(n -> !n.getState()).forEach(n -> n.setState(false));
        Game.getLevels().currentStudent.setCollectedFlippers(collectedPoints);
    }

    public static Levels getLevels() {
        return levels;
    }

}