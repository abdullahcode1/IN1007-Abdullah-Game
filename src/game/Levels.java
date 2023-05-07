package game;

import game.worlds.*;

import javax.swing.*;

public class Levels {
    int levelNumber;
    Student currentStudent;

    public Levels() {}

    public void loadLevel(GameView view, int level) {
        view.getWorld().stop();
        if(level == 0) {
            MainWorld mainWorld = new MainWorld();
            currentStudent = mainWorld.getStudent();
            view.setWorld(mainWorld);
        }
        if (level == 1) {
            FirstWorld firstWorld = new FirstWorld();
            currentStudent = firstWorld.getStudent();
            view.setWorld(firstWorld);
            view.setBackground(new ImageIcon(firstWorld.getBackground()).getImage());

        } else if (level == 2) {
            SecondWorld secondWorld = new SecondWorld();
            currentStudent = secondWorld.getStudent();
            view.setWorld(secondWorld);
            view.setBackground(new ImageIcon(secondWorld.getBackground()).getImage());
        } else if (level == 3) {
            ThirdWorld thirdWorld = new ThirdWorld();
            currentStudent = thirdWorld.getStudent();
            view.setWorld(thirdWorld);
            view.setBackground(new ImageIcon(thirdWorld.getBackground()).getImage());

        } else if (level == 4) {
            FinalWorld finalWorld = new FinalWorld();
            currentStudent = finalWorld.getStudent();
            view.setWorld(finalWorld);
            view.setBackground(new ImageIcon(finalWorld.getBackground()).getImage());
        }

        view.addKeyListener(new StudentController(currentStudent));
        view.getWorld().start();
    }

    public void unloadLevel(GameView view) {
        view.getWorld().stop();
    }

    public void setCurrentLevel(int newLevelNumber) {
        levelNumber = newLevelNumber;
        unloadLevel(Game.getView());
        loadLevel(Game.getView(), levelNumber);
    }

    public void resetLevel() {
        currentStudent.getCollectedFlippers()
                .stream()
                .filter(n -> !n.getState())
                .forEach(n -> n.setState(false));
    }

    public void deadStudent() {
        setCurrentLevel(1);
    }
}
