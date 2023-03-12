package game;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Your main game entry point
 */
public class Game {


    private static GameView view;
    private static MainWorld mainWorld;

    /**
     * Initialise a new Game.
     */
    public Game() {
        mainWorld = new MainWorld();

        view = new GameView(mainWorld, 800, 480);
        loadWorld(view);

        GiveFocus focusChecker = new GiveFocus(view);
        view.addMouseListener(focusChecker);
        //4. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("Phase Switch");
        frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view

        // view.setGridResolution(1);

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
        ArrayList<Point> collectedPoints = Game.getMainWorld().student.getCollectedFlippers();
        collectedPoints.stream().filter(n -> !n.getState()).forEach(n -> n.setState(false));
        Game.getMainWorld().student.setCollectedFlippers(collectedPoints);
    }

    public static void loadWorld(GameView view) {
        view.getWorld().stop();

        mainWorld = new MainWorld();

        view.setWorld(mainWorld);
        StudentController controllerOne = new StudentController(Game.getMainWorld().student);
        view.addKeyListener(controllerOne);
        mainWorld.start();
    }

    public void resetGame() {
        view.getWorld().stop();
        loadWorld(Game.getView());
    }

    public static MainWorld getMainWorld() {
        return mainWorld;
    }
}